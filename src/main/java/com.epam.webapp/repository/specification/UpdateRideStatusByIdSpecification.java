package com.epam.webapp.repository.specification;

import java.util.Arrays;
import java.util.List;

public class UpdateRideStatusByIdSpecification implements Specification {
    private int rideId;
    private boolean isAccept;
    private boolean isFinished;

    public UpdateRideStatusByIdSpecification(int rideId, boolean isAccept, boolean isFinished) {
        this.rideId = rideId;
        this.isAccept = isAccept;
        this.isFinished = isFinished;
    }

    @Override
    public String toSql() {
        return " is_accepted = ?, is_finished = ? where id = ?";
    }

    @Override
    public List<Object> getParams() {
        return Arrays.asList(isAccept, isFinished, rideId);
    }
}
