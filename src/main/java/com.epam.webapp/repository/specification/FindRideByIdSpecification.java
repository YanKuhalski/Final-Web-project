package com.epam.webapp.repository.specification;

import java.util.Arrays;
import java.util.List;

public class FindRideByIdSpecification implements  Specification {
    private int id;

    public FindRideByIdSpecification(int id) {
        this.id = id;
    }

    @Override
    public String toSql() {
        return "where rides.id = ? ";
    }

    @Override
    public List<Object> getParams() {
        return Arrays.asList(id);
    }
}
