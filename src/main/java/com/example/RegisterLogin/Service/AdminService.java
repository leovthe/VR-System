package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.Entity.Admin;

public interface AdminService {
    Admin findByEmail(String email);
    Admin save(Admin admin);
}
