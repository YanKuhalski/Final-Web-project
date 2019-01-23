package com.epam.webapp.command.admin;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entyti.User;
import com.epam.webapp.exception.ServiceExeption;
import com.epam.webapp.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UnblockUserCommand implements Command {
    private static final String UNBLOCK_ID_PARAMETR_NAME = "user-to-unblock-id";
    private static final String USER_LIST_ATTRIBUTE_NAME = "users";
    private static final String USER_VIEW_PAGE_PATH = "/WEB-INF/pages/userList.jsp";

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceExeption {
        int userId = Integer.valueOf(req.getParameter(UNBLOCK_ID_PARAMETR_NAME));
        UserService service = new UserService();
        service.setUserIsActive(userId, true);
        List<User> users = service.uploadUserList();
        req.setAttribute(USER_LIST_ATTRIBUTE_NAME, users);
        return CommandResult.forward(USER_VIEW_PAGE_PATH);
    }
}
