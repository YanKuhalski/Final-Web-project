package com.epam.webapp.repository.template;

import java.util.Arrays;
import java.util.List;

public class RideTemplate implements Template {
    private int clientId;
    private int driverId;
    private int carId;
    private int startRegionId;
    private int endRegionId;
    private int discountId;
    private boolean isAccepted;
    private boolean isPayed;
    private boolean isFinished;

    public RideTemplate(int clientId, int driverId, int carId, int startRegionId, int endRegionId, int discountId) {
        this.clientId = clientId;
        this.driverId = driverId;
        this.carId = carId;
        this.startRegionId = startRegionId;
        this.endRegionId = endRegionId;
        this.discountId = discountId;
        isAccepted = false;
        isPayed = false;
        isFinished = false;
    }

    @Override
    public String toSql() {
        return "(client_id,driver_id,car_id,start_region_id,end_region_id,discount_id) values (?,?,?,?,?,?)";
    }


    @Override
    public List<Object> getValues() {
        return Arrays.asList(clientId, driverId, carId, startRegionId, endRegionId, discountId);
    }
}
