package com.epam.webapp.repository.specification;

import java.util.Arrays;
import java.util.List;

public class FindFinishedRideForDriverSpecification implements Specification {
    private int id;
    private boolean isFinished;

    public FindFinishedRideForDriverSpecification(int id, boolean isFinished ) {
        this.id = id;
        this.isFinished = isFinished;
    }

    @Override
    public String toSql() {
        return " where rides.driver_id = ?  and rides.is_finished = ?";
    }

    @Override
    public List<Object> getParams() {
        return Arrays.asList(id, isFinished);
    }
}
