package com.solvd.exceptions;

import org.apache.log4j.Logger;

public class OnlineShopEmptyTitleException extends IllegalArgumentException{
    public static final String EMPTY_TITLE_MESSAGE = "empty title is not allowed";

    public static void check(String title, Logger LOGGER) {
        if(title.equals("")){
            LOGGER.error(OnlineShopEmptyTitleException.EMPTY_TITLE_MESSAGE);
            throw new OnlineShopEmptyTitleException();
        }
    }

    public OnlineShopEmptyTitleException(){}

    public OnlineShopEmptyTitleException(String message) {
        super(message);
    }

    public OnlineShopEmptyTitleException(String message, Throwable cause) {
        super(message, cause);
    }

    public OnlineShopEmptyTitleException(Throwable cause) {
        super(cause);
    }
}
