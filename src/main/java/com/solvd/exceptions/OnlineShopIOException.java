package com.solvd.exceptions;

import java.io.IOException;

public class OnlineShopIOException extends IOException {
    public static final String REVIEW_IO_EXCEPTION = "trouble with review file";
    public static final String SHOP_IO_EXCEPTION = "trouble with shop file";

    public OnlineShopIOException(){}

    public OnlineShopIOException(String message) {
        super(message);
    }

    public OnlineShopIOException(String message, Throwable cause){
        super(message, cause);
    }

    public OnlineShopIOException(Throwable cause) {
        super(cause);
    }

}
