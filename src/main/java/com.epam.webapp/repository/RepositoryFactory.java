package com.epam.webapp.repository;

import com.epam.webapp.connection.ConnectionPool;

import java.sql.Connection;

public class RepositoryFactory {
    private Connection connection;

    public RepositoryFactory() {
        this.connection = ConnectionPool.getInstance().getConnection();
    }

    public UserRepository getUserRepository() {
        return new UserRepository(connection);
    }
}
