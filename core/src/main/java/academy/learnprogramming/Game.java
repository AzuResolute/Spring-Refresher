package academy.learnprogramming;

public interface Game {
    int getNumber();
    int getGuess();
    void setGuess(int guess);
    int getGuessCount();
    int getSmallest();
    int getLargest();
    int getRemainingGuesses();
    void reset();
    void check();
    boolean isValidNumberRange();
    boolean isGameWon();
    boolean isGameLost();
}
