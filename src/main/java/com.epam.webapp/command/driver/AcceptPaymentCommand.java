package com.epam.webapp.command.driver;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandFatory;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.exception.ServiceExeption;
import com.epam.webapp.services.RideService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AcceptPaymentCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceExeption {
            int rideId = Integer.parseInt(req.getParameter("payed-ride-id"));
            RideService service = new RideService();
            service.acceptPay(rideId);
            return CommandFatory.create("chooseClient").execute(req, resp);///////CAHNGE !!!!!!
    }
}
