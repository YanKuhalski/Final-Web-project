package com.epam.webapp.command;

import com.epam.webapp.services.RideService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FinishRideCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) {
        int rideId = Integer.parseInt(req.getParameter("ride-to-finish-id"));
        RideService service = new RideService();
        service.finishRide(rideId);
        return CommandFatory.create("chooseClient").execute(req, resp);
    }
}
