package academy.learnprogramming.console;

import academy.learnprogramming.AppConfig;
import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import academy.learnprogramming.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess the number game, activate!");

        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        NumberGenerator numGen = context.getBean(NumberGenerator.class);

        int number = numGen.next();

        log.info("randomly generated number = {}", number);

        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        log.info("getMainMessage = {}", messageGenerator.getMainMessage());
        log.info("getResultMessage = {}", messageGenerator.getResultMessage());

        Game game = context.getBean(Game.class);

        context.close();
    }
}
