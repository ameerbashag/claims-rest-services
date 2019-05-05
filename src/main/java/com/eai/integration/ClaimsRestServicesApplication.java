package com.eai.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ClaimsRestServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClaimsRestServicesApplication.class, args);
	}
	
}
