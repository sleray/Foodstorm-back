package fr.coachingdigital.foodstorm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication

public class FoodstormApplication extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(FoodstormApplication.class, args);
	}
}
