package kafkaapp.logger.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import kafkaapp.logger.service.LogService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Configuration
public class LogConsumer {

    private final LogService logService;
    private final ObjectMapper objectMapper;

    public LogConsumer(LogService logservice, ObjectMapper objectMapper) {
        this.logService = logservice;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(id = "myId", topics = "logging")
    public void consume(ConsumerRecord<String, String> record) {
        String message = record.value();
        System.out.println("message = " + message);
    }
}
