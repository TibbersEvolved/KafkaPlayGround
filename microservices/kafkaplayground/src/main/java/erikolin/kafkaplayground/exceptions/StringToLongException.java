package erikolin.kafkaplayground.exceptions;

public class StringToLongException extends RuntimeException {
    public StringToLongException(String message) {
        super(message);
    }
}
