package com.epam.webapp.calculator;

import com.epam.webapp.entyti.Region;

import java.math.BigDecimal;

public class PriceCalculator {
    private static final int AVERAGE_DISTANCE_IN_ZONE = 10;
    private static final double COEFFICIENT_INCREASE = 0.5;
    private static final double TAXI_INCREASE = 3;

    public double calculatePrice(Region startRegion, Region endRegion, BigDecimal descount) {
        int startZoneNumber = startRegion.getZoneNumber();
        int endZoneNumber = endRegion.getZoneNumber();
        double finalCoefficient = Math.abs(startZoneNumber - endZoneNumber) + COEFFICIENT_INCREASE;
        double distance = AVERAGE_DISTANCE_IN_ZONE * finalCoefficient;
        double price = distance * descount.doubleValue() + TAXI_INCREASE;
        return price;
    }
}
