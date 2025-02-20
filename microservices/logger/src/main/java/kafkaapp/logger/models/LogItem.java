package kafkaapp.logger.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
public class LogItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String message;
    private int statusCode;
    private LocalDateTime timestamp;
    private String serviceName;

    public LogItem(String message, int statusCode, LocalDateTime timestamp, String serviceName) {
        this.message = message;
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.serviceName = serviceName;
    }

    public LogItem() {
    }

    public static LogItem fromDto(LogDto dto) {
        return new LogItem(
                dto.message(),
                dto.statusCode(),
                dto.timestamp(),
                dto.serviceName()
        );
    }

    public static LogItem errorLog(String message) {
        return new LogItem(message, 500, LocalDateTime.now(), "Error");
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
