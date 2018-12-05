package com.epam.webapp.repository;

import com.epam.webapp.builder.UserBuilder;
import com.epam.webapp.entyti.User;
import com.epam.webapp.repository.specification.Specification;
import com.epam.webapp.repository.specification.UserByLoginAndPasswordSpec;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository extends AbstractRepository<User> {

    public UserRepository(Connection connection) {
        super(connection);
    }

    @Override
    public List<User> query(Specification specification) {
        String query = "select * users where " + specification.toSql();
        List<User> users = execyteQuery(query, new UserBuilder(), specification.getParams());
        return users;
    }

    @Override
    public Optional<User> queryForSingleResult(Specification specification) {
        //     return Optional.of(new User(((UserByLoginAndPasswordSpec) specification).getLogin(), "admin"));
        String query = " select * from users where " + specification.toSql();
        List<User> users = execyteQuery(query, new UserBuilder(),specification.getParams());
        if (users.get(0) != null) {
            return Optional.of(users.get(0));
        } else {
            return Optional.empty();
        }
    }
}
