package com.solvd.exceptions;

public class PaymentCardIllegalArgumentException extends IllegalArgumentException{
    public static final String MESSAGE_CARD_NUMBER = "card number is wrong";
    public static final String MESSAGE_DATE = "date in card number has illegal argument";
    public static final String MESSAGE_CVV = "CVV is incorrect";

    public PaymentCardIllegalArgumentException(){}

    public PaymentCardIllegalArgumentException(String message) {
        super(message);
    }

    public PaymentCardIllegalArgumentException(String message, Throwable cause){
        super(message, cause);
    }

    public PaymentCardIllegalArgumentException(Throwable cause) {
        super(cause);
    }
}
