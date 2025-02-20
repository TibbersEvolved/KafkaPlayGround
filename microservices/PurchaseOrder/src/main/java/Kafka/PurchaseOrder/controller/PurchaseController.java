package Kafka.PurchaseOrder.controller;


import Kafka.PurchaseOrder.services.LoggingService;
import Kafka.PurchaseOrder.services.PurchaseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import models.PurchaseOrderDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PurchaseController {

    private final PurchaseService purchaseService;
    private final LoggingService loggingService;

    public PurchaseController(PurchaseService purchaseService, LoggingService loggingService) {
        this.purchaseService = purchaseService;
        this.loggingService = loggingService;
    }

    @GetMapping("/ping")
    public LocalDateTime ping() {
        return LocalDateTime.now();
    }

    @PostMapping("/purchases")
    public void processPurchaseOrder(@RequestBody PurchaseOrderDto purchaseOrderDto) {

    }

    @GetMapping("/test")
    public void test() throws JsonProcessingException {
        loggingService.log("Testing", 204);
    }
}
