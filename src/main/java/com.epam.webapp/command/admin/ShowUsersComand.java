package com.epam.webapp.command.admin;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entyti.User;
import com.epam.webapp.services.UserService;
import com.epam.webapp.services.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ShowUsersComand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) {

        List<User> users = new ArrayList<>();
        UserService service = new UserServiceImpl();
        users.addAll(service.findUsersByRole("client"));
        users.addAll(service.findUsersByRole("driver"));

        req.setAttribute("users", users);
        return CommandResult.forward("/WEB-INF/pages/userList.jsp");
    }
}
