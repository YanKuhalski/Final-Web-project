package com.epam.webapp.command.client;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.exception.ServiceExeption;
import com.epam.webapp.services.RideService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CancelRideCommand implements Command {
    private static final Logger log = Logger.getLogger(CancelRideCommand.class);
    private static final String PARAMETER = "ride-to-cancel-id";
    private static final String MESSAGE = "Ride is already accepted ";
    private static final String COMMAND = "/webapp/controller?command=comeToUserMain";

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceExeption {
        RideService rideService = new RideService();
        int rideToRemoveId = Integer.parseInt(req.getParameter(PARAMETER));
        if (!rideService.rideIsAccepted(rideToRemoveId)) {
            rideService.removeRide(rideToRemoveId);
        } else {
            log.info(MESSAGE);
        }
        return CommandResult.redirect(COMMAND);
    }
}
