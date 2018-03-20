/**
 * 
 */
package fr.coachingdigital.foodstorm;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import fr.coachingdigital.foodstorm.controller.IngredientController;

/**
 * @author sleray
 *
 */
@Configuration
@ApplicationPath("rest")
public class JerseyConfiguration extends ResourceConfig {
	public JerseyConfiguration() {
		
	}
	
	@PostConstruct
	public void setUp() {
		register(IngredientController.class);
		register(GenericExceptionMapper.class);
	}
}
