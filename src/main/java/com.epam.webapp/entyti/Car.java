package com.epam.webapp.entyti;

public class Car implements Identifiable {
    private int id;
    private int concurrentRegionId;
    private int driverId;
    private String carBrand;
    private String carModel;

    public int getId() {
        return id;
    }

    public int getDriverId() {
        return driverId;
    }

    public int getConcurrentRegionId() {
        return concurrentRegionId;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public Car setId(int id) {
        this.id = id;
        return this;
    }

    public Car setDriverId(int driverId) {
        this.driverId = driverId;
        return this;
    }

    public Car setCarBrand(String carBrand) {
        this.carBrand = carBrand;
        return this;
    }

    public Car setCarModel(String carModel) {
        this.carModel = carModel;
        return this;
    }

    public Car setConcurrentRegionId(int concurrentRegionId) {
        this.concurrentRegionId = concurrentRegionId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (getId() != car.getId()) return false;
        if (getDriverId() != car.getDriverId()) return false;
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

}
