package Kafka.PurchaseOrder.controller;


import Kafka.PurchaseOrder.services.LoggingService;
import Kafka.PurchaseOrder.services.PurchaseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import models.CartItem;
import models.Item;
import models.PurchaseOrderDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    public void processPurchaseOrder(@RequestBody PurchaseOrderDto purchaseOrderDto) throws JsonProcessingException {
        purchaseService.handlePurchase(purchaseOrderDto);
    }

    @GetMapping("/test")
    public PurchaseOrderDto test() throws JsonProcessingException {
        List<CartItem> items = new ArrayList<>();
        items.add(new CartItem(new Item(20,"Cake","Baked Goods"), 6));
        items.add(new CartItem(new Item(6,"Chocolate","Candy"), 6));
        items.add(new CartItem(new Item(20,"Muffin","Baked Goods"), 12));
        return new PurchaseOrderDto(items,"Erik");
    }
}
