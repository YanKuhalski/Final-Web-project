package com.epam.webapp.repository.specification;

import java.util.Arrays;
import java.util.List;

public class FindCarsByBusySpecification implements  Specification {
    private boolean isBusy;

    public FindCarsByBusySpecification(boolean isBusy) {
        this.isBusy = isBusy;
    }

    @Override
    public String toSql() {
        return " left join " +
                "(select car_id from cars c " +
                "left join rides r on c.id = r.car_id " +
                "where is_accepted = true and is_finished = false) s2 on cars.id = s2.car_id " +
                "left join users driver on driver_id = driver.id " +
                "where (car_id is NULL) = ? and driver.is_active = true";
    }

    @Override
    public List<Object> getParams() {
        return Arrays.asList(!isBusy);
    }
}
