package com.epam.webapp.repository.specification;

import java.util.Arrays;
import java.util.List;

public class DeleteAllUnacceptedRequestByDriverIdSpecification implements Specification {
    private int driverId;

    public DeleteAllUnacceptedRequestByDriverIdSpecification(int driverId) {
        this.driverId = driverId;
    }

    @Override
    public String toSql() {
        return " driver_id = ? and is_accepted = false";
    }

    @Override
    public List<Object> getParams() {
        return Arrays.asList(driverId);
    }
}
