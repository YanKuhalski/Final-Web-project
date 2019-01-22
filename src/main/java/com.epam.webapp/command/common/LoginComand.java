package com.epam.webapp.command.common;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entyti.User;
import com.epam.webapp.exception.ServiceExeption;
import com.epam.webapp.services.UserService;
import com.epam.webapp.services.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginComand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceExeption {
        HttpSession session = req.getSession(true);
        UserService service = new UserServiceImpl();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Optional<User> user = service.login(login, password);
        if (user.isPresent()) {
            User userObject = user.get();
            if (userObject.isActive()) {
                session.setAttribute("user", userObject);
                switch (userObject.getRole()) {
                    case "client":
                        return CommandResult.redirect("/webapp/controller?command=comeToUserMain");
                    case "admin":
                        return CommandResult.redirect("/webapp/controller?command=showUsers");
                    case "driver":
                        return CommandResult.redirect("/webapp/controller?command=showActiveDriverRide");
                }
            } else {
                req.setAttribute("message", "block");
            }
        } else {
            req.setAttribute("message", "wrong data");
        }
        return CommandResult.forward("/WEB-INF/pages/login.jsp");//todo redirect
    }
}
