package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MessageGeneratorImpl implements MessageGenerator {

    private final static Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);
    private final Game game;

    @Autowired
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    @PostConstruct /* componentDidMount */
    public void logValue() {
        log.info("game = {}", game);
    }

    @Override
    public String getMainMessage() {
        return "Number is between " +
                game.getSmallest() +
                " and " +
                game.getLargest() +
                ". Can you guess?";
    }

    @Override
    public String getResultMessage() {
        return game.isGameWon() ? "You guess it! The number was " + game.getNumber() :
            game.isGameLost() ? "You lost. The game was " + game.getNumber() :
                !game.isValidNumberRange() ? "Invalid number range!" :
                    game.getRemainingGuesses() == game.getGuessCount() ? "What is your first guess?" :
                        game.getGuess() < game.getNumber() ?
                            "Higher! You have " + game.getRemainingGuesses() + " guesses left" :
                            "Lower! You have " + game.getRemainingGuesses() + " guesses left";
    }
}
