package com.epam.webapp.command;

import com.epam.webapp.entyti.Ride;
import com.epam.webapp.entyti.User;
import com.epam.webapp.services.RideService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowClientTripsCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) {

        User user = (User) req.getSession().getAttribute("user");
        RideService service = new RideService();
        req.setAttribute("trips", service.findRideForCurrentClient(user));
        return CommandResult.forward("/WEB-INF/pages/rideStatistics.jsp");
    }

}
