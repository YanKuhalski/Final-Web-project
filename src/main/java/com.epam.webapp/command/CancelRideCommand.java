package com.epam.webapp.command;

import com.epam.webapp.services.RideService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CancelRideCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) {
        RideService rideService = new RideService();
        int rideToRemoveId = Integer.parseInt(req.getParameter("ride-to-cancel-id"));
        rideService.removeRide(rideToRemoveId);
        return CommandFatory.create("showClientTrips").execute(req,resp);
    }
}
