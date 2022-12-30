package com.solvd.threads;

import org.apache.log4j.Logger;

public class MyThreadImplementation implements Runnable{
    private static final Logger LOGGER = Logger.getLogger(MyThreadImplementation.class);
    @Override
    public void run() {
        LOGGER.info("Hello, I'm " + Thread.currentThread().getName());
    }
}
