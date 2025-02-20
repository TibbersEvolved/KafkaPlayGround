package erikolin.kafkaplayground.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import erikolin.kafkaplayground.model.Greeting;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class MessageProducer {

    private final String SERVICE_NAME = "GreeterService";
    private final KafkaTemplate<String, String> template;
    private final ObjectMapper mapper;
    private final NewTopic topic;

    public MessageProducer(KafkaTemplate<String, String> template, NewTopic topic) {
        this.template = template;
        this.mapper = new ObjectMapper();
        this.topic = topic;
        mapper.registerModule(new JavaTimeModule());

    }

    public void send(Greeting greeting) throws JsonProcessingException {
        UUID id = UUID.randomUUID();
        LogDto dto = new LogDto(id,greeting.getMessage() + " by " + greeting.getUser(),200, LocalDateTime.now(), SERVICE_NAME);
        final String json = mapper.writeValueAsString(dto);
        template.send("logging", id.toString(), json);
    }

    public void logError(String message) throws JsonProcessingException {
        UUID id = UUID.randomUUID();
        LogDto dto = new LogDto(id,message,400, LocalDateTime.now(), SERVICE_NAME);
        final String json = mapper.writeValueAsString(dto);
        template.send("logging", id.toString(), json);
    }
}
