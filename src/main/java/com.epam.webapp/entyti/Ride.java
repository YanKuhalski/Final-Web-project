package com.epam.webapp.entyti;

import java.math.BigDecimal;

public class Ride implements Identifiable {
    private int id;
    private String clientLogin;
    private int clientId;
    private String driverLogin;
    private int driverId;
    private String carBrend;
    private String carModel;
    private int carId;
    private String startRegionName;
    private int startRegionId;
    private String endRegioName;
    private int endRegionId;
    private BigDecimal discount;

    private boolean isAccepted;
    private boolean isPayed;
    private boolean isFinished;



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

    public BigDecimal getDiscount() {
        return discount;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public int getClientId() {
        return clientId;
    }

    public int getDriverId() {
        return driverId;
    }

    public int getCarId() {
        return carId;
    }

    public int getStartRegionId() {
        return startRegionId;
    }

    public int getEndRegionId() {
        return endRegionId;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public Ride setId(int id) {
        this.id = id;
        return this;
    }

    public Ride setClientLogin(String clientLogin) {
        this.clientLogin = clientLogin;
        return this;
    }

    public Ride setClientId(int clientId) {
        this.clientId = clientId;
        return this;
    }

    public Ride setDriverLogin(String driverLogin) {
        this.driverLogin = driverLogin;
        return this;
    }

    public Ride setDriverId(int driverId) {
        this.driverId = driverId;
        return this;
    }

    public Ride setCarBrend(String carBrend) {
        this.carBrend = carBrend;
        return this;
    }

    public Ride setCarModel(String carModel) {
        this.carModel = carModel;
        return this;
    }

    public Ride setCarId(int carId) {
        this.carId = carId;
        return this;
    }

    public Ride setStartRegionName(String startRegionName) {
        this.startRegionName = startRegionName;
        return this;
    }

    public Ride setStartRegionId(int startRegionId) {
        this.startRegionId = startRegionId;
        return this;
    }

    public Ride setEndRegioName(String endRegioName) {
        this.endRegioName = endRegioName;
        return this;
    }

    public Ride setEndRegionId(int endRegionId) {
        this.endRegionId = endRegionId;
        return this;
    }

    public Ride setDiscount(BigDecimal discountValue) {
        this.discount = discountValue;
        return this;
    }

    public Ride setAccepted(boolean value) {
        isAccepted = value;
        return this;
    }

    public Ride setPayed(boolean value) {
        isPayed = value;
        return this;
    }

    public Ride setFinished(boolean value) {
        isFinished = value;
        return this;
    }
}
