package fr.coachingdigital.foodstorm;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FoodstormApplication extends SpringBootServletInitializer{
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(FoodstormApplication.class);
	    }
	public static void main(String[] args) {
		 new FoodstormApplication().configure(new SpringApplicationBuilder(FoodstormApplication.class)).run(args);
		
	}
}
