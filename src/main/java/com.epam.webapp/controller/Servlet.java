package com.epam.webapp.controller;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandFatory;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.exception.ServiceExeption;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {
    private static final String ERROR_PAGE = "/WEB-INF/pages/error.jsp";
    private static final Logger log = Logger.getLogger(Servlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comand = req.getParameter("command");
        Command action = CommandFatory.create(comand);
        CommandResult execute;
        try {
            execute = action.execute(req, resp);
        } catch (ServiceExeption serviceExeption) {
            log.error(serviceExeption.getMessage());
            execute = CommandResult.forward(ERROR_PAGE);
        }
        dispatch(req, resp, execute);
    }

    private void dispatch(HttpServletRequest req, HttpServletResponse resp, CommandResult result) throws ServletException, IOException {
        if (result.isRedirect()) {
            resp.sendRedirect(result.getPage());
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher(result.getPage());
            dispatcher.forward(req, resp);
        }
    }
}
