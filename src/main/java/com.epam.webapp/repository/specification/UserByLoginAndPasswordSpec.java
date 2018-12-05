package com.epam.webapp.repository.specification;

import java.util.Arrays;
import java.util.List;

public class UserByLoginAndPasswordSpec implements Specification {
    private String login;
    private String password;

    public UserByLoginAndPasswordSpec(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toSql() {
        return "login= ? and password = md5(?)";
    }

    @Override
    public List<Object> getParams() {
        return Arrays.asList(login, password);
    }

    public String getLogin() {
        return login;
    }
}
