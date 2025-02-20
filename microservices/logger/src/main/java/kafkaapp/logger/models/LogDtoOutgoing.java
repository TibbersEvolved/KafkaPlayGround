package kafkaapp.logger.models;

import java.time.LocalDateTime;
import java.util.UUID;

public record LogDtoOutgoing(UUID id, String message, int statusCode, String timestamp, String serviceName) {

    public static LogDtoOutgoing fromModel(LogItem logItem) {
        return new LogDtoOutgoing(logItem.getId(), logItem.getMessage(), logItem.getStatusCode(), logItem.getTimestamp().toString(), logItem.getServiceName());
    }

    public static String formatTimestamp(LocalDateTime localDateTime) {
        StringBuilder builder = new StringBuilder();
        builder.append(localDateTime.getYear() + "-"
                + localDateTime.getMonthValue() + "-" + localDateTime.getDayOfMonth());
        builder.append(" - Time: " + localDateTime.getHour() + ":" + localDateTime.getMinute() + ":" + localDateTime.getSecond());
        return builder.toString();
    }
}
