package com.epam.webapp.command.common;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.exception.ServiceExeption;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeLanguage implements Command {
    private static final String LANGUAGE_PARAMETR_NAME = "lang";
    private static final String LANGUAGE_ATTRIBUTE_NAME = "language";
    private static final String PAGE = "/WEB-INF/pages/login.jsp";

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceExeption {
        String language = req.getParameter(LANGUAGE_PARAMETR_NAME);
        req.getSession().setAttribute(LANGUAGE_ATTRIBUTE_NAME, language);
        return CommandResult.forward(PAGE);
    }
}
