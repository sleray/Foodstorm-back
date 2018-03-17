/**
 * 
 */
package fr.coachingdigital.foodstorm.resources;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import fr.coachingdigital.foodstorm.bean.Ingredient;
import fr.coachingdigital.foodstorm.bean.TypeIngredient;
import fr.coachingdigital.foodstorm.service.IngredientService;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "ingredients")
@Path("/ingredients")
public class IngredientResource {
	private static Map<Integer, Ingredient> DB = new HashMap<>();
	private IngredientService ingredientService = new IngredientService();

	@GET
	@Produces("application/json")
	public List<Ingredient> getAllIngredients() {
		return ingredientService.getIngredients();
		
	}

	@POST
	@Consumes("application/json")
	public Response createIngredient(Ingredient ingredient) throws URISyntaxException {
		if (ingredient.getName() == null) {
			return Response.status(400).entity("Please provide all mandatory inputs").build();
		}
		ingredient.setId(DB.values().size() + 1);

		DB.put(1, ingredient); // FIXME
		return Response.status(201).build();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getIngredientById(@PathParam("id") long id) throws URISyntaxException {
		Optional<Ingredient> result = ingredientService.getIngredientById(id);

		if (result.isPresent()) {
			return Response.status(200).entity(result.get()).build();

		} else {
			return Response.status(404).build();
		}
	}

	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateIngredient(@PathParam("id") long id, Ingredient ingredient) throws URISyntaxException {
		Ingredient temp = DB.get(id);
		if (ingredient == null) {
			return Response.status(404).build();
		}
		temp.setName(ingredient.getName());

		DB.put(1, temp);// FIXME
		return Response.status(200).entity(temp).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteIngredient(@PathParam("id") int id) throws URISyntaxException {
		Ingredient ingredient = DB.get(id);
		if (ingredient != null) {
			DB.remove(ingredient.getId());
			return Response.status(200).build();
		}
		return Response.status(404).build();
	}

	static {
		TypeIngredient viande = new TypeIngredient(1, "Viande");
		Ingredient ingredient1 = new Ingredient(1, "Poulet", viande);

		TypeIngredient legumes = new TypeIngredient(2, "Légumes");
		Ingredient ingredient2 = new Ingredient(2, "Brocolis", legumes);

		DB.put(1, ingredient1);
		DB.put(2, ingredient2);
	}
}