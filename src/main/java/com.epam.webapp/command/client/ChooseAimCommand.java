package com.epam.webapp.command.client;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandFatory;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entyti.Region;
import com.epam.webapp.entyti.Ride;
import com.epam.webapp.entyti.User;
import com.epam.webapp.services.RegionService;
import com.epam.webapp.services.RideService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ChooseAimCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) {

        RideService rideService = new RideService();
        User user = (User) req.getSession().getAttribute("user");
        List<Ride> rideForCurrentClient = rideService.findRideForCurrentClient(user);
        boolean haveUnfinishedRide = false;
        for (Ride ride : rideForCurrentClient) {
            if (!ride.isFinished()) {
                haveUnfinishedRide = true;
            }
        }
        if (!haveUnfinishedRide) {
            RegionService service = new RegionService();
            Set<Region> allRegionsList = service.getAllRegionsList();
            req.setAttribute("regions", new ArrayList<>(allRegionsList));
            return CommandResult.forward("/WEB-INF/pages/chooseAim.jsp");
        } else {
            req.setAttribute("message","У вас есть не законченые поездки");
            return CommandFatory.create("showClientTrips").execute(req, resp);
        }
    }
}
