package com.epam.webapp.repository;

import com.epam.webapp.connection.ConnectionPool;
import com.epam.webapp.entyti.enums.RepositoryType;

import java.sql.Connection;

public class RepositoryFactory implements AutoCloseable {
    private Connection connection;

    public RepositoryFactory() {
        this.connection = ConnectionPool.getInstance().getConnection();
    }

    public Repository getRepository(RepositoryType repositoryType) {
        switch (repositoryType) {
            case REGION_REPOSITORY:
                return new RegionRepository(connection);
            case USER_REPOSITORY:
                return new UserRepository(connection);
            case CAR_REPOSITORY:
                return new CarRepository(connection);
            case RIDE_REPOSITORY:
                return new RideRepository(connection);
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override
    public void close() {
        ConnectionPool.getInstance().returnConnection(connection);
    }
}
