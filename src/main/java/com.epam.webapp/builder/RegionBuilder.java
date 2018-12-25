package com.epam.webapp.builder;

import com.epam.webapp.entyti.Region;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegionBuilder implements Builder<Region> {
    @Override
    public List<Region> build(ResultSet set) throws SQLException {
        List <Region> regions = new ArrayList<>();
        while (set.next()){
            int id = set.getInt(Region.ID_COLUMN_NAME);
            String name = set.getString(Region.NAME_COLUMN_NAME);
            int zoneNumber = set.getInt(Region.ZONE_NUMBER_COLUMN_NAME);
            regions.add( new Region(id, name, zoneNumber));
        }
        return regions ;
    }
}
