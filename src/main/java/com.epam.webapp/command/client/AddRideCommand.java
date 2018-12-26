package com.epam.webapp.command.client;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entyti.Car;
import com.epam.webapp.entyti.User;
import com.epam.webapp.repository.template.RideTemplate;
import com.epam.webapp.repository.template.Template;
import com.epam.webapp.services.CarService;
import com.epam.webapp.services.RideService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddRideCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) {
        int choosedCarId = Integer.parseInt(req.getParameter("choosedCar"));
        CarService carService = new CarService();
        Optional<Car> car = carService.findCarById(choosedCarId);
        if (car.isPresent()) {
            Car choosedCar = car.get();
            int startRegionId = Integer.parseInt(req.getParameter("startRegion"));
            List<Car> freeCars = new ArrayList<>(carService.findAllFreeCars());
            if (freeCars.contains(choosedCar)) {
                int carDriverId = choosedCar.getDriverId();
                int endRegionId = Integer.parseInt(req.getParameter("endRegion"));
                User user = (User) req.getSession().getAttribute("user");
                int userId = user.getId();
                int discountId = user.getDiscountId();

                RideService rideService = new RideService();
                Template ride = new RideTemplate(userId, carDriverId, choosedCarId, startRegionId, endRegionId, discountId);
                rideService.addRide(ride);

            } else {
                throw new UnsupportedOperationException();
            }
        }
        return new ShowClientTripsCommand().execute(req, resp);/////////////////////CHANGE!!!!!!!!!!!
    }
}
