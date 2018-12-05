package com.epam.webapp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowUsersComand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) {
        return CommandResult.forward("/WEB-INF/pages/userList.jsp");
    }
}
