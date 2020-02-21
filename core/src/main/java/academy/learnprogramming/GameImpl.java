package academy.learnprogramming;

import academy.learnprogramming.qualifiers.GuessCount;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Getter
@Component
public class GameImpl implements Game {

    @Getter(AccessLevel.NONE)
    private final NumberGenerator numberGenerator;
    @Setter
    private int guess;
    private final int guessCount;
    private int number;
    private int smallest;
    private int largest;
    private int remainingGuesses;
    private boolean validNumberRange = true;


    @Autowired
    public GameImpl(NumberGenerator numberGenerator, int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    @Override
    @GuessCount
    public int getGuessCount() {
        return guessCount;
    }

    @PostConstruct
    @Override
    public void reset() {
        guess = numberGenerator.getMinNumber();
        remainingGuesses = guessCount;
        smallest = numberGenerator.getMinNumber();
        largest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("the number is {}", number);
    }

    @PreDestroy
    public void preDestroy() {
        log.info("in Game preDestroy");
    }

    @Override
    public void check() {
        checkValidNumberRange();
        if (validNumberRange) {
            if (guess > number) {
                largest = guess - 1;
            }

            if (guess < number) {
                smallest = guess + 1;
            }

            remainingGuesses--;
        }
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    // == private methods ==

    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= largest);
    }
}
