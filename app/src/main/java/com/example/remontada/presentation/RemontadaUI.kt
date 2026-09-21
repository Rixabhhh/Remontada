package com.example.remontada.presentation

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.remontada.domains.GameScreen
import com.example.remontada.domains.Position
import com.example.remontada.domains.SquadMember
import com.example.remontada.ui.theme.* // Make sure these match your Color.kt imports
import kotlin.collections.filter
import kotlin.collections.find
import kotlin.collections.getOrNull

@Composable
fun RemontadaApp(viewModel: RemontadaViewModel) {
    when (viewModel.state.currentScreen) {
        GameScreen.WELCOME -> WelcomeScreen { viewModel.startDraft() }
        GameScreen.DRAFTING -> DraftingScreen(viewModel)
        GameScreen.PRE_MATCH_SUMMARY -> PreMatchSummaryScreen(viewModel)
        GameScreen.MATCH_SIMULATION -> SimulationScreen(viewModel)
        GameScreen.POST_MATCH -> PostMatchScreen(viewModel)
    }
}

@Composable
fun WelcomeScreen(onStartDraft: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().background(DarkForestGreen).padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("LA REMONTADA", color = GoldAccent, fontSize = 42.sp, fontWeight = FontWeight.Black, fontFamily = FontFamily.SansSerif)
        Spacer(modifier = Modifier.height(8.dp))
        Text("TACTICAL ENGINE v2.0", color = MutedTextGreen, fontSize = 14.sp, fontFamily = FontFamily.Monospace)

        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = onStartDraft,
            colors = ButtonDefaults.buttonColors(containerColor = GoldAccent),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.fillMaxWidth().height(52.dp)
        ) {
            Text("INITIATE CLUB DRAFT", color = DarkForestGreen, fontWeight = FontWeight.Black, fontFamily = FontFamily.Monospace)
        }
    }
}

@Composable
fun DraftingScreen(viewModel: RemontadaViewModel) {
    val state = viewModel.state

    Column(modifier = Modifier.fillMaxSize().background(DarkForestGreen).padding(16.dp)) {

        FormationPitchCard(state.draftedSquad)

        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(MutedTextGreen))
        Spacer(modifier = Modifier.height(16.dp))

        if (state.isRolling) {
            Column(
                modifier = Modifier.fillMaxWidth().weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("SPINNING CLUB DATABASE...", color = GoldAccent, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(state.currentRolledClubName, color = CrispWhite, fontFamily = FontFamily.SansSerif, fontSize = 24.sp, fontWeight = FontWeight.Black)
            }
        } else {
            // 1. HEADER FIX: Added weight(1f) to the Club Name so it wraps without squishing the counter
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "CLUB: ${state.currentRolledClubName}",
                    color = CrispWhite,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Black,
                    fontFamily = FontFamily.SansSerif,
                    modifier = Modifier.weight(1f).padding(end = 12.dp) // <--- Fixes Header Overlap
                )
                Text(
                    text = "${state.draftedSquad.size}/12",
                    color = GoldAccent,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
            }
            Spacer(modifier = Modifier.height(12.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.weight(1f)) {
                items(state.availableDraftOptions) { member ->
                    val currentCount = state.draftedSquad.count { it.position == member.position }
                    val maxAllowed = state.maxSlots[member.position] ?: 0
                    val isAlreadyPicked = state.draftedSquad.any { it.id == member.id }
                    val isLocked = isAlreadyPicked || currentCount >= maxAllowed

                    val cardBg = if (isLocked) Color(0xFF1A1A1A) else DeepCardGreen
                    val textColor = if (isLocked) Color.DarkGray else CrispWhite

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(cardBg, shape = RoundedCornerShape(6.dp))
                            .border(1.dp, if (isLocked) Color.DarkGray else MutedTextGreen, RoundedCornerShape(6.dp))
                            .clickable(enabled = !isLocked) { viewModel.selectSquadMember(member) }
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // 2. LEFT SIDE FIX: Added weight(1f) so long names/nations wrap downward safely
                        Column(modifier = Modifier.weight(1f).padding(end = 12.dp)) {
                            Text(
                                text = member.name.uppercase(),
                                color = textColor,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.SansSerif,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "${member.position} • ${member.nation}",
                                color = if (isLocked) Color.DarkGray else MutedTextGreen,
                                fontSize = 12.sp,
                                fontFamily = FontFamily.Monospace,
                                lineHeight = 16.sp
                            )
                        }

                        // 3. RIGHT SIDE FIX: Unweighted, takes exact space needed. Text aligned to End.
                        Column(horizontalAlignment = Alignment.End) {
                            if (member.position == Position.COACH) {
                                Text(
                                    text = "TAC: ${member.tactics} | MOT: ${member.motivation}",
                                    color = if(isLocked) Color.Gray else GoldAccent,
                                    fontFamily = FontFamily.Monospace,
                                    fontWeight = FontWeight.Bold
                                )
                            } else {
                                Text(
                                    text = "OVR: ${member.ovr}",
                                    color = if(isLocked) Color.Gray else GoldAccent,
                                    fontFamily = FontFamily.Monospace,
                                    fontWeight = FontWeight.Black,
                                    fontSize = 20.sp,
                                    maxLines = 1
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = getPositionalStatsString(member),
                                    color = if(isLocked) Color.DarkGray else MutedTextGreen,
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.End // <--- Keeps wrapped stats looking neat
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

// Helper function to map the stat names dynamically
fun getPositionalStatsString(member: SquadMember): String {
    return when (member.position) {
        Position.FORWARD -> "PAC: ${member.stat1} | SHO: ${member.stat2} | DRI: ${member.stat3}"
        Position.MIDFIELD -> "PAS: ${member.stat1} | STA: ${member.stat2} | VIS: ${member.stat3}"
        Position.DEFENDER -> "DEF: ${member.stat1} | PHY: ${member.stat2} | AWA: ${member.stat3}"
        Position.GOALKEEPER -> "REF: ${member.stat1} | POS: ${member.stat2} | HAN: ${member.stat3}"
        else -> ""
    }
}

@Composable
fun FormationPitchCard(drafted: List<SquadMember>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
            .background(Color(0xFF0C2412), shape = RoundedCornerShape(8.dp)) // Deep Pitch Green
            .border(2.dp, MutedTextGreen.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
            .padding(8.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        PitchLineRow(drafted.filter { it.position == Position.FORWARD }, 3)
        PitchLineRow(drafted.filter { it.position == Position.MIDFIELD }, 3)
        PitchLineRow(drafted.filter { it.position == Position.DEFENDER }, 4)
        PitchLineRow(drafted.filter { it.position == Position.GOALKEEPER }, 1)

        // Coach Display at the bottom of the pitch
        val coach = drafted.find { it.position == Position.COACH }
        Row(modifier = Modifier.fillMaxWidth().padding(top = 4.dp), horizontalArrangement = Arrangement.Center) {
            Text("COACH: ${coach?.name ?: "None"}", color = GoldAccent, fontSize = 12.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun PitchLineRow(players: List<SquadMember>, maxSlots: Int) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        for (i in 0 until maxSlots) {
            val player = players.getOrNull(i)
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .size(14.dp)
                        .background(if (player != null) GoldAccent else Color.DarkGray, shape = RoundedCornerShape(50))
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = player?.name ?: "—",
                    color = CrispWhite,
                    fontSize = 11.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun PreMatchSummaryScreen(viewModel: RemontadaViewModel) {
    val state = viewModel.state
    Column(
        modifier = Modifier.fillMaxSize().background(DarkForestGreen).padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("TALE OF THE TAPE", color = GoldAccent, fontSize = 32.sp, fontWeight = FontWeight.Black, fontFamily = FontFamily.SansSerif)
        Spacer(modifier = Modifier.height(40.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("YOUR SQUAD", color = CrispWhite, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace)
                Spacer(modifier = Modifier.height(8.dp))
                Text("OVR: ${state.teamRating}", color = GoldAccent, fontSize = 28.sp, fontWeight = FontWeight.Black)
                Text("CHEM: ${state.teamChemistry}", color = GoldAccent, fontSize = 28.sp, fontWeight = FontWeight.Black)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("BOSS XI", color = Color(0xFFE53935), fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace)
                Spacer(modifier = Modifier.height(8.dp))
                Text("OVR: 98", color = Color(0xFFE53935), fontSize = 28.sp, fontWeight = FontWeight.Black)
                Text("CHEM: 100", color = Color(0xFFE53935), fontSize = 28.sp, fontWeight = FontWeight.Black)
            }
        }

        Spacer(modifier = Modifier.height(60.dp))

        Button(
            onClick = { viewModel.beginSimulation() },
            colors = ButtonDefaults.buttonColors(containerColor = GoldAccent),
            modifier = Modifier.fillMaxWidth().height(56.dp),
            shape = RoundedCornerShape(6.dp)
        ) {
            Text("ENTER THE PITCH", color = DarkForestGreen, fontWeight = FontWeight.Black, fontSize = 16.sp, fontFamily = FontFamily.Monospace)
        }
    }
}

@Composable
fun SimulationScreen(viewModel: RemontadaViewModel) {
    val state = viewModel.state
    Column(modifier = Modifier.fillMaxSize().background(DarkForestGreen).padding(24.dp)) {
        Text("MATCH SIMULATOR", color = GoldAccent, fontSize = 28.sp, fontWeight = FontWeight.Black, fontFamily = FontFamily.SansSerif)
        Spacer(modifier = Modifier.height(8.dp))
        Text(if (state.isSimulating) "LIVE AGGREGATE SCORE" else "SIMULATION PREPARING...", color = MutedTextGreen, fontSize = 12.sp, fontFamily = FontFamily.Monospace)

        Spacer(modifier = Modifier.height(16.dp))
        Text("YOUR TEAM  ${state.homeScore} vs ${state.awayScore}  BOSS AI", color = CrispWhite, fontSize = 24.sp, fontWeight = FontWeight.Black, fontFamily = FontFamily.SansSerif)

        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth().weight(1f).background(DeepCardGreen, RoundedCornerShape(8.dp)).border(1.dp, MutedTextGreen, RoundedCornerShape(8.dp)).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(state.liveCommentary) { event ->
                // Determine the exact color based on the event type
                val textColor = when {
                    event.isGoal -> GoldAccent
                    event.isEnemyGoal -> Color(0xFFE53935) // Deep Crimson Red for Boss AI goals
                    else -> CrispWhite
                }

                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
                    Text(
                        text = "${event.minute}' ",
                        color = if (event.isGoal || event.isEnemyGoal) textColor else MutedTextGreen,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        modifier = Modifier.width(42.dp)
                    )
                    Text(
                        text = event.commentary,
                        color = textColor,
                        fontSize = 14.sp,
                        fontWeight = if (event.isGoal || event.isEnemyGoal) FontWeight.Bold else FontWeight.Normal,
                        fontFamily = FontFamily.SansSerif
                    )
                }
            }
        }
        if (state.matchFinished) {
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { viewModel.proceedToPostMatch() },
                colors = ButtonDefaults.buttonColors(containerColor = GoldAccent),
                modifier = Modifier.fillMaxWidth().height(56.dp),
                shape = RoundedCornerShape(6.dp)
            ) {
                Text("VIEW MATCH RESULTS", color = DarkForestGreen, fontWeight = FontWeight.Black, fontSize = 16.sp, fontFamily = FontFamily.Monospace)
            }
        }

    }
}

@Composable
fun PostMatchScreen(viewModel: RemontadaViewModel) {
    val state = viewModel.state
    val userWon = state.homeScore > state.awayScore

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkForestGreen)
            .padding(16.dp)
    ) {
        // 1. RESULT HEADER
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = if (userWon) "REMONTADA COMPLETE" else "HEARTBREAK",
                color = if (userWon) GoldAccent else Color(0xFFE53935),
                fontSize = 28.sp,
                fontWeight = FontWeight.Black,
                fontFamily = FontFamily.SansSerif
            )
            Text("${state.homeScore} - ${state.awayScore}", color = CrispWhite, fontSize = 48.sp, fontWeight = FontWeight.Black)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 2. MVP CARD
        if (state.matchMvp != null) {
            Card(
                colors = CardDefaults.cardColors(containerColor = DeepCardGreen),
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("MATCH MVP", color = GoldAccent, fontSize = 12.sp, fontFamily = FontFamily.Monospace)
                    Text(state.matchMvp.name.uppercase(), color = CrispWhite, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text("RATING: ${"%.1f".format(state.playerRatings[state.matchMvp.id] ?: 0.0)}", color = Color.Green, fontWeight = FontWeight.Bold)
                }
            }
        }

        // 3. FULL PLAYER RATINGS LIST
        Text("PLAYER RATINGS", color = MutedTextGreen, fontSize = 14.sp, fontFamily = FontFamily.Monospace, modifier = Modifier.padding(bottom = 8.dp))

        LazyColumn(
            modifier = Modifier.weight(1f).fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(state.draftedSquad.filter { it.position != Position.COACH }) { player ->
                val rating = state.playerRatings[player.id] ?: 6.0
                val ratingColor = when {
                    rating >= 8.0 -> GoldAccent
                    rating >= 6.0 -> Color.Green
                    else -> Color(0xFFE53935)
                }

                Row(
                    modifier = Modifier.fillMaxWidth().background(DeepCardGreen, RoundedCornerShape(4.dp)).padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(player.name, color = CrispWhite, fontWeight = FontWeight.Medium)
                    Text(
                        text = "%.1f".format(rating),
                        color = ratingColor,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 4. RESTART BUTTON
        Button(
            onClick = { viewModel.resetGame() },
            colors = ButtonDefaults.buttonColors(containerColor = CrispWhite),
            modifier = Modifier.fillMaxWidth().height(56.dp),
            shape = RoundedCornerShape(6.dp)
        ) {
            Text("RESTART PROTOCOL", color = DarkForestGreen, fontWeight = FontWeight.Black)
        }
    }
}