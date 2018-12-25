package com.epam.webapp.repository.specification;

import java.util.Arrays;
import java.util.List;

public class FindUserByLoginAndPasswordSpec implements Specification {
    private String login;
    private String password;

    public FindUserByLoginAndPasswordSpec(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toSql() {
        return " where login= ? and password = md5(?)";
    }

    @Override
    public List<Object> getParams() {
        return Arrays.asList(login, password);
    }

    public String getLogin() {
        return login;
    }
}
