package com.epam.webapp.repository.specification;

import java.util.Arrays;
import java.util.List;

public class ByIdSpecification implements Specification {
    private int id;

    public ByIdSpecification(int id) {
        this.id = id;
    }

    @Override
    public String toSql() {
        return " where id = ?";
    }

    @Override
    public List<Object> getParams() {
        return Arrays.asList(id);
    }
}
