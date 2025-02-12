package kafkaapp.logger.models;

import java.time.LocalDateTime;
import java.util.UUID;

public record LogDto(UUID id, String message, int statusCode, LocalDateTime timestamp, String serviceName) {

    public LogItem buildFromModel() {
        return new LogItem(id, message, statusCode, timestamp, serviceName);
    }

    public static LogDto fromModel(LogItem logItem) {
        return new LogDto(logItem.getId(), logItem.getMessage(), logItem.getStatusCode(), logItem.getTimestamp(), logItem.getServiceName());
    }
}
