package com.epam.webapp.calculator;

import com.epam.webapp.entyti.Discount;
import com.epam.webapp.entyti.Region;

import java.math.BigDecimal;

public class PriceCalculator {
    private static int AVERAGE_DISTANCE_IN_ZONE = 10;
    private static double COEFFICIENT_INCREASE = 0.5;
    private static double TAXI_INCREASE = 3;

    public BigDecimal calculatePrice(Region startRegion, Region endRegion, Discount descount) {
        int startZoneNumber = startRegion.getZoneNumber();
        int endZoneNumber = endRegion.getZoneNumber();
        double finalCoefficient = Math.abs(startZoneNumber - endZoneNumber) + COEFFICIENT_INCREASE;
        double distance = AVERAGE_DISTANCE_IN_ZONE * finalCoefficient;
        BigDecimal discountValue = descount.getValue();
        double price = distance * discountValue.doubleValue() + TAXI_INCREASE;
        BigDecimal finalPrice = BigDecimal.valueOf(price);
        return finalPrice;
    }
}
