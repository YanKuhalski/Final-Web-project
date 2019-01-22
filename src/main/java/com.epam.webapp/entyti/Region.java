package com.epam.webapp.entyti;

public class Region implements Identifiable,Comparable {
    private int id;
    private String name;
    private int zoneNumber;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getZoneNumber() {
        return zoneNumber;
    }

    public Region setId(int id) {
        this.id = id;
        return this;
    }

    public Region setName(String name) {
        this.name = name;
        return this;
    }

    public Region setZoneNumber(int zoneNumber) {
        this.zoneNumber = zoneNumber;
        return this;
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
        return this.zoneNumber == otherRegion.getZoneNumber() || this.name.equals(otherRegion.getName());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getZoneNumber();
        return result;
    }

}

