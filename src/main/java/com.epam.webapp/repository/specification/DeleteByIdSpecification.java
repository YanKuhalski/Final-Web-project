package com.epam.webapp.repository.specification;

import java.util.Arrays;
import java.util.List;

public class DeleteByIdSpecification implements Specification {
    private int id;
    private boolean isSuchId;

    public DeleteByIdSpecification(int id, boolean isSuchId) {
        this.id = id;
        this.isSuchId = isSuchId;
    }

    @Override
    public String toSql() {
        if (isSuchId) {
            return " id = ? ";
        } else {
            return " id != ? ";
        }
    }

    @Override
    public List<Object> getParams() {
        return Arrays.asList(id);
    }
}
