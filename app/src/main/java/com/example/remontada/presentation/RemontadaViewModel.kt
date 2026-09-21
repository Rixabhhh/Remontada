package com.example.remontada.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remontada.data.ClubDatabase
import com.example.remontada.domains.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RemontadaViewModel : ViewModel() {

    var state by mutableStateOf(GameState())
        private set

    private val allClubsPool = ClubDatabase.clubs
    private val bossTeam = ClubDatabase.bossTeamHistoryXI
    private val simulateMatchUseCase = SimulateMatchUseCase()

    // Resets the game to the initial welcome screen
    fun resetGame() {
        state = GameState()
    }

    fun startDraft() {
        state = state.copy(currentScreen = GameScreen.DRAFTING)
        rollNextClub()
    }

    private fun rollNextClub() {
        // Check if the squad is full (11 players + 1 coach = 12 members)
        if (state.draftedSquad.size == 12) {
            val chem = ChemistryEngine.calculateChemistry(state.draftedSquad)
            val rating = ChemistryEngine.calculateRating(state.draftedSquad)

            state = state.copy(
                currentScreen = GameScreen.PRE_MATCH_SUMMARY,
                teamRating = rating,
                teamChemistry = chem,
                isRolling = false
            )
            return
        }

        viewModelScope.launch {
            // Lock UI and hide current players during the slot machine spin
            state = state.copy(isRolling = true, availableDraftOptions = emptyList())
            val clubKeys = allClubsPool.keys.toList()

            // Slot Machine Animation Loop
            for (i in 1..12) {
                state = state.copy(currentRolledClubName = clubKeys.random())
                delay(60)
            }

            // Lock in the final club and extract the roster
            val finalClub = clubKeys.random()
            val roster = allClubsPool[finalClub] ?: emptyList()

            state = state.copy(
                currentRolledClubName = finalClub,
                availableDraftOptions = roster,
                isRolling = false
            )
        }
    }

    fun proceedToPostMatch() {
        state = state.copy(currentScreen = GameScreen.POST_MATCH)
    }

    fun selectSquadMember(member: SquadMember) {
        val currentCount = state.draftedSquad.count { it.position == member.position }
        val maxAllowed = state.maxSlots[member.position] ?: 0

        // Strict Validation: Ensure the position isn't maxed out and player isn't a duplicate
        if (currentCount < maxAllowed && state.draftedSquad.none { it.id == member.id }) {
            state = state.copy(draftedSquad = state.draftedSquad + member)
            rollNextClub()
        }
    }

    fun beginSimulation() {
        state = state.copy(currentScreen = GameScreen.MATCH_SIMULATION, isSimulating = true)

        viewModelScope.launch {
            // Track performance stats per player during the match
            val goalCounts = mutableMapOf<String, Int>()
            val assistCounts = mutableMapOf<String, Int>()
            val saveCounts = mutableMapOf<String, Int>()

            simulateMatchUseCase(
                state.draftedSquad,
                bossTeam,
                state.teamChemistry
            ).collect { event ->
                // Update UI state
                state = state.copy(
                    currentMinute = event.minute.toIntOrNull() ?: state.currentMinute,
                    homeScore = event.homeGoals,
                    awayScore = event.awayGoals,
                    liveCommentary = listOf(event) + state.liveCommentary
                )

                // Track Stats for the Post-Match Rating Engine
                if (event.isGoal && event.mainActorId != null) {
                    goalCounts[event.mainActorId] =
                        goalCounts.getOrDefault(event.mainActorId, 0) + 1
                }
            }

            // Calculate final performance ratings for every player
            val calculatedRatings = state.draftedSquad.associate { player ->
                val goals = goalCounts.getOrDefault(player.id, 0)
                val assists = assistCounts.getOrDefault(player.id, 0)
                val saves = saveCounts.getOrDefault(player.id, 0)

                // Use the new RatingEngine
                val rating = RatingEngine.calculatePlayerRating(
                    member = player,
                    goals = goals,
                    assists = assists,
                    saves = saves,
                    minutesPlayed = if (state.currentMinute >= 90) 90 else state.currentMinute
                )
                player.id to rating
            }

            // Determine MVP based on highest rating
            val mvpId = calculatedRatings.maxByOrNull { it.value }?.key
            val mvp = state.draftedSquad.find { it.id == mvpId }

            state = state.copy(
                isSimulating = false,
                matchFinished = true,
                matchMvp = mvp,
                playerRatings = calculatedRatings // Ensure this exists in your GameState
            )
        }
    }
}