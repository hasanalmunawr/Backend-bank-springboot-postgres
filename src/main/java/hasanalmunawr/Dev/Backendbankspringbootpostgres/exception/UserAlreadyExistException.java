package hasanalmunawr.Dev.Backendbankspringbootpostgres.exception;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String message) {
        super(message);
    }

    public UserAlreadyExistException() {
        super("User already exists");
    }
}
