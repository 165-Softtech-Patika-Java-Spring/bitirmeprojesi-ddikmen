package com.softtech.finalassignment.app.account.enums;

public enum AppUserRole {

    USER("user"),
    ADMIN("admin"),
    ;

    private String role;
    AppUserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
