package com.example.remontada.domains

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class SimulateMatchUseCase {
    operator fun invoke(userTeam: List<SquadMember>, bossTeam: List<SquadMember>, teamChemistry: Int): Flow<MatchEvent> = flow {
        var homeScore = 0
        var awayScore = 5
        var currentMaxMinute = 90

        val coach = userTeam.find { it.position == Position.COACH }
        val tacticalBuff = 1.0f + ((coach?.tactics ?: 0) * 0.003f) + (teamChemistry * 0.002f)

        val activePlayers = userTeam.filter { it.position != Position.COACH }
        val forwards = activePlayers.filter { it.position == Position.FORWARD }.ifEmpty { activePlayers }
        val midfielders = activePlayers.filter { it.position == Position.MIDFIELD }.ifEmpty { activePlayers }
        val defenders = activePlayers.filter { it.position == Position.DEFENDER }.ifEmpty { activePlayers }
        val gk = activePlayers.firstOrNull { it.position == Position.GOALKEEPER }?.name ?: "The Keeper"

        val attackStats = forwards.sumOf { it.stat1 + it.stat2 + it.stat3 } + midfielders.sumOf { it.stat1 + it.stat3 }
        val totalAttack = attackStats.toFloat() * tacticalBuff

        val defenseStats = defenders.sumOf { it.stat1 + it.stat2 + it.stat3 } + activePlayers.filter { it.position == Position.GOALKEEPER }.sumOf { it.stat1 + it.stat2 + it.stat3 }
        val totalDefense = defenseStats.toFloat() * tacticalBuff

        val bossAttack = 1850f
        val bossDefense = 1850f

        var minute = 1
        var formMultiplier = 1.0f
        var firstHalfGoals = 0

        while (minute <= currentMaxMinute) {
            delay(120)

            if (minute == 46) {
                // Form Modifier: If you played well in the first half, momentum shifts your way
                if (firstHalfGoals >= 2) {
                    formMultiplier = 1.15f
                    emit(MatchEvent("46", homeScore, awayScore, false, false, "SECOND HALF BEGINS. Your team is carrying massive momentum from the first half!"))
                }
            }

            if (minute == 90 && homeScore == awayScore) {
                emit(MatchEvent("90", homeScore, awayScore, false, false, "REFEREE BLOWS THE WHISTLE! Aggregate is tied. Heading to Extra Time!"))
                currentMaxMinute = 120
                delay(1500)
            }

            // --- THE LATE GAME BLITZ LOGIC ---
            // If trailing or tied late in the game, your team goes all-out attack
            val isLateGameBlitz = (minute in 75..90 || minute in 105..120) && homeScore <= awayScore
            val attackGenChance = if (isLateGameBlitz) 0.18f else 0.07f
            // 1. User Attack Check (Unpredictable Timing)
            if (Random.nextFloat() < attackGenChance) {
                val baseSuccess = totalAttack / (totalAttack + bossDefense)
                val finalSuccessChance = baseSuccess * formMultiplier * 0.88f

                val attacker = forwards.random()
                val assister = midfielders.random().name

                if (Random.nextFloat() < finalSuccessChance) {
                    homeScore++
                    if (minute <= 45) firstHalfGoals++
                    emit(MatchEvent(minute.toString(), homeScore, awayScore, true, false, "GOAL! ${attacker.name} smashes it home after a brilliant pass from $assister!", attacker.id))
                } else {
                    // Generate tension with a missed late-game flurry chance
                    val misses = listOf(
                        "Huge chance! ${attacker.name} fires it just wide of the post!",
                        "Incredible save by the Boss AI keeper to deny ${attacker.name}!",
                        "Desperate defending! Boss AI blocks a massive shot from $assister."
                    )
                    emit(MatchEvent(minute.toString(), homeScore, awayScore, false, false, misses.random()))
                }
                minute++
                continue
            }

            // 2. Boss AI Counter Attack Check
            val bossAttackChance = if (isLateGameBlitz) 0.06f else 0.05f // Boss AI sits back to defend your late blitz
            if (Random.nextFloat() < bossAttackChance) {
                val defenseChance = totalDefense / (totalDefense + bossAttack)
                if (Random.nextFloat() > (defenseChance + 0.44f)) { // Math tuned to ~12.5% overall win rate
                    awayScore++
                    emit(MatchEvent(minute.toString(), homeScore, awayScore, false, true, "DISASTER! The Boss AI scores on the counter-attack. A crushing blow."))
                    minute++
                    continue
                }
            }

            // 3. Ambient Commentary
            if (Random.nextFloat() < 0.10f) {
                val ambientComments = listOf(
                    "Tactical battle continues in midfield...",
                    "Great vision by ${midfielders.random().name} to switch the play.",
                    "Boss AI attacks, but ${defenders.random().name} makes a vital interception.",
                    "Solid possession spell by your team as they probe for an opening."
                )
                emit(MatchEvent(minute.toString(), homeScore, awayScore, false, false, ambientComments.random()))
            }

            minute++
        }

        // --- PENALTIES LOGIC ---
        if (homeScore == awayScore) {
            emit(MatchEvent("120", homeScore, awayScore, false, false, "EXTRA TIME IS OVER. IT ALL COMES DOWN TO A PENALTY SHOOTOUT!"))
            delay(2000)

            var userPens = 0
            var bossPens = 0

            for (i in 1..5) {
                delay(1200)
                val userScores = Random.nextFloat() < (0.65f + (tacticalBuff * 0.05f))
                val bossScores = Random.nextFloat() < 0.75f

                if (userScores) userPens++
                if (bossScores) bossPens++

                val userShooter = activePlayers.random()
                val userResultText = if(userScores) "SCORES" else "MISSES"
                val bossResultText = if(bossScores) "SCORES" else "MISSES"

                emit(MatchEvent("PEN", homeScore, awayScore, userScores, !bossScores && !userScores, "Round $i: ${userShooter.name} $userResultText! Boss AI $bossResultText.", userShooter.id))
            }

            while (userPens == bossPens) {
                delay(1200)
                emit(MatchEvent("PEN", homeScore, awayScore, false, false, "SUDDEN DEATH! Both teams are still tied!"))
                delay(1000)

                val userScores = Random.nextFloat() < (0.65f + (tacticalBuff * 0.05f))
                val bossScores = Random.nextFloat() < 0.75f

                if (userScores) userPens++
                if (bossScores) bossPens++

                val userShooter = activePlayers.random()
                val userResultText = if(userScores) "SCORES" else "MISSES"
                val bossResultText = if(bossScores) "SCORES" else "MISSES"

                emit(MatchEvent("PEN", homeScore, awayScore, userScores, !bossScores && !userScores, "Sudden Death: ${userShooter.name} $userResultText! Boss AI $bossResultText.", userShooter.id))
            }

            val userWon = userPens > bossPens
            val finalResult = if (userWon) "MIRACLE COMPLETE! YOU WIN $userPens-$bossPens ON PENALTIES!" else "HEARTBREAK. BOSS AI WINS $bossPens-$userPens ON PENALTIES."
            emit(MatchEvent("FT", homeScore, awayScore, userWon, !userWon, finalResult))

        } else {
            val userWon = homeScore > awayScore
            val finalResult = if (userWon) "THE REMONTADA IS COMPLETE! YOU DEFEATED THE BEST OF ALL TIME!" else "HEARTBREAK! YOUR TEAM FELL SHORT."
            emit(MatchEvent("FT", homeScore, awayScore, userWon, !userWon, finalResult))
        }
    }
}