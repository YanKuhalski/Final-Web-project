package com.epam.webapp.command.common;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entyti.User;
import com.epam.webapp.exception.ServiceExeption;
import com.epam.webapp.services.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginComand implements Command {
    private static final Logger log = Logger.getLogger(LoginComand.class);
    private static final String LOGIN_PARAMETER_NAME = "login";
    private static final String PASSWORD_PARAMETER_NAME = "password";
    private static final String USER_ATTRIBUTE_NAME = "user";
    private static final String FIRST_COMMAND = "/webapp/controller?command=comeToUserMain";
    private static final String SECOND_COMMAND = "/webapp/controller?command=showUsers";
    private static final String THIRD_COMMAND = "/webapp/controller?command=showActiveDriverRide";
    private static final String FIRST_MESSAGE = "Your account is not active";
    private static final String SECIND_MESSAGE = "Wrong data";
    private static final String COMMAND = "/webapp/";

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceExeption {
        HttpSession session = req.getSession(true);
        UserService service = new UserService();
        String login = req.getParameter(LOGIN_PARAMETER_NAME);
        String password = req.getParameter(PASSWORD_PARAMETER_NAME);
        Optional<User> user = service.login(login, password);
        if (user.isPresent()) {
            User userObject = user.get();
            if (userObject.isActive()) {
                session.setAttribute(USER_ATTRIBUTE_NAME, userObject);
                switch (userObject.getRole()) {
                    case "client":
                        return CommandResult.redirect(FIRST_COMMAND);
                    case "admin":
                        return CommandResult.redirect(SECOND_COMMAND);
                    case "driver":
                        return CommandResult.redirect(THIRD_COMMAND);
                }
            } else {
                log.info(FIRST_MESSAGE);
            }
        } else {
            log.info(SECIND_MESSAGE);
        }
        return CommandResult.redirect(COMMAND);
    }
}
