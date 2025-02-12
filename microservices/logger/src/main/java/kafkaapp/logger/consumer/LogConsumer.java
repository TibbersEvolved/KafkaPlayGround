package kafkaapp.logger.consumer;

import kafkaapp.logger.service.LogService;
import org.springframework.stereotype.Service;

@Service
public class LogConsumer {

    private final LogService logService;

    public LogConsumer(LogService logservice) {
        this.logService = logservice;
    }
}
