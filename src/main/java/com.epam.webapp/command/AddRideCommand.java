package com.epam.webapp.command;

import com.epam.webapp.entyti.Car;
import com.epam.webapp.entyti.Region;
import com.epam.webapp.entyti.User;
import com.epam.webapp.repository.template.RideTemplate;
import com.epam.webapp.repository.template.Template;
import com.epam.webapp.services.CarService;
import com.epam.webapp.services.RideService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            int startRegionId = ((Region) req.getAttribute("startRegion")).getId();
            List<Car> freeCars = (List<Car>) carService.findFreeCarsNear(startRegionId);
            if (freeCars.contains(choosedCar)) {
                int carDriverId = choosedCar.getDriverId();
                int endRegionId = ((Region) req.getAttribute("endRegion")).getId();
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
