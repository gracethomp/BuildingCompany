package com.solvd.utils;

import com.solvd.utils.exceptions.ConnectionPoolException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.*;

public class ConnectionPool {
    public static final String URL = "connection-url";
    public static final String USER = "user";
    public static final String PASSWORD = "password";
    public static final int COUNT = 5;
    private static final String CONFIG_FILE_NAME = "mysql";

    private final ResourceBundle bundle = ResourceBundle.getBundle(CONFIG_FILE_NAME);

    private static int size = 0;

    private static final ConnectionPool instance = new ConnectionPool();

    public BlockingQueue<Connection> availableConnection;

    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);

    private ConnectionPool(){
        this.availableConnection = new ArrayBlockingQueue<>(COUNT);
    }

    public static ConnectionPool getInstance() {
        return instance;
    }


    public Connection getConnection() throws ConnectionPoolException {
        if(size < COUNT) {
            Connection connection;
            try {
                connection = DriverManager.getConnection(bundle.getString(URL),
                        bundle.getString(USER), bundle.getString(PASSWORD));
                availableConnection.add(connection);
            } catch (SQLException e) {
                LOGGER.error(e);
                throw new ConnectionPoolException();
            }
            size++;
        }
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

