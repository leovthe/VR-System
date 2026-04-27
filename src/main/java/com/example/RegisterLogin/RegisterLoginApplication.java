package com.example.RegisterLogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan("com.example.RegisterLogin")
public class RegisterLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterLoginApplication.class, args);
	}

}
