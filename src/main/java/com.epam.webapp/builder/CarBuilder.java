package com.epam.webapp.builder;

import com.epam.webapp.entyti.Car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarBuilder implements Builder<Car> {
    @Override
    public List<Car> build(ResultSet set) throws SQLException {
        List<Car> cars = new ArrayList<>();
        while (set.next()) {
            int id = set.getInt(Car.ID_COLUMN_NAME);
            int driverId = set.getInt(Car.DRIVER_ID_COLUMN_NAME);
            String carBrand = set.getString(Car.CAR_BRAND_COLUMN_NAME);
            String model = set.getString(Car.CAR_MODEL_COLUMN_NAME);
            cars.add(new Car(id, driverId, carBrand, model));
        }
        return cars;
    }
}
