package erikolin.kafkaplayground.kafka;

import java.time.LocalDateTime;
import java.util.UUID;

public record LogDto(UUID id, String message, int statusCode, LocalDateTime timestamp, String serviceName) {
}
