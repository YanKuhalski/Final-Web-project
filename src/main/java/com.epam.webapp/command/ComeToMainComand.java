package com.epam.webapp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ComeToMainComand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) {
        return CommandResult.forward("/WEB-INF/pages/main.jsp");
    }
}
