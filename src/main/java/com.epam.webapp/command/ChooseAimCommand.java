package com.epam.webapp.command;

import com.epam.webapp.entyti.Region;
import com.epam.webapp.services.RegionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Set;

public class ChooseAimCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) {
        RegionService service = new RegionService();
        Set<Region> allRegionsList = service.getAllRegionsList();
        req.setAttribute("regions", new ArrayList<>(allRegionsList));
        return CommandResult.forward("/WEB-INF/pages/chooseAim.jsp");
    }
}
