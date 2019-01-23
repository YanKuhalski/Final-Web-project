package com.epam.webapp.command.admin;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entyti.User;
import com.epam.webapp.exception.ServiceExeption;
import com.epam.webapp.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowUsersComand implements Command {
    private static final String USER_LIST_ATTRIBUTE_NAME = "users";
    private static final String USER_VIEW_PAGE_PATH = "/WEB-INF/pages/userList.jsp";

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceExeption {
        UserService service = new UserService();
        List<User> users = service.uploadUserList();
        req.setAttribute(USER_LIST_ATTRIBUTE_NAME, users);
        return CommandResult.forward(USER_VIEW_PAGE_PATH);
    }
}
