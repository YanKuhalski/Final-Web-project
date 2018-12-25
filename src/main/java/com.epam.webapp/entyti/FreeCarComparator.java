package com.epam.webapp.entyti;

import java.util.Comparator;

public class FreeCarComparator implements Comparator<Car> {
    private int clientZoneId;

    public FreeCarComparator(int clientZoneId) {
        this.clientZoneId = clientZoneId;
    }

    @Override
    public int compare(Car firstCar, Car secondCar) {
        String carBrand = firstCar.getCarBrand();
        String carModel = firstCar.getCarModel();
        String secondCarBrand = secondCar.getCarBrand();
        String secondCarModel = secondCar.getCarModel();
        if (carBrand.equals(secondCarBrand) && carModel.equals(secondCarModel)) {
            return 0;
        }
        int firstCarConcurrentRegionId = firstCar.getConcurrentRegionId();
        int secondCarConcurrentRegionId = secondCar.getConcurrentRegionId();
        int firstDistance = Math.abs(clientZoneId - firstCarConcurrentRegionId);
        int secondDistance = Math.abs(clientZoneId - secondCarConcurrentRegionId);
        if (firstDistance < secondDistance){
            return -1;
        }else {
            return 1;
        }
    }
}
