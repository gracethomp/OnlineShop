package com.solvd.threads;

import org.apache.log4j.Logger;

public class MyThreadExtension extends Thread{
    private static final Logger LOGGER = Logger.getLogger(MyThreadExtension.class);
    @Override
    public void run(){
        LOGGER.info("Hello, I'm " + Thread.currentThread().getName());
    }
}
