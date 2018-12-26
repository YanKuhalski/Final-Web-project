package com.epam.webapp.command.admin;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandFatory;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.services.UserService;
import com.epam.webapp.services.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UnblockUserCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) {
        int userId = Integer.valueOf(req.getParameter("user-to-unblock-id"));
        UserService service = new UserServiceImpl();
        service.setUserIsActive(userId,true);
        return CommandFatory.create("showUsers").execute(req, resp);
    }
}
