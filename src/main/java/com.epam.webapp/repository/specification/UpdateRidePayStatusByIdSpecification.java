package com.epam.webapp.repository.specification;

import com.epam.webapp.repository.specification.Specification;

import java.util.Arrays;
import java.util.List;

public class UpdateRidePayStatusByIdSpecification implements Specification {
    private int rideId;
    private boolean isPayed;

    public UpdateRidePayStatusByIdSpecification(int rideId,boolean isPayed) {
        this.rideId = rideId;
        this.isPayed = isPayed;
    }

    @Override
    public String toSql() {
        return " is_payed = ? where id = ?";
    }

    @Override
    public List<Object> getParams() {
        return Arrays.asList( isPayed, rideId);
    }
}
