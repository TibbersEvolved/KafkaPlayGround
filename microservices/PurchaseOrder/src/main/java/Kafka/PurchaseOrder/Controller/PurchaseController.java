package Kafka.PurchaseOrder.Controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PurchaseController {


    @GetMapping("/ping")
    public LocalDateTime ping() {
        return LocalDateTime.now();
    }
}
