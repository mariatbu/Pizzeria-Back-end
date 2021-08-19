package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class DemoApplication {

	//public static final Logger logger = LogManager.getLogger(DemoApplication.class.getName());
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
