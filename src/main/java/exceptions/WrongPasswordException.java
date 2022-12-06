package exceptions;

public class WrongPasswordException extends IllegalArgumentException{
    public static final String MESSAGE = "password doesn't match regex statement";

    public WrongPasswordException(){}

    public WrongPasswordException(String message) {
        super(message);
    }

    public WrongPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongPasswordException(Throwable cause) {
        super(cause);
    }
}
