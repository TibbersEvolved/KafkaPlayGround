package Kafka.PurchaseOrder.services;

import Kafka.PurchaseOrder.kafka.LogDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class LoggingService {

    private final String SERVICE_NAME = "PurchaseOrderService";
    private final KafkaTemplate<String, String> template;
    private final ObjectMapper objectMapper;


    public LoggingService(KafkaTemplate<String, String> template, ObjectMapper objectMapper) {
        this.template = template;
        this.objectMapper = objectMapper;
    }

    public void log(String message, int code) throws JsonProcessingException {
        UUID id = UUID.randomUUID();
        LogDto dto = new LogDto(id, message,code, LocalDateTime.now(), SERVICE_NAME);
        final String json = objectMapper.writeValueAsString(dto);
        template.send("logging", id.toString(), json);
    }
}
