package com.example.RegisterLogin.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    @Id

    @Column(name="employee_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeid;

    @Column(name="employee_name",length = 255)
    private String employeename;

    @Column(name="email",length = 255)
    private String email;

    @Column(name="password",length = 255)
    private String password;

    // specifies that this property should be persisted as a string
    @Enumerated(EnumType.STRING)
    //Assuming the role will be stored as a string in the database
    @Column (name = "role", length = 50)
    // New field for user role
    private UserRole role;

    public Employee(int employeeid, String employeename, String email, String password, UserRole role) {
        this.employeeid = employeeid;
        this.employeename = employeename;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Employee() {
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
        return "Employee{" +
                "employeeid=" + employeeid +
                ", employeename='" + employeename + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
