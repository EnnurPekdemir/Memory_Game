# Memory_Game

# Memory Card Matching Game

## Introduction
This is a simple Java-based memory card matching game where players try to match pairs of cards by guessing their positions on a 4x4 grid. The game includes a save and load feature, allowing players to continue from their last saved progress.

## Features
- **Card Matching Gameplay**: Players reveal two cards at a time and try to find matching pairs.
- **Save & Load Game**: The game state is automatically saved and can be loaded when restarting.
- **Validations**: Prevents invalid moves such as selecting the same card twice or entering out-of-bound coordinates.
- **Command-line Interface**: Simple and interactive console-based gameplay.

## How to Play
1. Run the program.
2. If a saved game exists, you will be asked if you want to continue.
3. Enter the coordinates of two cards to flip them.
4. If they match, they remain visible; otherwise, they will be hidden again.
5. Continue playing until all pairs are found.
6. Press `q` to quit the game anytime, with an option to save progress.

## Installation & Setup
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/memory-card-game.git
   ```
2. Navigate to the project folder:
   ```sh
   cd memory-card-game
   ```
3. Compile the Java files:
   ```sh
   javac Main.java
   ```
4. Run the game:
   ```sh
   java Main
   ```

## File Structure
```
├── Main.java         # Main game logic
├── Kart.java         # Card object with character & visibility state
├── GameRecord.java   # Handles saving and loading game state
└── Record.bin        # Binary file storing saved game data
```

## Technologies Used
- Java
- Object Serialization (for saving game state)
- File Handling

## Future Improvements
- Implement a graphical user interface (GUI) using Java Swing or JavaFX.
- Add difficulty levels with different grid sizes.
- Implement a multiplayer mode.

## License
This project is open-source and available under the MIT License.

---
### Author
[Ayşe Ennur Pekdemir - [GitHub Profile](https://github.com/EnnurPekdemir)

