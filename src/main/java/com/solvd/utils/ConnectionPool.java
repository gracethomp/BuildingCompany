package com.solvd.utils;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
            Connection connection;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/buildCompany",
                        "root","root");
                availableConnection.add(connection);
            } catch (SQLException e) {
                LOGGER.error("jhg");
            }
        }
    }

    public static ConnectionPool getInstance() {
        return instance;
    }


    public Connection getConnection() throws InterruptedException {
        return availableConnection.take();
    }

    public void releaseConnection(Connection connection) {
        availableConnection.add(connection);
    }
}

