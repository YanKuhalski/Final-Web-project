package com.epam.webapp.repository;

import com.epam.webapp.builder.UserBuilder;
import com.epam.webapp.entyti.Region;
import com.epam.webapp.entyti.User;
import com.epam.webapp.repository.specification.Specification;
import com.epam.webapp.repository.specification.UserByLoginAndPasswordSpec;
import com.epam.webapp.repository.template.UserTemplate;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository extends AbstractRepository<User , UserTemplate> {

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
    public void insert(UserTemplate template) {
        throw   new UnsupportedOperationException();
    }

    @Override
    public void update(int id, UserTemplate template) {
        throw  new UnsupportedOperationException();
    }

    @Override
    public void delete(int id) {
        throw   new UnsupportedOperationException();
    }
}
