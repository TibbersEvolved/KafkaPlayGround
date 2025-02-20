package kafkaapp.logger.repository;

import kafkaapp.logger.models.LogItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LogRepository {

    private List<LogItem> logItems;
    private LogDbRepo logDbRepo;

    public LogRepository(LogDbRepo logDbRepo) {
        this.logItems = new ArrayList<>();
        this.logDbRepo = logDbRepo;
    }

    public void add(LogItem logItem) {
        logDbRepo.save(logItem);
    }

    public List<LogItem> getLogItems() {
        return logDbRepo.findAll();
    }

    public List<LogItem> getLogItemsByService(String serviceName) {
        return logItems.stream()
                .filter(s -> s.getServiceName().equals(serviceName))
                .toList();
    }
}
