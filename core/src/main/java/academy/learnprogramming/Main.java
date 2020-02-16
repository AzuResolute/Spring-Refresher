package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the number game, activate!");

        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        NumberGenerator numGen = context.getBean("numberGenerator", NumberGenerator.class);

        int number = numGen.next();

        log.info("randomly generated number = {}", number);

        context.close();
    }
}
