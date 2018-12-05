package com.epam.webapp.entyti;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String role;

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }
}
