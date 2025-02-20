package kafkaapp.logger.repository;

import kafkaapp.logger.models.LogItem;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDbRepo extends ListCrudRepository<LogItem, Long> {
}
