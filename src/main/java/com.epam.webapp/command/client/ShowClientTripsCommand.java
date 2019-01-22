package com.epam.webapp.command.client;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entyti.Ride;
import com.epam.webapp.entyti.User;
import com.epam.webapp.exception.ServiceExeption;
import com.epam.webapp.services.RideService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowClientTripsCommand implements Command {
    private static final String USER_ATTRIBUTE_NAME = "user";
    private static final String TRIPS_ATTRIBUTE_NAME = "trips";
    private static final String RIDE_VIEW_PAGE_PATH = "/WEB-INF/pages/rideStatistics.jsp";

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceExeption {
        User user = (User) req.getSession().getAttribute(USER_ATTRIBUTE_NAME);
        RideService service = new RideService();
        List<Ride> rideForCurrentClient = service.findRideForCurrentClient(user);
        req.setAttribute(TRIPS_ATTRIBUTE_NAME, rideForCurrentClient);
        return CommandResult.forward(RIDE_VIEW_PAGE_PATH);
    }
}
