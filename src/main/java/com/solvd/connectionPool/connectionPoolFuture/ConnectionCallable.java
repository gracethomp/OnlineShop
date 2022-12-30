package com.solvd.connectionPool.connectionPoolFuture;

import com.solvd.connectionPool.Connection;

import java.util.concurrent.Callable;

public class ConnectionCallable implements Callable<Connection> {
    private Connection connection;

    public ConnectionCallable(){}
    public ConnectionCallable(Connection connection) {
        this.connection = connection;
    }
    @Override
    public Connection call() throws Exception {
        return connection;
    }
}
