package erikolin.kafkaplayground.controller;


import erikolin.kafkaplayground.model.Greeting;
import erikolin.kafkaplayground.service.DemoService;
import erikolin.kafkaplayground.web.DemoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class Controller {

    private DemoService demoService;

    public Controller(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DemoResponse> sayHello(@PathVariable String id) {
        Greeting greeting = demoService.greetUser(id);
        return ResponseEntity.ok(new DemoResponse(greeting.getMessage(), greeting.getUser(), LocalDateTime.now().toString()));
    }

}
