import java.io.File;
import java.util.Scanner;

public class Main {
    private static Kart[][] cards = new Kart[4][4];

    public static void getRecord() {
        File file = new File("Record.bin");
        Scanner scanner = new Scanner(System.in);
        if (file.exists()) {
            System.out.println("There is a saved game.Do you want to continue recording?(Yes/No)");
            String reply = scanner.nextLine();

            if (reply.equalsIgnoreCase("Yes")) {
                Kart[][] savedGame = GameRecord.getRecord();
                if (savedGame != null) {
                    cards = savedGame;
                    return;
                }
            }
        }
        cards[0][0] = new Kart('E');
        cards[0][1] = new Kart('A');
        cards[0][2] = new Kart('B');
        cards[0][3] = new Kart('F');
        cards[1][0] = new Kart('G');
        cards[1][1] = new Kart('A');
        cards[1][2] = new Kart('D');
        cards[1][3] = new Kart('H');
        cards[2][0] = new Kart('F');
        cards[2][1] = new Kart('C');
        cards[2][2] = new Kart('D');
        cards[2][3] = new Kart('H');
        cards[3][0] = new Kart('E');
        cards[3][1] = new Kart('G');
        cards[3][2] = new Kart('B');
        cards[3][3] = new Kart('C');
        gameBoard();
    }

    public static void isGuess() {
        Scanner scanner = new Scanner(System.in);

        // İlk tahmin
        System.out.print("First Guess: (i and j) ");
        int i1 = scanner.nextInt();
        int j1 = scanner.nextInt();

        if (i1 < 0 || i1 >= 4 || j1 < 0 || j1 >= 4) {
            System.out.println("Invalid coordinates! Try again.");
            return;
        }

        cards[i1][j1].setGuess(true);
        gameBoard();

        System.out.print("Second Guess: (i and j) ");
        int i2 = scanner.nextInt();
        int j2 = scanner.nextInt();

        if (i2 < 0 || i2 >= 4 || j2 < 0 || j2 >= 4) {
            System.out.println("Invalid coordinates! Try again.");
            cards[i1][j1].setGuess(false);
            return;
        }

        if (i1 == i2 && j1 == j2) { // Aynı kartın iki kez seçilmesini engelledim
            System.out.println("You cannot pick the same card twice!");
            return;
        }

        cards[i2][j2].setGuess(true);

        gameBoard();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (cards[i1][j1].getCharacter() != cards[i2][j2].getCharacter()) {
            System.out.println("Not a match! Cards will be hidden...");
            cards[i1][j1].setGuess(false);
            cards[i2][j2].setGuess(false);
        }
        gameBoard();
    }

    public static boolean isGameOver() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (cards[i][j].isGuess() == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void gameBoard() {
        for (int i = 0; i < 4; i++) {
            System.out.println("-------------------");
            for (int j = 0; j < 4; j++) {
                if (cards[i][j].isGuess()) {
                    System.out.print(" |" + cards[i][j].getCharacter() + "| ");
                } else {
                    System.out.print(" | | ");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        getRecord();
        while (isGameOver() == false) {
            gameBoard();
            System.out.print("Press q to exit the game");
            String exit = scanner.nextLine().trim();
            if (exit.equalsIgnoreCase("q")) {
                System.out.print("Do you want to save the game? (Yes/No): ");
                String record = scanner.nextLine().trim();
                if (record.equalsIgnoreCase("Yes")) {
                    System.out.println("Saving game...");
                    GameRecord.gameRecord(cards);
                    System.out.println("Game saved!");
                } else {
                    System.out.println("You did not save the game");
                }
                System.out.println("Exiting the game....");
                break;
            }
            isGuess();

        }

    }
}