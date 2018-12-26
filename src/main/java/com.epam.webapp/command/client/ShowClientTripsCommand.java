package com.epam.webapp.command.client;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entyti.User;
import com.epam.webapp.services.RideService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowClientTripsCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) {
        User user = (User) req.getSession().getAttribute("user");
        RideService service = new RideService();
        req.setAttribute("trips", service.findRideForCurrentClient(user));
        return CommandResult.forward("/WEB-INF/pages/rideStatistics.jsp");
    }

}
