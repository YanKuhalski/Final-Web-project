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
            int id = set.getInt(User.ID_COLUMN_NAME);
            String login = set.getString(User.LOGIN_COLUMN_NAME);
            String role = set.getString(User.ROLE_COLUMN_NAME);
            int discountId = set.getInt(User.DISCOUNT_ID_COLUMN_NAME);
            boolean isActive = set.getBoolean(User.IS_ACTIVE_COLUMN_NAME);
            users.add(new User(id, login, role, discountId, isActive));
        }
        return users;
    }
}
