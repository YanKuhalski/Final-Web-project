package com.epam.webapp.repository.specification;


import java.util.List;

public interface Specification {
    String toSql();

    List<Object> getParams();
}
