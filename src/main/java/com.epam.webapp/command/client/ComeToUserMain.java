package com.epam.webapp.command.client;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entyti.Car;
import com.epam.webapp.entyti.Region;

import com.epam.webapp.entyti.Ride;
import com.epam.webapp.entyti.User;
import com.epam.webapp.exception.ServiceExeption;
import com.epam.webapp.services.CarService;
import com.epam.webapp.services.RegionService;
import com.epam.webapp.services.RideService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

public class ComeToUserMain implements Command {
    private static final String START_REGION_ATTRIBUTE_NAME = "startRegion";
    private static final String REGIONS_ATTRIBUTE_NAME = "regions";
    private static final String FREE_CARS_ATTRIBUTE_NAME = "freeCars";
    private static final String PAGE = "/WEB-INF/pages/userMainPage.jsp";
    private static final String COMMAND = "/webapp/controller?command=showActiveClientRide";

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceExeption {
        RideService rideService = new RideService();
        User user = (User) req.getSession().getAttribute("user");
        RegionService regionService = new RegionService();
        CarService carService = new CarService();
        Optional<Ride> activeRide = rideService.findUnfinishedClientRide(user);
        if (!activeRide.isPresent()) {
            Set<Region> allRegionsSet = regionService.getAllRegionsList();
            List<Region> regionsList = new ArrayList<>(allRegionsSet);
            int randomRegionIndex = new Random().nextInt(regionsList.size());
            Region startRegion = regionsList.get(randomRegionIndex);
            regionsList.remove(startRegion);
            int startRegionZoneNumber = startRegion.getZoneNumber();
            Set<Car> freeCarsNear = carService.findFreeCarsNear(startRegionZoneNumber);

            req.setAttribute(START_REGION_ATTRIBUTE_NAME, startRegion);
            req.setAttribute(REGIONS_ATTRIBUTE_NAME, regionsList);
            req.setAttribute(FREE_CARS_ATTRIBUTE_NAME, new ArrayList<>(freeCarsNear));
            return CommandResult.forward(PAGE);
        } else {
            return CommandResult.redirect(COMMAND);
        }
    }
}
