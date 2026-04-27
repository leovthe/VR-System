package com.example.RegisterLogin.Service.impl;

import com.example.RegisterLogin.Entity.Admin;
import com.example.RegisterLogin.Repository.AdminRepository;
import com.example.RegisterLogin.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }
    @Override
    public Admin save(Admin admin){
        return adminRepository.save(admin);
    }
}
