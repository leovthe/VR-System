package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.Dto.EmployeeDto;
import com.example.RegisterLogin.Dto.LoginDto;
import com.example.RegisterLogin.Response.LoginResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface EmployeeService {


    String addEmployee(EmployeeDto employeeDTO);

    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

    LoginResponse loginEmployee(LoginDto loginDTO);

    LoginResponse logout();
}
