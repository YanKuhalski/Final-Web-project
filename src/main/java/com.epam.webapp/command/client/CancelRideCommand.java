package com.epam.webapp.command.client;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandFatory;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.exception.ServiceExeption;
import com.epam.webapp.services.RideService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CancelRideCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceExeption {
        RideService rideService = new RideService();
        int rideToRemoveId = Integer.parseInt(req.getParameter("ride-to-cancel-id"));
        rideService.removeRide(rideToRemoveId);
          return CommandResult.redirect("/webapp/controller?command=comeToUserMain");
    }
}
