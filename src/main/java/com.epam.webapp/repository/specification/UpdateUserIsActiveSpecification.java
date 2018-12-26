package com.epam.webapp.repository.specification;

import java.util.Arrays;
import java.util.List;

public class UpdateUserIsActiveSpecification implements Specification {
    private int userId;
    private boolean isActive;

    public UpdateUserIsActiveSpecification(int userId, boolean isActive) {
        this.userId = userId;
        this.isActive = isActive;
    }

    @Override
    public String toSql() {
        return " is_active = ? where id = ? ;";
    }

    @Override
    public List<Object> getParams() {
        return Arrays.asList(isActive, userId);
    }
}
