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

import fr.coachingdigital.foodstorm.model.TypeIngredient;
import fr.coachingdigital.foodstorm.service.TypeIngredientService;

@Component
@Path("/typeingredients")
public class TypeIngredientController {

	private final TypeIngredientService typeIngredientService;

	public TypeIngredientController(TypeIngredientService typeIngredientService) {
		this.typeIngredientService = typeIngredientService;
	}

	@GET
	@Produces("application/json")
	public Collection<TypeIngredient> getAllTypeIngredients() {

		return typeIngredientService.getAllTypeIngredients();
	}

	@GET
	@Produces("application/json")
	@Path("/{oid}")
	public Response getTypeIngredient(@PathParam("oid") Long oid) {
		Optional<TypeIngredient> result = typeIngredientService.getTypeIngredientById(oid);
		if (result.isPresent()) {
			return Response.status(Response.Status.ACCEPTED).entity(result.get()).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

	}

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response addTypeIngredient(TypeIngredient typeIngredient) {
		typeIngredientService.addTypeIngredient(typeIngredient);
		return Response.created(URI.create("/" + typeIngredient.getId())).build();
	}

	@PUT
	@Consumes("application/json")

	public Response updateTypeIngredient(TypeIngredient typeIngredient) {
		typeIngredientService.updateTypeIngredient(typeIngredient);
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{oid}")
	public Response deleteTypeIngredient(@PathParam("oid") Long oid) {
		typeIngredientService.deleteTypeIngredient(oid);
		return Response.ok().build();
	}
}
