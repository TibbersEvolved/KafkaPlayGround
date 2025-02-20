package erikolin.kafkaplayground.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import erikolin.kafkaplayground.kafka.MessageProducer;
import erikolin.kafkaplayground.model.Greeting;
import erikolin.kafkaplayground.service.GreetingService;
import erikolin.kafkaplayground.web.DemoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class Controller {

    private GreetingService greetingService;
    private MessageProducer messageProducer;

    public Controller(GreetingService greetingService, MessageProducer messageProducer) {
        this.greetingService = greetingService;
        this.messageProducer = messageProducer;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DemoResponse> greetUser(@PathVariable String id) throws JsonProcessingException {
        Greeting greeting = greetingService.greetUser(id);
        messageProducer.send(greeting);
        return ResponseEntity.ok(new DemoResponse(greeting.getMessage(), greeting.getUser(), LocalDateTime.now().toString()));
    }

    

}
