package com.solvd.connectionPool;

import com.solvd.exceptions.ConnectionPoolException;
import org.apache.log4j.Logger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private static final String URL = "connection-url";
    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static final int COUNT = 5;

    public BlockingQueue<Connection> availableConnection;

    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);

    public ConnectionPool(){
        this.availableConnection = new ArrayBlockingQueue<>(COUNT);
        for (int i = 0; i < COUNT; i++) {
            Connection connection = new Connection(URL, USER, PASSWORD);
            availableConnection.add(connection);
        }
    }

    public Connection getConnection() throws ConnectionPoolException {
        try {
            return availableConnection.take();
        } catch (InterruptedException e) {
            LOGGER.error(e);
            throw new ConnectionPoolException();
        }
    }

    public void releaseConnection(Connection connection) {
        availableConnection.add(connection);
    }
}
