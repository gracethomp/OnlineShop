package com.solvd.connectionPool;

import com.solvd.exceptions.ConnectionPoolException;
import org.apache.log4j.Logger;

import java.util.concurrent.*;

public class ConnectionPool {
    public static final String URL = "connection-url";
    public static final String USER = "user";
    public static final String PASSWORD = "password";
    public static final int COUNT = 5;
    private static final ConnectionPool instance = new ConnectionPool();

    public BlockingQueue<Connection> availableConnection;

    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);

    private ConnectionPool(){
        this.availableConnection = new ArrayBlockingQueue<>(COUNT);
        for (int i = 0; i < COUNT; i++) {
            Connection connection = new Connection(URL, USER, PASSWORD);
            availableConnection.add(connection);
        }
    }

    public static ConnectionPool getInstance() {
        return instance;
    }

    public static void doTest() throws ConnectionPoolException {
        ConnectionPool connectionPool = getInstance();
        Connection c = connectionPool.getConnection();
        Connection c1 = connectionPool.getConnection();
        Connection c2 = connectionPool.getConnection();
        Connection c3 = connectionPool.getConnection();
        Connection c4 = connectionPool.getConnection();
        Connection c5 = connectionPool.getConnection();
        Connection c6 = connectionPool.getConnection();
        connectionPool.releaseConnection(c3);
        connectionPool.releaseConnection(c6);
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
