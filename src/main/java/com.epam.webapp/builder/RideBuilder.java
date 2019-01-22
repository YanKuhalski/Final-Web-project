package com.epam.webapp.builder;

import com.epam.webapp.entyti.Ride;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RideBuilder implements Builder<Ride> {
    private static final String ID_COLUMN_NAME = "rides.id";
    private static final String CLIENT_ID_COLUMN_NAME = "rides.client_id";
    private static final String DRIVER_ID_COLUMN_NAME = "rides.driver_id";
    private static final String CAR_ID_COLUMN_NAME = "rides.car_id";
    private static final String START_REGION_ID_COLUMN_NAME = "rides.start_region_id";
    private static final String END_REGION_ID_COLUMN_NAME = "rides.end_region_id";
    private static final String CLIENT_COLUMN_NAME = "client.login";
    private static final String DRIVER_COLUMN_NAME = "driver.login";
    private static final String CAR_BRAND_COLUMN_NAME = "car.car_name";
    private static final String CAR_MODEL_COLUMN_NAME = "car.car_model";
    private static final String START_REGION_COLUMN_NAME = "sregion.name";
    private static final String END_REGION_COLUMN_NAME = "eregion.name";
    private static final String DISCOUNT_COLUMN_NAME = "rides.discount";
    private static final String IS_ACCEPTED_COLUMN_NAME = "rides.is_accepted";
    private static final String IS_PAYED_COLUMN_NAME = "rides.is_payed";
    private static final String IS_FINISHED_COLUMN_NAME = "rides.is_finished";

    @Override
    public Ride build(ResultSet setElement) throws SQLException {
        Ride ride = new Ride();
        int id = setElement.getInt(ID_COLUMN_NAME);
        int clientId = setElement.getInt(CLIENT_ID_COLUMN_NAME);
        int driverId = setElement.getInt(DRIVER_ID_COLUMN_NAME);
        int carId = setElement.getInt(CAR_ID_COLUMN_NAME);
        int startRegionId = setElement.getInt(START_REGION_ID_COLUMN_NAME);
        int endRegionId = setElement.getInt(END_REGION_ID_COLUMN_NAME);
        String clientLogin = setElement.getString(CLIENT_COLUMN_NAME);
        String driverName = setElement.getString(DRIVER_COLUMN_NAME);
        String carBrand = setElement.getString(CAR_BRAND_COLUMN_NAME);
        String carModel = setElement.getString(CAR_MODEL_COLUMN_NAME);
        String startRegionName = setElement.getString(START_REGION_COLUMN_NAME);
        String endRegionName = setElement.getString(END_REGION_COLUMN_NAME);
        BigDecimal discount = setElement.getBigDecimal(DISCOUNT_COLUMN_NAME);
        boolean isAccepted = setElement.getBoolean(IS_ACCEPTED_COLUMN_NAME);
        boolean isPayed = setElement.getBoolean(IS_PAYED_COLUMN_NAME);
        boolean isFinished = setElement.getBoolean(IS_FINISHED_COLUMN_NAME);

        ride.setId(id)
                .setStartRegionId(startRegionId)
                .setEndRegionId(endRegionId)
                .setDiscount(discount)
                .setClientId(clientId)
                .setDriverId(driverId)
                .setCarId(carId)
                .setClientLogin(clientLogin)
                .setDriverLogin(driverName)
                .setCarBrend(carBrand)
                .setCarModel(carModel)
                .setStartRegionName(startRegionName)
                .setEndRegioName(endRegionName)
                .setAccepted(isAccepted)
                .setPayed(isPayed)
                .setFinished(isFinished);

        return ride;
    }
}