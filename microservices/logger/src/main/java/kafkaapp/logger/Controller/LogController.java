package kafkaapp.logger.Controller;

import kafkaapp.logger.models.LogDto;
import kafkaapp.logger.models.LogItem;
import kafkaapp.logger.service.LogService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public List<LogDto> getLogs() {
        return logService.getLogs().stream()
                .map(LogDto::fromModel)
                .toList();
    }

    @GetMapping("/{serviceName}")
    public List<LogDto> getLogsFromService(@PathVariable String serviceName) {
        return logService.getLogsByServiceName(serviceName).stream()
                .map(LogDto::fromModel)
                .toList();
    }
}
