package com.example.remontada.domains

import com.example.remontada.domains.SquadMember
import kotlin.collections.filter
import kotlin.collections.find

object ChemistryEngine {

    fun calculateChemistry(squad: List<SquadMember>): Int {
        var totalLinks = 0
        val playersOnly = squad.filter { it.position != Position.COACH }

        for (i in playersOnly.indices) {
            for (j in i + 1 until playersOnly.size) {
                val p1 = playersOnly[i]
                val p2 = playersOnly[j]

                if (p1.clubId == p2.clubId) totalLinks += 3
                else if (p1.nation == p2.nation) totalLinks += 1
            }
        }

        val coach = squad.find { it.position == Position.COACH }
        val coachBonus = if (coach != null) (coach.motivation / 2) else 0

        val finalChemistry = (totalLinks * 2.5).toInt() + coachBonus
        return finalChemistry.coerceAtMost(100)
    }

    fun calculateRating(squad: List<SquadMember>): Int {
        val players = squad.filter { it.position != Position.COACH }
        if (players.isEmpty()) return 0

        // Directly averages the authentic FIFA OVRs
        return players.sumOf { it.ovr } / players.size
    }
}