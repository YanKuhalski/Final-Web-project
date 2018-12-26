package com.epam.webapp.command.driver;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandFatory;
import com.epam.webapp.command.CommandResult;
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
