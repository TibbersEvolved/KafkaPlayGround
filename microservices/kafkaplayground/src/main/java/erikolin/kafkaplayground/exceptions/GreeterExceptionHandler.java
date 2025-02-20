package erikolin.kafkaplayground.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import erikolin.kafkaplayground.kafka.MessageProducer;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GreeterExceptionHandler {

    private MessageProducer messageProducer;

    public GreeterExceptionHandler(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }


    @ExceptionHandler({StringToLongException.class})
    public ResponseEntity<String> handleInvalidFilterException(StringToLongException e) throws JsonProcessingException {
        messageProducer.logError(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
