# ⚽ Algorithmic Sports Match Simulator (Project Remontada)

A highly technical, probability-driven football (soccer) management and drafting simulator built natively for Android. This project replaces traditional "pay-to-win" sports mechanics with a hardcore, mathematically calibrated simulation engine designed to deliver a highly addictive, challenging single-player experience.

The engine restricts the baseline player win probability to **~12.5%**, utilizing variable-ratio behavioral psychology so that every late-game comeback (a *Remontada*) feels like a monumental, hard-earned achievement.

---

## ✨ Core Features

* **Constraint-Based Drafting System:** Build a 12-man squad from a database of 15 authentic historical and modern super-teams (e.g., *PSG 2025-26, Atlético Madrid 20-21, Manchester United '99*). Features strict positional locking and chemistry link modifiers.
* **The Chaos Match Engine:** A custom, tick-based coroutine simulation loop. It evaluates position-specific stats (e.g., Forwards: PAC/SHO/DRI) against a hardcoded "Boss AI" composed of prime historical icons.
* **Dynamic Match State:** Includes a "Late Game Blitz" mechanic that drastically alters attack generation algorithms after the 75th minute, momentum/form multipliers based on first-half performance, and full Extra Time / Penalty Shootout logic.
* **Algorithmic Post-Match Analytics:** Evaluates match events (goals, assists, defensive actions, minutes played) to generate a weighted Sofascore-style rating (0.0 to 10.0) for every drafted player, dynamically highlighting the Match MVP.
* **Responsive Edge-to-Edge UI:** Built entirely in Jetpack Compose. Features a custom 4-3-3 visual pitch representation, dynamic safe-area insets, and color-coded live commentary tickers (Gold for user goals, Crimson for enemy goals).

---

## 🏗️ Architecture & Tech Stack

This application strictly enforces **Clean Architecture** principles, decoupling the UI from the simulation mathematics to allow for future backend scaling.

| Layer | Technology / Pattern | Purpose |
| --- | --- | --- |
| **Presentation** | Jetpack Compose, MVVM, StateFlow | Reactive, state-driven UI with fluid recomposition and scalable layout weights for diverse screen sizes. |
| **Domain** | Kotlin Coroutines, UseCases | Houses the `SimulateMatchUseCase`, `RatingEngine`, and core probability algorithms. Completely independent of Android frameworks. |
| **Data** | Repository Pattern, Static DB | Manages the `ClubDatabase` and authentic FIFA stat mapping. Structured for immediate migration to Firebase Firestore. |

---

## 🧮 The Mathematics of the Engine

To prevent the game from becoming a predictable stat-check, the core engine (`SimulateMatchUseCase.kt`) relies on dynamic probability scaling.

1. **Attack Generation:** The engine rolls for attack generation every in-game minute. Baseline generation sits at `8%`, but spikes to `18%` during the *Late Game Blitz* (Minutes 75-90).
2. **Conversion Probability:** When an attack is generated, the success rate is calculated using the user's combined attack stats versus the Boss AI's defense, modified by a tactical coach buff and team chemistry:
`Base Success = Total Attack / (Total Attack + Boss Defense)`
3. **The Aggression Tax:** Pushing for a late-game goal dynamically increases the Boss AI's counter-attack probability (from `3%` to `6%`), mirroring real-world tactical vulnerabilities.

---

## 🚀 Getting Started

### Prerequisites

* **Android Studio:** Koala Feature Drop (or newer) recommended.
* **JDK:** Java Development Kit 21 (JetBrains Runtime `jbr-21` is highly recommended for Gradle compatibility).
* **Gradle:** Version 8.13.

### Installation

1. Clone the repository:
```bash
git clone https://github.com/YourUsername/Algorithmic-Sports-Simulator.git

```


2. Open the project in Android Studio.
3. Ensure your Gradle JDK is explicitly set to **JDK 21** (`Settings > Build, Execution, Deployment > Build Tools > Gradle`).
4. Sync the project with Gradle files. *(Note: If you experience a `SocketTimeoutException` on restricted networks, manually download `gradle-8.13-bin.zip` and configure your `gradle-wrapper.properties` locally).*
5. Build and run on an emulator or physical device (API 26+).

---

## 🗺️ Roadmap: The Path to Multiplayer

The current Clean Architecture setup serves as the foundational sandbox for **Remontada v3.0**, which will introduce live 1v1 online multiplayer.

* [ ] **Data Migration:** Move `ClubDatabase` to Firebase Firestore to allow for live stat updates without app patches.
* [ ] **Lobby System:** Implement Firestore listeners for matchmaking and synchronized turn-based drafting.
* [ ] **Server-Side Simulation Authority:** Shift the `SimulateMatchUseCase` to Firebase Cloud Functions to prevent client-side manipulation, broadcasting `MatchEvents` back to both clients.
* [ ] **Persistent Manager Profiles:** Integrate Room Database / DataStore for local match history caching, win-rate tracking, and Manager XP.

THANK YOU <3 

