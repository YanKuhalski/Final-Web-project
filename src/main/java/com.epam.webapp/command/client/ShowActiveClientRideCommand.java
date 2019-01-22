package com.epam.webapp.command.client;

import com.epam.webapp.calculator.PriceCalculator;
import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entyti.Region;
import com.epam.webapp.entyti.Ride;
import com.epam.webapp.entyti.User;
import com.epam.webapp.exception.ServiceExeption;
import com.epam.webapp.services.RegionService;
import com.epam.webapp.services.RideService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Optional;

public class ShowActiveClientRideCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceExeption {
        RideService rideService = new RideService();
        RegionService regionService = new RegionService();
        User user = (User) req.getSession().getAttribute("user");
        Optional<Ride> activeRide = rideService.findUnfinishedClientRide(user);
        Ride ride = activeRide.get();
        PriceCalculator priceCalculator = new PriceCalculator();
        BigDecimal discount = ride.getDiscount();
        Optional<Region> startRegion = regionService.findRegionById(ride.getStartRegionId());
        Optional<Region> endRegion = regionService.findRegionById(ride.getEndRegionId());

        double price = priceCalculator.calculatePrice(startRegion.get(), endRegion.get(), discount);

        req.setAttribute("ride", ride);
        req.setAttribute("price", price);
        return CommandResult.forward("/WEB-INF/pages/userActiveRidePage.jsp");
    }
}
