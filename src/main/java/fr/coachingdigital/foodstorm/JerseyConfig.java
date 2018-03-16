/**
 * 
 */
package fr.coachingdigital.foodstorm;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import fr.coachingdigital.foodstorm.resources.IngredientResource;

/**
 * @author sleray
 *
 */
@Component
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig()
    {
        register(IngredientResource.class);
    }
}
