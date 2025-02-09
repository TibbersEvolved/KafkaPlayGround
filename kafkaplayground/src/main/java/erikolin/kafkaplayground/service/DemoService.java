package erikolin.kafkaplayground.service;

import erikolin.kafkaplayground.model.Greeting;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DemoService {

    private List<String> phrases;
    private Random random;

    public DemoService() {
        phrases = new ArrayList<>();
        phrases.add("Hello World");
        phrases.add("How are you?");
        phrases.add("I'm going to sleep");
        random = new Random();
    }

    public Greeting greetUser(String username) {
        return new Greeting(phrases.get(random.nextInt(phrases.size())), username);
    }


}
