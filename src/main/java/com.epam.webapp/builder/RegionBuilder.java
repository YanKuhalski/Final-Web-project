package com.epam.webapp.builder;

import com.epam.webapp.entyti.Region;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegionBuilder implements Builder<Region> {
    private static final String ID_COLUMN_NAME = "id";
    private static final String NAME_COLUMN_NAME = "name";
    private static final String ZONE_NUMBER_COLUMN_NAME = "zone_number";

    @Override
    public Region build(ResultSet setElement) throws SQLException {
        int id = setElement.getInt(ID_COLUMN_NAME);
        String name = setElement.getString(NAME_COLUMN_NAME);
        int zoneNumber = setElement.getInt(ZONE_NUMBER_COLUMN_NAME);
        Region region = new Region();
        region.setId(id)
                .setName(name)
                .setZoneNumber(zoneNumber);
        return region;
    }
}
