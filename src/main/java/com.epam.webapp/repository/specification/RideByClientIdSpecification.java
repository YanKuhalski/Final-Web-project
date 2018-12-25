package com.epam.webapp.repository.specification;

import java.util.Arrays;
import java.util.List;

public class RideByClientIdSpecification implements Specification {
    private int userId;

    public RideByClientIdSpecification(int userId) {
        this.userId = userId;
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
                "where client_id = ? ";
    }

    @Override
    public List<Object> getParams() {
        return Arrays.asList(userId);
    }
}
