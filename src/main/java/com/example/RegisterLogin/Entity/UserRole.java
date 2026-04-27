package com.example.RegisterLogin.Entity;

public enum UserRole {
    ADMINISTRATOR("Administrator"),
    DRIVER("Driver"),
    HEAD_OF_DEPARTMENT("Head of Department"),
    HUMAN_RESOURCES("Human Resources");

    private final String roleName;
     UserRole(String roleName) {
         this.roleName = roleName;
     }

    public String getRoleName() {
        return roleName;
    }
}
