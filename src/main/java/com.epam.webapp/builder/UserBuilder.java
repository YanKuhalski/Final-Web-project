package com.epam.webapp.builder;

import com.epam.webapp.entyti.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBuilder implements Builder<User> {
    @Override
    public List<User> build(ResultSet set) throws SQLException {
        List<User> users = new ArrayList<>();
        while (set.next()) {
            String login = set.getString("login");
            String role = set.getString("role");
            users.add(new User(login, role));
        }
        return users;
    }
}
