package com.epam.webapp.command.client;

import com.epam.webapp.calculator.PriceCalculator;
import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entyti.Car;
import com.epam.webapp.entyti.Discount;
import com.epam.webapp.entyti.Region;
import com.epam.webapp.entyti.User;
import com.epam.webapp.services.CarService;
import com.epam.webapp.services.DiscountService;
import com.epam.webapp.services.RegionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;

public class ChooseCarCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) {
        int endRegionId = Integer.parseInt(req.getParameter("aim"));
        RegionService service = new RegionService();
        Optional<Region> endRegion = service.findRegionById(endRegionId);
        List<Region> allRegionsList = new ArrayList<>(service.getAllRegionsList());
        if (endRegion.isPresent()) {
            Region endRegionValue = endRegion.get();
            req.setAttribute("endRegion", endRegionValue);
            allRegionsList.remove(endRegionValue);
            int randomRegionIndex = new Random().nextInt(allRegionsList.size());
            Region startRegion = allRegionsList.get(randomRegionIndex);
            req.setAttribute("startRegion", startRegion);
            PriceCalculator priceCalculator = new PriceCalculator();
            User user = (User) req.getSession().getAttribute("user");
            int discountId = user.getDiscountId();
            DiscountService discountService = new DiscountService();
            Optional<Discount> discount = discountService.findDiscountById(discountId);
            if (discount.isPresent()) {
                BigDecimal price = priceCalculator.calculatePrice(endRegionValue, startRegion, discount.get());
                req.setAttribute("price", price.doubleValue());
            }
            CarService carService = new CarService();
            int startRegionZoneNumber = startRegion.getZoneNumber();
            List<Car> freeCarsNear = new ArrayList<>(carService.findFreeCarsNear(startRegionZoneNumber));
            req.setAttribute("freeCars", freeCarsNear);
        }
        return CommandResult.forward("/WEB-INF/pages/chooseCar.jsp");
    }


}
