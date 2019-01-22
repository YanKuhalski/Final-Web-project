package com.epam.webapp.command.client;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entyti.Car;
import com.epam.webapp.entyti.Ride;
import com.epam.webapp.entyti.User;
import com.epam.webapp.exception.ServiceExeption;
import com.epam.webapp.services.CarService;
import com.epam.webapp.services.RideService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddRideCommand extends ShowClientTripsCommand {
    private static final String START_REGION_PARAMETR_NAME = "startRegion";
    private static final String END_REGION_PARAMETR_NAME = "endRegion";
    private static final String CHOOSED_CAR_PARAMETR_NAME = "choosedCar";
    private static final String USER_ATTRIBUTE_NAME = "user";
    private static final String MESSGE_ATTRIBUTE_NAME = "message";
    private static final String MESSGE = "driver is busy";

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceExeption {
        int choosedCarId = Integer.parseInt(req.getParameter(CHOOSED_CAR_PARAMETR_NAME));
        CarService carService = new CarService();
        User user = (User) req.getSession().getAttribute(USER_ATTRIBUTE_NAME);
        Optional<Car> car = carService.findCarById(choosedCarId);
        if (car.isPresent()) {
            Car choosedCar = car.get();
            int startRegionId = Integer.parseInt(req.getParameter(START_REGION_PARAMETR_NAME));
            List<Car> freeCars = new ArrayList<>(carService.findAllFreeCars());
            if (freeCars.contains(choosedCar)) {
                int carDriverId = choosedCar.getDriverId();
                int endRegionId = Integer.parseInt(req.getParameter(END_REGION_PARAMETR_NAME));
                int userId = user.getId();
                BigDecimal discount = user.getDiscount();
                RideService rideService = new RideService();
                Ride ride = new Ride();
                ride.setClientId(userId)
                        .setDriverId(carDriverId)
                        .setCarId(choosedCarId)
                        .setStartRegionId(startRegionId)
                        .setEndRegionId(endRegionId)
                        .setDiscount(discount)
                        .setAccepted(false)
                        .setPayed(false)
                        .setFinished(false);
                rideService.addRide(ride);
            } else {
                req.setAttribute(MESSGE_ATTRIBUTE_NAME, MESSGE);
                //todo SEND TO MAIN
            }
        }
        return super.execute(req, resp);
    }
}
