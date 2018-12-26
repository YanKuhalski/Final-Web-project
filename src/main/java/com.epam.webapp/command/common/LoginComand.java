package com.epam.webapp.command.common;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entyti.User;
import com.epam.webapp.services.UserService;
import com.epam.webapp.services.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginComand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(true);
        UserService service = new UserServiceImpl();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Optional<User> user = service.login(login, password);
        if (user.isPresent()) {
            session.setAttribute("user", user.get());
            return CommandResult.forward("/WEB-INF/pages/main.jsp");
        }

        req.setAttribute("message","Нет такого пользователя");
        return CommandResult.forward("/WEB-INF/pages/login.jsp");
    }
}
