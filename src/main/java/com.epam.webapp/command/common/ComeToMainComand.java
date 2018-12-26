package com.epam.webapp.command.common;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ComeToMainComand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) {
        return CommandResult.forward("/WEB-INF/pages/main.jsp");
    }
}
