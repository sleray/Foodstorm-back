package fr.coaching.foodstorm.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.coaching.foodstorm.bean.Ingredient;
import fr.coaching.foodstorm.bean.TypeIngredient;

@Path("ingredients")
public class IngredientResource {

	@GET
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Ingredient getIngredientById(Long id) {
		Ingredient sample = new Ingredient();
		sample.setId(id);
		sample.setName("Haricots verts");
		TypeIngredient type = new TypeIngredient();
		type.setId(123L);
		type.setName("Légumes");
		sample.setType(type);
		//get the ingredient
		
		//JSONify it
		
		//return
		return sample;
		
	}
	
}
