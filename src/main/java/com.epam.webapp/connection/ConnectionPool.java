package com.epam.webapp.connection;

import com.epam.webapp.exception.DataBaseConnectionCreationException;

import java.sql.Connection;
import java.util.Optional;
import java.util.Stack;

public class ConnectionPool {
    private static Stack<Connection> connections;/////////////////change stack
    private static final ConnectionPool instance = new ConnectionPool(10);

    private ConnectionPool(int poolSize) {
        ConnectionFactory factory = new ConnectionFactory();
        connections = new Stack<>();
        for (int i = 0; i < poolSize; i++) {
            Connection newConnection = null;
            try {
                newConnection = factory.createConnection();
                connections.push(newConnection);
            } catch (DataBaseConnectionCreationException e) {
                e.printStackTrace();//////////////Change!!!!!
            }
        }
    }

    public static ConnectionPool getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connections.pop();
    }

    public void returnConnection(Connection connection) {
        connections.push(connection);
    }
}
