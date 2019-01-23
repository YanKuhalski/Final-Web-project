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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ride ride = (Ride) o;

        if (id != ride.id) return false;
        if (clientId != ride.clientId) return false;
        if (driverId != ride.driverId) return false;
        if (carId != ride.carId) return false;
        if (startRegionId != ride.startRegionId) return false;
        if (endRegionId != ride.endRegionId) return false;
        if (isAccepted != ride.isAccepted) return false;
        if (isPayed != ride.isPayed) return false;
        if (isFinished != ride.isFinished) return false;
        if (clientLogin != null ? !clientLogin.equals(ride.clientLogin) : ride.clientLogin != null) return false;
        if (driverLogin != null ? !driverLogin.equals(ride.driverLogin) : ride.driverLogin != null) return false;
        if (carBrend != null ? !carBrend.equals(ride.carBrend) : ride.carBrend != null) return false;
        if (carModel != null ? !carModel.equals(ride.carModel) : ride.carModel != null) return false;
        if (startRegionName != null ? !startRegionName.equals(ride.startRegionName) : ride.startRegionName != null)
            return false;
        if (endRegioName != null ? !endRegioName.equals(ride.endRegioName) : ride.endRegioName != null) return false;
        return discount != null ? discount.equals(ride.discount) : ride.discount == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (clientLogin != null ? clientLogin.hashCode() : 0);
        result = 31 * result + clientId;
        result = 31 * result + (driverLogin != null ? driverLogin.hashCode() : 0);
        result = 31 * result + driverId;
        result = 31 * result + (carBrend != null ? carBrend.hashCode() : 0);
        result = 31 * result + (carModel != null ? carModel.hashCode() : 0);
        result = 31 * result + carId;
        result = 31 * result + (startRegionName != null ? startRegionName.hashCode() : 0);
        result = 31 * result + startRegionId;
        result = 31 * result + (endRegioName != null ? endRegioName.hashCode() : 0);
        result = 31 * result + endRegionId;
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + (isAccepted ? 1 : 0);
        result = 31 * result + (isPayed ? 1 : 0);
        result = 31 * result + (isFinished ? 1 : 0);
        return result;
    }
}
