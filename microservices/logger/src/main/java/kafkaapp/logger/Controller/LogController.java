package kafkaapp.logger.Controller;

import kafkaapp.logger.models.LogDto;
import kafkaapp.logger.models.LogDtoOutgoing;
import kafkaapp.logger.models.LogItem;
import kafkaapp.logger.service.LogService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LogController {

    private LogService logService;
    private LocalDateTime startTime;

    public LogController(LogService logService) {
        this.logService = logService;
        this.startTime = LocalDateTime.now();
    }

    @GetMapping("/ping")
    public LocalDateTime healthPing() {
        return startTime;
    }

    @GetMapping()
    public List<LogDtoOutgoing> getLogs() {
        return logService.getLogs().stream()
                .map(LogDtoOutgoing::fromModel)
                .toList();
    }

    @GetMapping("/services/{serviceName}")
    public List<LogDtoOutgoing> getLogsFromService(@PathVariable String serviceName) {
        return logService.getLogsByServiceName(serviceName).stream()
                .map(LogDtoOutgoing::fromModel)
                .toList();
    }

    @GetMapping("/services")
    public List<String> getLogsFromServices() {
        return logService.getServiceNames();
    }
}
