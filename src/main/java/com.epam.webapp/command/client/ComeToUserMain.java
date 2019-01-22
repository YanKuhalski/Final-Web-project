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

            req.setAttribute("startRegion", startRegion);
            req.setAttribute("regions", regionsList);
            req.setAttribute("freeCars", new ArrayList<>(freeCarsNear));
            return CommandResult.forward("/WEB-INF/pages/userMainPage.jsp");
        } else {
            return CommandResult.redirect("/webapp/controller?command=showActiveClientRide");
        }
    }
}
