package com.epam.webapp.entyti;

import java.math.BigDecimal;
import java.util.Random;

public class User implements Identifiable {
    private static final int AMOUNT_OF_ZONES = 6;

    private int id;
    private String login;
    private String role;
    private String password;
    private BigDecimal discount;
    private boolean isActive;
    private int concurrentRegionId;

    {
        concurrentRegionId = new Random().nextInt(AMOUNT_OF_ZONES) + 1;
    }


    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public BigDecimal getDiscount() {
        return discount ;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getConcurrentRegionId() {
        return concurrentRegionId;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public User setRole(String role) {
        this.role = role;
        return this;
    }

    public User setDiscount(BigDecimal value) {
        this.discount = value;
        return this;
    }

    public User setActive(boolean value) {
        isActive = value;
        return this;
    }

    public User setConcurrentRegionId(int concurrentRegionId) {
        this.concurrentRegionId = concurrentRegionId;
        return this;
    }
}
