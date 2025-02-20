package kafkaapp.logger.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LogDto(UUID id, String message, int statusCode, LocalDateTime timestamp, String serviceName) {



    public static LogDto fromModel(LogItem logItem) {
        return new LogDto(logItem.getId(), logItem.getMessage(), logItem.getStatusCode(), logItem.getTimestamp(), logItem.getServiceName());
    }
}
