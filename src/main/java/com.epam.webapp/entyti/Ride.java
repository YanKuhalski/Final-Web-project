package com.epam.webapp.entyti;

import java.math.BigDecimal;

public class Ride {
    public static String ID_COLUMN_NAME = "rides.id";
    public static String CLIENT_COLUMN_NAME = "client.login";
    public static String DRIVER_COLUMN_NAME = "driver.login";
    public static String CAR_BRAND_COLUMN_NAME = "car.car_name";
    public static String CAR_MODEL_COLUMN_NAME = "car.car_model";
    public static String START_REGION_COLUMN_NAME = "sregion.name";
    public static String END_REGION_COLUMN_NAME = "eregion.name";
    public static String DISCOUNT_VALUE_COLUMN_NAME = "discount.value";
    public static String IS_ACCEPTED_COLUMN_NAME = "rides.is_accepted";
    public static String IS_PAYED_COLUMN_NAME = "rides.is_payed";
    public static String IS_FINISHED_COLUMN_NAME = "rides.is_finished";

    private int id;
    private String clientLogin;
    private String driverLogin;
    private String carBrend;
    private String carModel;
    private String startRegionName;
    private String endRegioName;
    private BigDecimal discountValue;
    private boolean isAccepted;
    private boolean isPayed;
    private boolean isFinished;

    public Ride(int id, String clientLogin, String driverLogin, String carBrend, String carModel,
                String startRegionName, String endRegioName, BigDecimal discountValue, boolean isAccepted, boolean isPayed, boolean isFinished) {
        this.id = id;
        this.clientLogin = clientLogin;
        this.driverLogin = driverLogin;
        this.carBrend = carBrend;
        this.carModel = carModel;
        this.startRegionName = startRegionName;
        this.endRegioName = endRegioName;
        this.discountValue = discountValue;
        this.isAccepted = isAccepted;
        this.isPayed = isPayed;
        this.isFinished = isFinished;
    }

    public int getId() {
        return id;
    }

    public String getClientLogin() {
        return clientLogin;
    }

    public String getDriverLogin() {
        return driverLogin;
    }

    public String getCarBrend() {
        return carBrend;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getStartRegionName() {
        return startRegionName;
    }

    public String getEndRegioName() {
        return endRegioName;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public boolean isFinished() {
        return isFinished;
    }
}
