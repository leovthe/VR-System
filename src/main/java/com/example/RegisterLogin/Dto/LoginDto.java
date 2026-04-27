package com.example.RegisterLogin.Dto;

import com.example.RegisterLogin.Entity.UserRole;

public class LoginDto {

    private String email;
    private String password;
    private UserRole role;

    public LoginDto(String email, String password, UserRole role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public LoginDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
