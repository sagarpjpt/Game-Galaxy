# 🎮 Game Galaxy

**Game Galaxy** is a Java-based desktop application featuring a collection of interactive games—two single-player and two multiplayer—built using **JavaFX** and **Swing**. The application also connects to a **MySQL** database using **JDBC** to track and store player scores.

---

## 🧩 Games Included

### 🎲 Single Player Games
- **Snake Game** – built with JavaFX, classic arcade-style.
- **Java Quiz** – a multiple-choice quiz game using Swing components.

### 👥 Multiplayer Games
- **Tic Tac Toe** – a two-player turn-based game using Swing.
- **Paddle Game** – a Pong-style JavaFX game for two players.

---

## 🛠️ Tech Stack

- **Java SE**  
- **JavaFX** (for UI in modern games)  
- **Swing** (for classic UI games)  
- **JDBC** (Java Database Connectivity)  
- **MySQL** (for score persistence)

---

## 📁 Project Structure

```plaintext
GameGalaxy/
├── src/
│   ├── application/         # Application utilities or launcher
│   ├── database/            # JDBC connectivity for MySQL
│   ├── gamejavaquiz/        # Java Quiz (Single Player)
│   ├── gamepong/            # Paddle Game (Multiplayer)
│   ├── gamesnake/           # Snake Game (Single Player)
│   └── gametictactoe/       # Tic Tac Toe (Multiplayer)
├── bin/                     # Compiled classes
├── .classpath               # Eclipse/IDE config
├── .project                 # Eclipse/IDE config
├── .settings/               # IDE settings
└── build.fxbuild            # JavaFX build settings
```
---

## 🚀 How to Run
- Clone the Repository:
  ```
  git clone https://github.com/yourusername/GameGalaxy.git
  cd GameGalaxy
  ```

- Set up MySQL and import the scores table.

- Run in IDE:

  Open the project in Eclipse or IntelliJ.
  Make sure JavaFX is configured.

- Run the Main.java file from src/application/.
