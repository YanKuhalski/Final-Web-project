package com.epam.webapp.repository;

import com.epam.webapp.builder.UserBuilder;
import com.epam.webapp.entyti.User;
import com.epam.webapp.entyti.enums.OperationType;
import com.epam.webapp.exception.RepositoryException;
import com.epam.webapp.repository.specification.Specification;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserRepository extends AbstractRepository<User> {
    private static final String INSERT_SQL = "insert into users ";
    private static final String UPDATE_SQL = "update users set ";
    private static final String SQL = "select * from users ";

    public UserRepository(Connection connection) {
        super(connection);
    }

    @Override
    public List<User> query(Specification specification) throws RepositoryException {
        String query = SQL + specification.toSql();
        return executeQuery(query, new UserBuilder(), specification.getParams());
    }

    @Override
    public Optional<User> queryForSingleResult(Specification specification) throws RepositoryException {
        String query = SQL + specification.toSql();
        List<User> users = executeQuery(query, new UserBuilder(), specification.getParams());
        return !users.isEmpty() ? Optional.of(users.get(0)) : Optional.empty();
    }

    @Override
    public String toSql(OperationType operationType) {
        if (operationType == OperationType.INSERT) {
            return INSERT_SQL;
        } else {
            return UPDATE_SQL;
        }
    }

    @Override
    protected Map<String, Object> makeMap(User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("login", user.getLogin());
        if (user.getPassword() != null) {
            map.put("password", user.getPassword());
        }
        map.put("role", user.getRole());
        map.put("discount", user.getDiscount());
        map.put("is_active", user.isActive());
        return map;
    }

    @Override
    public void delete(Specification specification) {
        throw new UnsupportedOperationException();
    }
}
