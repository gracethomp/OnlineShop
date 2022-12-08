package com.solvd.exceptions;

public class OnlineShopNegativeValuesException extends IllegalArgumentException{
    public static final String NEGATIVE_VALUE_MESSAGE = "negative values is now allowed here";

    public OnlineShopNegativeValuesException(){}

    public OnlineShopNegativeValuesException(String message) {
        super(message);
    }

    public OnlineShopNegativeValuesException(String message, Throwable cause) {
        super(message, cause);
    }

    public OnlineShopNegativeValuesException(Throwable cause) {
        super(cause);
    }
}
