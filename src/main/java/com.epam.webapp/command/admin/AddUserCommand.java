package com.epam.webapp.command.admin;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entyti.Car;
import com.epam.webapp.entyti.User;
import com.epam.webapp.exception.ServiceExeption;
import com.epam.webapp.services.CarService;
import com.epam.webapp.services.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Optional;

public class AddUserCommand implements Command {
    private static final Logger log = Logger.getLogger(AddUserCommand.class);
    private static final String LOGIN_PARAMETER_NAME = "login";
    private static final String PASSWORD_PARAMETER_NAME = "password";
    private static final String ROLE_PARAMETER_NAME = "role";
    private static final String DISCOUNT_PARAMETER_NAME = "discount";
    private static final String BRAND_PARAMETER_NAME = "brand";
    private static final String MODEL_PARAMETER_NAME = "model";
    private static final String MESSAGE = "Such user already exists";
    private static final String COMMAND = "/webapp/controller?command=showUsers";
    private static final double DEFOULT_DISCOUNT = 100.00;

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceExeption {
        String login = req.getParameter(LOGIN_PARAMETER_NAME);
        String password = req.getParameter(PASSWORD_PARAMETER_NAME);
        String role = req.getParameter(ROLE_PARAMETER_NAME);
        String discount = req.getParameter(DISCOUNT_PARAMETER_NAME);
        String brand = req.getParameter(BRAND_PARAMETER_NAME);
        String model = req.getParameter(MODEL_PARAMETER_NAME);

        UserService userService = new UserService();
        CarService carService = new CarService();

        User user = new User();
        if (role.equals("client")) {
            double doubleDiscountValue = Double.valueOf(discount);
            user.setDiscount(BigDecimal.valueOf(doubleDiscountValue));
        } else {
            user.setDiscount(BigDecimal.valueOf(DEFOULT_DISCOUNT));
        }
        user.setLogin(login)
                .setPassword(password)
                .setRole(role)
                .setActive(true);
        Optional<User> optionalUser = userService.login(login, password);
        if (!optionalUser.isPresent()) {
            userService.addUser(user);
            Optional<User> newOptionalUser = userService.login(login, password);
            if (newOptionalUser.isPresent()) {
                User newUser = newOptionalUser.get();
                int id = newUser.getId();
                Car car = new Car();
                car.setCarModel(model)
                        .setCarBrand(brand)
                        .setId(id);
                carService.addCar(car);
            }
        } else {
            log.info(MESSAGE);
        }
        return CommandResult.redirect(COMMAND);
    }
}
