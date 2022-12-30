package com.solvd.connectionPool.connectionPoolFuture;

import com.solvd.connectionPool.Connection;
import com.solvd.connectionPool.ConnectionPool;
import com.solvd.exceptions.ConnectionPoolException;
import org.apache.log4j.Logger;

import java.util.concurrent.*;

public class ConnectionPoolFuture {
    private static final int COUNT = 5;

    private final BlockingQueue<FutureTask<Connection>> futureTasks = new ArrayBlockingQueue<>(ConnectionPool.COUNT);
    private final ExecutorService executorService = Executors.newFixedThreadPool(ConnectionPool.COUNT);

    private static final Logger LOGGER = Logger.getLogger(ConnectionPoolFuture.class);

    public ConnectionPoolFuture(){
        for (int i = 0; i < COUNT; i++) {
            Connection connection = new Connection(ConnectionPool.URL, ConnectionPool.USER, ConnectionPool.PASSWORD);
            ConnectionCallable connectionCallable = new ConnectionCallable(connection);
            FutureTask<Connection> futureTask = new FutureTask<>(connectionCallable);
            futureTasks.add(futureTask);
            executorService.execute(futureTask);
        }
    }

    public static void doTest() throws ConnectionPoolException {
        ConnectionPoolFuture connectionPoolFuture = new ConnectionPoolFuture();
        Connection c = connectionPoolFuture.getConnection();
        connectionPoolFuture.releaseConnection(c);
        Connection c1 = connectionPoolFuture.getConnection();
        Connection c2 = connectionPoolFuture.getConnection();
        Connection c3 = connectionPoolFuture.getConnection();
        Connection c4 = connectionPoolFuture.getConnection();
        Connection c5 = connectionPoolFuture.getConnection();
        connectionPoolFuture.shutdownConnectionPool();
    }

    public Connection getConnection() throws ConnectionPoolException {
        try {
            return futureTasks.take().get();
        } catch (InterruptedException | ExecutionException e) {
            LOGGER.error(e);
            throw new ConnectionPoolException();
        }
    }

    public void releaseConnection(Connection connection) {
        ConnectionCallable connectionCallable = new ConnectionCallable(connection);
        FutureTask<Connection> futureTask = new FutureTask<>(connectionCallable);
        futureTasks.add(futureTask);
        executorService.execute(futureTask);
    }

    public void shutdownConnectionPool(){
        executorService.shutdown();
    }
}
