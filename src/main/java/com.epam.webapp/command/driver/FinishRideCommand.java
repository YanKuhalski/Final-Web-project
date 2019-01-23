package com.epam.webapp.command.driver;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandFatory;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entyti.Ride;
import com.epam.webapp.entyti.User;
import com.epam.webapp.exception.ServiceExeption;
import com.epam.webapp.services.RideService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FinishRideCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceExeption {
        int rideId = Integer.parseInt(req.getParameter("ride-to-finish-id"));
        RideService service = new RideService();
        service.finishRide(rideId);
        User user = (User) req.getSession().getAttribute("user");
        List<Ride> trips = service.findUnfinishedDriverTrips(user);
        req.setAttribute("trips", trips);
        return CommandResult.forward("/WEB-INF/pages/rideRequests.jsp");
    }
}
