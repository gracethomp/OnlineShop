package exceptions;

public class FullNameNotMatchRegexException extends IllegalArgumentException{
    public static final String MESSAGE = "name or surname has wrong arguments";

    public FullNameNotMatchRegexException(){}

    public FullNameNotMatchRegexException(String message) {
        super(message);
    }

    public FullNameNotMatchRegexException(String message, Throwable cause){
        super(message, cause);
    }

    public FullNameNotMatchRegexException(Throwable cause) {
        super(cause);
    }
}
