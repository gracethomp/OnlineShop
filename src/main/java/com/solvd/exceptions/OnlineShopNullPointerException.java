package com.solvd.exceptions;

import org.apache.log4j.Logger;

public class OnlineShopNullPointerException extends NullPointerException{
    public static final String TITLE_IS_NULL = "title is null";

    public static void checkTitle(String title, Logger LOGGER){
        if(title == null){
            LOGGER.error(OnlineShopNullPointerException.TITLE_IS_NULL);
            throw new OnlineShopNullPointerException();
        }
    }

    public OnlineShopNullPointerException(){}

    public OnlineShopNullPointerException(String message) {
        super(message);
    }
}
