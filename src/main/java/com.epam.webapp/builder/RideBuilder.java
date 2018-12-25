package com.epam.webapp.builder;

import com.epam.webapp.entyti.Ride;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RideBuilder implements Builder<Ride> {
    @Override
    public List<Ride> build(ResultSet set) throws SQLException {
        List<Ride> rides = new ArrayList<>();
        while (set.next()) {
            int id = set.getInt(Ride.ID_COLUMN_NAME);
            String clientLogin = set.getString(Ride.CLIENT_COLUMN_NAME);
            String driverName = set.getString(Ride.DRIVER_COLUMN_NAME);
            String carBrand = set.getString(Ride.CAR_BRAND_COLUMN_NAME);
            String carModel = set.getString(Ride.CAR_MODEL_COLUMN_NAME);
            String startRegionName = set.getString(Ride.START_REGION_COLUMN_NAME);
            String endRegionName = set.getString(Ride.END_REGION_COLUMN_NAME);
            BigDecimal discountValue = set.getBigDecimal(Ride.DISCOUNT_VALUE_COLUMN_NAME);
            boolean isAccepted = set.getBoolean(Ride.IS_ACCEPTED_COLUMN_NAME);
            boolean isPayed = set.getBoolean(Ride.IS_PAYED_COLUMN_NAME);
            boolean isFinished = set.getBoolean(Ride.IS_FINISHED_COLUMN_NAME);
            rides.add(new Ride(id, clientLogin, driverName, carBrand, carModel, startRegionName, endRegionName, discountValue, isAccepted, isPayed, isFinished));
        }
        return rides;
    }
}