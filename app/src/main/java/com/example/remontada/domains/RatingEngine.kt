package com.example.remontada.domains

object RatingEngine {

    fun calculatePlayerRating(member: SquadMember, goals: Int, assists: Int, saves: Int, minutesPlayed: Int): Double {
        // Base rating starts at 6.0 (average)
        var rating = 6.0

        // Weightings: Goals/Assists have massive impact for attackers; Saves for GKs
        rating += (goals * 1.5)
        rating += (assists * 1.0)
        rating += (saves * 0.8)

        // Position-based modifiers:
        // Defenders get a boost for every 30 minutes without conceding
        if (member.position == Position.DEFENDER && minutesPlayed > 60) {
            rating += 0.5
        }

        // Final normalization to keep it between 0.0 and 10.0
        return rating.coerceIn(0.0, 10.0)
    }
}