package kafkaapp.logger.repository;

import kafkaapp.logger.models.LogItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LogRepository {

    private List<LogItem> logItems;

    public LogRepository() {
        this.logItems = new ArrayList<>();
    }

    public void add(LogItem logItem) {
        this.logItems.add(logItem);
    }

    public List<LogItem> getLogItems() {
        return logItems;
    }

    public List<LogItem> getLogItemsByService(String serviceName) {
        return logItems.stream()
                .filter(s -> s.getServiceName().equals(serviceName))
                .toList();
    }
}
