package com.epam.webapp.repository.specification;

import java.util.Arrays;
import java.util.List;

public class FindByIdSpecification implements Specification {
    private int id;

    public FindByIdSpecification(int id) {
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
