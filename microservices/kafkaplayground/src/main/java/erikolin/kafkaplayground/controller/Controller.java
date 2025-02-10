package erikolin.kafkaplayground.controller;


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

    public Controller(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DemoResponse> greetUser(@PathVariable String id) {
        Greeting greeting = greetingService.greetUser(id);
        return ResponseEntity.ok(new DemoResponse(greeting.getMessage(), greeting.getUser(), LocalDateTime.now().toString()));
    }

}
