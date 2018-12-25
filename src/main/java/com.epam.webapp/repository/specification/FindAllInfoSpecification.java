package com.epam.webapp.repository.specification;

import java.util.ArrayList;
import java.util.List;

public class FindAllInfoSpecification implements  Specification {
    @Override
    public String toSql() {
        return "";
    }

    @Override
    public List<Object> getParams() {
        return new ArrayList<>();
    }
}
