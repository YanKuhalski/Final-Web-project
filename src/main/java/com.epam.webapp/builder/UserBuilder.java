package com.epam.webapp.builder;

import com.epam.webapp.entyti.User;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBuilder implements Builder<User> {
    private static final String ID_COLUMN_NAME = "id";
    private static final String LOGIN_COLUMN_NAME = "login";
    private static final String ROLE_COLUMN_NAME = "role";
    private static final String DISCOUNT_COLUMN_NAME = "discount";
    private static final String IS_ACTIVE_COLUMN_NAME = "is_active";

    @Override
    public User build(ResultSet set) throws SQLException {
        int id = set.getInt(ID_COLUMN_NAME);
        String login = set.getString(LOGIN_COLUMN_NAME);
        String role = set.getString(ROLE_COLUMN_NAME);
        BigDecimal discount = set.getBigDecimal(DISCOUNT_COLUMN_NAME);
        boolean isActive = set.getBoolean(IS_ACTIVE_COLUMN_NAME);
        User user = new User();
        user.setId(id)
                .setLogin(login)
                .setRole(role)
                .setDiscount(discount)
                .setActive(isActive);
        return user;
    }
}
