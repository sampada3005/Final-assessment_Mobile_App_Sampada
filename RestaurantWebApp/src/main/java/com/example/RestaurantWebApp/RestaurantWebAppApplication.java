package com.example.RestaurantWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1")
public class RestaurantWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantWebAppApplication.class, args);
	}

	@GetMapping("/test")
	public String getTesting(){
		return " working !!!!";
	}

}
