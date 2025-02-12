package kafkaapp.logger.consumer;

import kafkaapp.logger.service.LogService;
import org.springframework.stereotype.Service;

@Service
public class LogConsumer {

    private final LogService logservice;

    public LogConsumer(LogService logservice) {
        this.logservice = logservice;
    }
}
