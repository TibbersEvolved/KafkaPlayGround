package kafkaapp.logger.service;

import kafkaapp.logger.models.LogItem;
import kafkaapp.logger.repository.LogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    private LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public List<LogItem> getLogs() {
        return logRepository.getLogItems();
    }

    public List<LogItem> getLogsByServiceName(String serviceName) {
        return logRepository.getLogItemsByService(serviceName);
    }

    public void add(LogItem logItem) {
        logRepository.add(logItem);
    }

    public List<String> getServiceNames() {
        return  logRepository.getAllServiceNames();
    }
}
