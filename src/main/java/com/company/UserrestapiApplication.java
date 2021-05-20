package com.company;

import com.company.controller.UserRestController;
import com.company.entity.User;
import com.company.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UserrestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserrestapiApplication.class, args);
	}
}


