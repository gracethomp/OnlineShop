package com.solvd.exceptions;

public class NotMatchRegexException extends IllegalArgumentException{
    public static final String MESSAGE_FULL_NAME = "name or surname has wrong arguments";
    public static final String MESSAGE_EMAIL = "email doesn't match regex statement";
    public static final String MESSAGE_PHONE = "phone number is wrong";
    public static final String MESSAGE_PASSWORD = "password doesn't match regex statement";

    public NotMatchRegexException(){}

    public NotMatchRegexException(String message) {
        super(message);
    }

    public NotMatchRegexException(String message, Throwable cause){
        super(message, cause);
    }

    public NotMatchRegexException(Throwable cause) {
        super(cause);
    }
}
