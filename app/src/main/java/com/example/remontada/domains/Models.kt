package com.example.remontada.domains

enum class Position { FORWARD, MIDFIELD, DEFENDER, GOALKEEPER, COACH }
enum class GameScreen { WELCOME, DRAFTING, PRE_MATCH_SUMMARY, MATCH_SIMULATION, POST_MATCH }

data class SquadMember(
    val id: String,
    val name: String,
    val era: String,
    val position: Position,
    val nation: String,
    val clubId: String,
    val ovr: Int = 0,       // The actual, authentic FIFA Overall Rating
    val stat1: Int = 0,     // Maps to PAC, PAS, DEF, REF
    val stat2: Int = 0,     // Maps to SHO, STA, PHY, POS
    val stat3: Int = 0,     // Maps to DRI, VIS, AWA, HAN
    val tactics: Int = 0,
    val motivation: Int = 0
)

data class MatchEvent(
    val minute: String,
    val homeGoals: Int,
    val awayGoals: Int,
    val isGoal: Boolean,
    val isEnemyGoal: Boolean = false,
    val commentary: String,
    val mainActorId: String? = null
)

data class GameState(
    val currentScreen: GameScreen = GameScreen.WELCOME,
    val currentRolledClubName: String = "",
    val availableDraftOptions: List<SquadMember> = emptyList(),
    val draftedSquad: List<SquadMember> = emptyList(),
    val isRolling: Boolean = false,
    val playerRatings: Map<String, Double> = emptyMap(),
    val maxSlots: Map<Position, Int> = mapOf(
        Position.GOALKEEPER to 1,
        Position.DEFENDER to 4,
        Position.MIDFIELD to 3,
        Position.FORWARD to 3,
        Position.COACH to 1
    ),

    val currentMinute: Int = 0,
    val isExtraTime: Boolean = false,
    val isPenalties: Boolean = false,
    val homeScore: Int = 0,
    val awayScore: Int = 5,
    val liveCommentary: List<MatchEvent> = emptyList(),
    val isSimulating: Boolean = false,
    val matchFinished: Boolean = false,
    val matchMvp: SquadMember? = null,

    val teamRating: Int = 0,
    val teamChemistry: Int = 0
)