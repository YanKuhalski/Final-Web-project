package com.epam.webapp.command.common;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOutCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().setAttribute("user",null);
        return CommandResult.forward("/WEB-INF/pages/login.jsp");
    }
}
