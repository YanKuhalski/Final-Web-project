package com.epam.webapp.entyti;

import java.io.Serializable;
import java.util.Random;

public class User implements Serializable {
    private static int AMOUNT_OF_ZONES = 6;
    public static String ID_COLUMN_NAME = "id";
    public static String LOGIN_COLUMN_NAME = "login";
    public static String ROLE_COLUMN_NAME = "role";
    public static String DISCOUNT_ID_COLUMN_NAME = "discount_id";
    public static String IS_ACTIVE_COLUMN_NAME = "is_active";
    private int id;
    private String login;
    private String role;
    private int discountId;
    private boolean isActive;
    private int concurrentRegionId;

    public User(int id, String login, String role, int discountId, boolean isActive) {
        this.id = id;
        this.login = login;
        this.role = role;
        this.discountId = discountId;
        this.isActive = isActive;
        concurrentRegionId = new Random().nextInt(AMOUNT_OF_ZONES) + 1;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getRole() {
        return role;
    }

    public int getDiscountId() {
        return discountId;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getConcurrentRegionId() {
        return concurrentRegionId;
    }
}
