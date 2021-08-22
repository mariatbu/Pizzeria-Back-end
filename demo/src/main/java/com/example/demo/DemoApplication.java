package com.example.demo;


import java.util.UUID;

import com.example.demo.domain.userdomain.User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class DemoApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		log.info("arg0");
		User user = new User();
		user.setName("Carlos");
		user.setLastName("Castillo");
		user.setEmail("email");
		user.setPassword("");
		user.setId(UUID.randomUUID());
		
	}

}
