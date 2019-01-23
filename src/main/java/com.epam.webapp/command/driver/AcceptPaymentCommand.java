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

public class AcceptPaymentCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceExeption {
        int rideId = Integer.parseInt(req.getParameter("payed-ride-id"));
        RideService service = new RideService();
        service.acceptPay(rideId);
        User user = (User) req.getSession().getAttribute("user");
        List<Ride> trips = service.findUnfinishedDriverTrips(user);
        req.setAttribute("ride", trips.get(0));
        return CommandResult.forward("/WEB-INF/pages/driverActiveRidePage.jsp");
    }
}
