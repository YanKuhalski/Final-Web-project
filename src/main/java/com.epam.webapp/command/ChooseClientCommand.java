package com.epam.webapp.command;

import com.epam.webapp.entyti.Ride;
import com.epam.webapp.entyti.User;
import com.epam.webapp.services.RideService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ChooseClientCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) {
        User driver = (User) req.getSession().getAttribute("user");
        RideService service = new RideService();
        List<Ride> rides = service.findRideForCurrentDriver(driver);
        req.setAttribute("trips", rides);

        return CommandResult.forward("/WEB-INF/pages/rideRequests.jsp");
    }
}
