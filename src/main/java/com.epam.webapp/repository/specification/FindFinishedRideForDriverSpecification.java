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
        return " rides " +
                "inner join users client on rides.client_id  = client.id " +
                "inner join users driver on rides.driver_id  = driver.id " +
                "inner join cars car on rides.car_id  = car.id " +
                "inner join regions sregion on rides.start_region_id  = sregion.id " +
                "inner join regions eregion on rides.end_region_id  = eregion.id " +
                "inner join discounts discount on rides.discount_id  = discount.id " +
                "where rides.driver_id = ?  and rides.is_finished = ?";
    }

    @Override
    public List<Object> getParams() {
        return Arrays.asList(id, isFinished);
    }
}
