package com.spring.antsway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AntswayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AntswayApplication.class, args);
	}

	@GetMapping("/")
	public String helloWorld() {
		return String.format("Hello ! The api is at /api/customers, and you can access the database at /h2-console");
	}
 
}
