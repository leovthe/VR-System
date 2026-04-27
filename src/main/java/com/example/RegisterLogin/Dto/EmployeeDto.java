package com.example.RegisterLogin.Dto;

import com.example.RegisterLogin.Entity.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class EmployeeDto {
    @Id

    @Column(name="employee_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeid;


    private String employeename;
    private String email;
    private String password;

    //New field for user role selection
    private UserRole role;

    public EmployeeDto(int employeeid, String employeename, String email, String password, UserRole role) {
        this.employeeid = employeeid;
        this.employeename = employeename;
        this.email = email;
        this.password = password;
        // Assigning the role
        this.role = role;
    }

    public EmployeeDto() {
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
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
        return "EmployeeDTO{" +
                "employeeid=" + employeeid +
                ", employeename='" + employeename + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                // Include role in toString() output
                ", role=" + role +
                '}';
    }
}

