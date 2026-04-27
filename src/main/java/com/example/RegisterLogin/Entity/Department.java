package com.example.RegisterLogin.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long departmentId;
    private String departmentHead;
    private String departmentName;

    public Department(Long departmentId, String departmentHead, String departmentName) {
        this.departmentId = departmentId;
        this.departmentHead = departmentHead;
        this.departmentName = departmentName;
    }

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentHead='" + departmentHead + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
