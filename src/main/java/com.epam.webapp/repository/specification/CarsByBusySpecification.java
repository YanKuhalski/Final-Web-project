package com.epam.webapp.repository.specification;

import java.util.Arrays;
import java.util.List;

public class CarsByBusySpecification implements  Specification {
    private boolean isBusy;

    public CarsByBusySpecification(boolean isBusy) {
        this.isBusy = isBusy;
    }

    @Override
    public String toSql() {
        return " left join (select car_id from cars c left join rides r on c.id = r.car_id " +
                "where is_accepted = true and is_finished = false) s2 on cars.id = s2.car_id where (car_id is NULL) = ? ";
    }

    @Override
    public List<Object> getParams() {
        return Arrays.asList(!isBusy);
    }
}
