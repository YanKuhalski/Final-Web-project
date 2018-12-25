package com.epam.webapp.repository;

import com.epam.webapp.builder.Builder;
import com.epam.webapp.connection.ConnectionPool;
import com.epam.webapp.repository.template.Template;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractRepository<T, R extends Template> implements Repository<T, R> {
    private Connection connection;

    public AbstractRepository(Connection connection) {
        this.connection = connection;
    }

    public List<T> execyteQuery(String query, Builder<T> builder, List<Object> params) {
        List<T> entitys = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            for (int i = 0; i < params.size(); i++) {
                statement.setObject(i + 1, params.get(i));
            }
            ResultSet resultSet = statement.executeQuery();
            List<T> resultFromBase = builder.build(resultSet);
            entitys.addAll(resultFromBase);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConnectionPool.getInstance().returnConnection(connection);
        return entitys;
    }


    public void execyteUpdate(String query, List<Object> params) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            for (int i = 0; i < params.size(); i++) {
                statement.setObject(i + 1, params.get(i));
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
