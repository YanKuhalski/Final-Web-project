package com.epam.webapp.entyti;

import java.util.Random;

public class Car {
    private static int AMOUNT_OF_ZONES = 6;
    public static String ID_COLUMN_NAME = "id";
    public static String DRIVER_ID_COLUMN_NAME = "driver_id";
    public static String CAR_BRAND_COLUMN_NAME = "car_name";
    public static String CAR_MODEL_COLUMN_NAME = "car_model";
    private int id;
    private int driverId;
    private String carBrand;
    private String carModel;
    private int concurrentRegionId;

    public Car(int id, int driverId, String carBrand, String carModel) {
        this.id = id;
        this.driverId = driverId;
        this.carBrand = carBrand;
        this.carModel = carModel;
        concurrentRegionId = new Random().nextInt(AMOUNT_OF_ZONES) + 1;
    }

    public int getId() {
        return id;
    }

    public int getDriverId() {
        return driverId;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getConcurrentRegionId() {
        return concurrentRegionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (getId() != car.getId()) return false;
        if (getDriverId() != car.getDriverId()) return false;
        if (getConcurrentRegionId() != car.getConcurrentRegionId()) return false;
        if (getCarBrand() != null ? !getCarBrand().equals(car.getCarBrand()) : car.getCarBrand() != null) return false;
        return getCarModel() != null ? getCarModel().equals(car.getCarModel()) : car.getCarModel() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getDriverId();
        result = 31 * result + (getCarBrand() != null ? getCarBrand().hashCode() : 0);
        result = 31 * result + (getCarModel() != null ? getCarModel().hashCode() : 0);
        result = 31 * result + getConcurrentRegionId();
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", driverId=" + driverId +
                ", carBrand='" + carBrand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", concurrentRegionId=" + concurrentRegionId +
                '}';
    }
}
