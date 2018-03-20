package fr.coachingdigital.foodstorm.controller;

import java.net.URI;
import java.util.Collection;
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

import org.springframework.stereotype.Component;

import fr.coachingdigital.foodstorm.model.Ingredient;
import fr.coachingdigital.foodstorm.service.IngredientService;

@Component
@Path("/ingredients")
public class IngredientController {

	private final IngredientService ingredientService;

	public IngredientController(IngredientService ingredientService) {
		this.ingredientService = ingredientService;
	}

	@GET
	@Produces("application/json")
	public Collection<Ingredient> getAllIngredients() {

		return ingredientService.getAllIngredients();
	}

	@GET
	@Produces("application/json")
	@Path("/{oid}")
	public Response getIngredient(@PathParam("oid") Long oid) {
		Optional<Ingredient> result = ingredientService.getIngredientById(oid);
		if (result.isPresent()) {
			return Response.status(Response.Status.ACCEPTED).entity(result.get()).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

	}

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response addIngredient(Ingredient ingredient) {
		ingredientService.addIngredient(ingredient);
		return Response.created(URI.create("/" + ingredient.getId())).build();
	}

	@PUT
	@Consumes("application/json")

	public Response updateIngredient(Ingredient ingredient) {
		ingredientService.updateIngredient(ingredient);
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{oid}")
	public Response deleteIngredient(@PathParam("oid") Long oid) {
		ingredientService.deleteIngredient(oid);
		return Response.ok().build();
	}
}
