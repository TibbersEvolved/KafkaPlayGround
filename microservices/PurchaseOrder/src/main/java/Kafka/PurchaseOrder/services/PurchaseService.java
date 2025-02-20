package Kafka.PurchaseOrder.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.CartItem;
import models.PurchaseOrderDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PurchaseService {

    private final LoggingService loggingService;
    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> template;

    public PurchaseService(LoggingService loggingService, ObjectMapper objectMapper, KafkaTemplate<String, String> template) {
        this.loggingService = loggingService;
        this.objectMapper = objectMapper;
        this.template = template;
    }

    public void handlePurchase(PurchaseOrderDto purchaseOrderDto) throws JsonProcessingException {
        String log = "Registered purchase order for " + purchaseOrderDto.customerName() + " for items worth: " + getTotalCost(purchaseOrderDto.cartItems());
        loggingService.log(log,200);
        String message = objectMapper.writeValueAsString(purchaseOrderDto);
        template.send("purchaseOrder", UUID.randomUUID().toString() ,message);
    }

    public float getTotalCost(List<CartItem> cartItems) {
        float totalCost = 0;
        for (CartItem cartItem : cartItems) {
            totalCost += cartItem.quantity()*cartItem.item().cost();
        }
        return totalCost;
    }
}
