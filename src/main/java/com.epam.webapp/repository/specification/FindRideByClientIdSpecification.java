package com.epam.webapp.repository.specification;

import java.util.Arrays;
import java.util.List;

public class FindRideByClientIdSpecification implements Specification {
    private int userId;

    public FindRideByClientIdSpecification(int userId) {
        this.userId = userId;
    }

    @Override
    public String toSql() {
        return "where client_id = ? order by rides.id desc";
    }

    @Override
    public List<Object> getParams() {
        return Arrays.asList(userId);
    }
}
