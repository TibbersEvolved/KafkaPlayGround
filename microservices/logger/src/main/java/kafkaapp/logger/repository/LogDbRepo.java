package kafkaapp.logger.repository;

import kafkaapp.logger.models.LogItem;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogDbRepo extends ListCrudRepository<LogItem, Long> {
    List<LogItem> findAllByServiceName(String serviceName);
}
