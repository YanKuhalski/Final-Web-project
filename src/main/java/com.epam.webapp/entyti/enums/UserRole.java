package com.epam.webapp.entyti.enums;

public enum UserRole {
    ADMIN("admin"),
    CLIENT("client"),
    DRIVER("driver");
    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
