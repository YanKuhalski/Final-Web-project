package com.epam.webapp.repository;

import com.epam.webapp.builder.Builder;
import com.epam.webapp.entyti.Identifiable;
import com.epam.webapp.entyti.enums.OperationType;
import com.epam.webapp.exception.RepositoryException;

import java.sql.*;
import java.util.*;

public abstract class AbstractRepository<T extends Identifiable> implements Repository<T> {
    private Connection connection;

    protected AbstractRepository(Connection connection) {
        this.connection = connection;
    }

    protected List<T> executeQuery(String query, Builder<T> builder, List<Object> params) throws RepositoryException {
        List<T> entities = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            for (int i = 0; i < params.size(); i++) {
                statement.setObject(i + 1, params.get(i));
            }
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                entities.add(builder.build(resultSet));
            }
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage(), e);
        }
        return entities;
    }


    protected void executeUpdate(String query, List<Object> params) throws RepositoryException {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            for (int i = 0; i < params.size(); i++) {
                statement.setObject(i + 1, params.get(i));
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage(), e);
        }
    }

    public void save(T item) throws RepositoryException {
        QueryHelper helper = new QueryHelper();
        Map<String, Object> map = makeMap(item);
        List<Object> params = getParams(map);
        int id = item.getId();
        if (id == 0) {
            String sql = toSql(OperationType.INSERT);
            String query = helper.makeAddQuery(map);
            executeUpdate(sql + query, params);
        } else {
            String sql = toSql(OperationType.UPDATE);
            String query = helper.makeUpdateQuery(map);
            params.add(id);
            executeUpdate(sql + query, params);
        }
    }

    protected abstract String toSql(OperationType operationType);

    protected abstract Map<String, Object> makeMap(T item);

    protected List<Object> getParams(Map<String, Object> map) {
        ArrayList<Object> parameters = new ArrayList<>();
        Set<String> keys = map.keySet();
        for (String key : keys) {
            Object parameter = map.get(key);
            parameters.add(parameter);
        }
        return parameters;
    }
}
