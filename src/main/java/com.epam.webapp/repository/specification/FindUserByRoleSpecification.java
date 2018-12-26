package com.epam.webapp.repository.specification;

import java.util.Arrays;
import java.util.List;

public class FindUserByRoleSpecification implements Specification {
    private String role;

    public FindUserByRoleSpecification(String role) {
        this.role = role;
    }

    @Override
    public String toSql() {
        return " where role = ?" ;
    }

    @Override
    public List<Object> getParams() {
        return Arrays.asList(role);
    }
}
