package com.epam.webapp.entyti;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Region implements Comparable {
    public static String ID_COLUMN_NAME = "id";
    public static String NAME_COLUMN_NAME = "name";
    public static String ZONE_NUMBER_COLUMN_NAME = "zone_number";
    private int id;
    private String name;
    private int zoneNumber;

    public Region(int id, String name, int zoneNumber) {
        this.id = id;
        this.name = name;
        this.zoneNumber = zoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getZoneNumber() {
        return zoneNumber;
    }

    @Override
    public int compareTo(Object otherObject) {
        if (otherObject.getClass() == Region.class) {
            Region otherRegion = (Region) otherObject;
            int result = name.compareTo(otherRegion.getName());
            if (result != 0) {
                return result;
            } else {
                return zoneNumber - otherRegion.getZoneNumber();
            }
        }
        return 0;
    }


    @Override
    public boolean equals(Object otherObjaect) {
        if (this == otherObjaect) {
            return true;
        }
        if (!(otherObjaect.getClass() == Region.class)) {
            return false;
        }

        Region otherRegion = (Region) otherObjaect;

        if (this.id != otherRegion.getId()) {
            return false;
        }
        if (this.zoneNumber != otherRegion.getZoneNumber() && this.name != otherRegion.getName()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getZoneNumber();
        return result;
    }

}

