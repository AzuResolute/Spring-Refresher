package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {

    private final static Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    @Autowired
    private Game game;
    private int guessCount = 10;

    @PostConstruct /* componentDidMount */
    public void logValue() {
        log.info("game = {}", game);
    }

    @Override
    public String getMainMessage() {
        return "Main Message Received";
    }

    @Override
    public String getResultMessage() {
        return "Result Message Received";
    }
}
