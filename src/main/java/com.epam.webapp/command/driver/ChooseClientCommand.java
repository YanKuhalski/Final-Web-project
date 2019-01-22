package com.epam.webapp.command.driver;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entyti.Ride;
import com.epam.webapp.entyti.User;
import com.epam.webapp.exception.ServiceExeption;
import com.epam.webapp.services.RideService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ChooseClientCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceExeption {
            User driver = (User) req.getSession().getAttribute("user");
            RideService service = new RideService();
            List<Ride> rides = service.findRideForCurrentDriver(driver);
            req.setAttribute("trips", rides);
            return CommandResult.forward("/WEB-INF/pages/rideRequests.jsp");
    }
}
