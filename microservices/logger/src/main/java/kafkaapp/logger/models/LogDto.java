package kafkaapp.logger.models;

import java.time.LocalDateTime;
import java.util.UUID;

public record LogDto(UUID id, String message, int statusCode, LocalDateTime timestamp, String serviceName) {

    public LogItem buildFromModel() {
        return new LogItem(id, message, statusCode, timestamp, serviceName);
    }
}
