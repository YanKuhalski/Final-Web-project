package com.epam.webapp.builder;

import com.epam.webapp.entyti.Car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class CarBuilder implements Builder<Car> {
    private static final int AMOUNT_OF_ZONES = 6;
    private static final String ID_COLUMN_NAME = "id";
    private static final String DRIVER_ID_COLUMN_NAME = "driver_id";
    private static final String CAR_BRAND_COLUMN_NAME = "car_name";
    private static final String CAR_MODEL_COLUMN_NAME = "car_model";

    @Override
    public Car build(ResultSet setElement) throws SQLException {
        Car car = new Car();
        int id = setElement.getInt(ID_COLUMN_NAME);
        int driverId = setElement.getInt(DRIVER_ID_COLUMN_NAME);
        String carBrand = setElement.getString(CAR_BRAND_COLUMN_NAME);
        String model = setElement.getString(CAR_MODEL_COLUMN_NAME);
        int regionId = new Random().nextInt(AMOUNT_OF_ZONES);
        car.setId(id)
                .setDriverId(driverId)
                .setCarBrand(carBrand)
                .setCarModel(model)
                .setConcurrentRegionId(regionId);
        return car;
    }
}
