package com.epam.webapp.command;

import com.epam.webapp.entyti.User;
import com.epam.webapp.services.RideService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AcceptRideCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) {
        int rideId = Integer.parseInt(req.getParameter("ride-to-accept-id"));
        RideService service = new RideService();
        User driver = (User) req.getSession().getAttribute("user");
        service.acceptRide(rideId, driver.getId());
        return CommandFatory.create("chooseClient").execute(req, resp);
    }
}
