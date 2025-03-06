import java.io.Serializable;

public class Kart implements Serializable {

    private char character;
    private boolean guess = false;

    public Kart(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public boolean isGuess() {
        return guess;
    }

    public void setGuess(boolean guess) {
        this.guess = guess;
    }

}
