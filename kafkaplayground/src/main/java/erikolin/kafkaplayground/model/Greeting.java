package erikolin.kafkaplayground.model;

public class Greeting {
    private String message, user;

    public Greeting(String message, String user) {
        this.message = message;
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }
}
