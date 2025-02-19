package kafkaapp.logger.models;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class LogItem {
    private UUID id;
    private String message;
    private int statusCode;
    private LocalDateTime timestamp;
    private String serviceName;

    public LogItem(UUID id, String message, int statusCode, LocalDateTime timestamp, String serviceName) {
        this.id = id;
        this.message = message;
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.serviceName = serviceName;
    }

    public static LogItem fromDto(LogDto dto) {
        return new LogItem(
                dto.id(),
                dto.message(),
                dto.statusCode(),
                dto.timestamp(),
                dto.serviceName()
        );
    }

    public static LogItem errorLog(String message) {
        return new LogItem(UUID.randomUUID(), message, 500, LocalDateTime.now(), "Error");
    }

    public UUID getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getServiceName() {
        return serviceName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LogItem logItem = (LogItem) o;
        return Objects.equals(id, logItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
