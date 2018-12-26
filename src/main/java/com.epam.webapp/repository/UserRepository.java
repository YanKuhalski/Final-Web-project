package com.epam.webapp.repository;

import com.epam.webapp.builder.UserBuilder;
import com.epam.webapp.entyti.User;
import com.epam.webapp.repository.specification.Specification;
import com.epam.webapp.repository.template.Template;
import com.epam.webapp.repository.template.UserTemplate;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class UserRepository extends AbstractRepository<User> {

    public UserRepository(Connection connection) {
        super(connection);
    }

    @Override
    public List<User> query(Specification specification) {
        String query = "select * from users " + specification.toSql();
        return execyteQuery(query, new UserBuilder(), specification.getParams());
    }

    @Override
    public Optional<User> queryForSingleResult(Specification specification) {
        String query = " select * from users " + specification.toSql();
        List<User> users = execyteQuery(query, new UserBuilder(), specification.getParams());
        return !users.isEmpty() ? Optional.of(users.get(0)) : Optional.empty();
    }

    @Override
    public void insert(Template template) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Specification specification) {
        String sql = "update users set " + specification.toSql();
        execyteUpdate(sql, specification.getParams());
    }

    @Override
    public void delete(Specification specification) {
        throw new UnsupportedOperationException();
    }
}
