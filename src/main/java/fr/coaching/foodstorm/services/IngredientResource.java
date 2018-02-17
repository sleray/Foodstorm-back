package fr.coaching.foodstorm.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.coaching.foodstorm.bean.Ingredient;
import fr.coaching.foodstorm.bean.TypeIngredient;

@Path("ingredients")
public class IngredientResource {

	@GET
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public Ingredient getIngredientById(@PathParam("id") Long id) {
		//get the fake ingredient
		Ingredient sample = new Ingredient(id,"Haricots verts",new TypeIngredient(123L,"Légumes"));

		//return
		return sample;
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ingredient> getAllIngredients() {
		List<Ingredient> ingredients = new ArrayList<>();
		
		ingredients.add(new Ingredient(1L,"Ingrédient 1", new TypeIngredient(1L,"Type 1")));
		ingredients.add(new Ingredient(2L,"Ingrédient 2", new TypeIngredient(2L,"Type 2")));
		ingredients.add(new Ingredient(3L,"Ingrédient 3", new TypeIngredient(2L,"Type 2")));
		ingredients.add(new Ingredient(4L,"Ingrédient 4", new TypeIngredient(5L,"Type 5")));
		ingredients.add(new Ingredient(5L,"Ingrédient 5", new TypeIngredient(3L,"Type 3")));
		ingredients.add(new Ingredient(6L,"Ingrédient 6", new TypeIngredient(3L,"Type 3")));
		
		return ingredients;
	}
	
}
