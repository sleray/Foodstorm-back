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

import fr.coachingdigital.foodstorm.model.GroupIngredient;
import fr.coachingdigital.foodstorm.service.GroupIngredientService;

@Component
@Path("/groupingredients")
public class GroupIngredientController {

	private final GroupIngredientService groupIngredientService;

	public GroupIngredientController(GroupIngredientService groupIngredientService) {
		this.groupIngredientService = groupIngredientService;
	}

	@GET
	@Produces("application/json")
	public Collection<GroupIngredient> getAllGroupIngredients() {

		return groupIngredientService.getAllGroupIngredients();
	}

	@GET
	@Produces("application/json")
	@Path("/{oid}")
	public Response getGroupIngredient(@PathParam("oid") Long oid) {
		Optional<GroupIngredient> result = groupIngredientService.getGroupIngredientById(oid);
		if (result.isPresent()) {
			return Response.status(Response.Status.ACCEPTED).entity(result.get()).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

	}

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response addGroupIngredient(GroupIngredient groupIngredient) {
		groupIngredientService.addGroupIngredient(groupIngredient);
		return Response.created(URI.create("/" + groupIngredient.getId())).build();
	}

	@PUT
	@Consumes("application/json")

	public Response updateGroupIngredient(GroupIngredient groupIngredient) {
		groupIngredientService.updateGroupIngredient(groupIngredient);
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{oid}")
	public Response deleteGroupIngredient(@PathParam("oid") Long oid) {
		groupIngredientService.deleteGroupIngredient(oid);
		return Response.ok().build();
	}
}
