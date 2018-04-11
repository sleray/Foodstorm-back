package fr.coachingdigital.foodstorm.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import fr.coachingdigital.foodstorm.model.Ingredient;
import fr.coachingdigital.foodstorm.service.MenuService;

@Component
@Path("/menu")
public class MenuController {

	private final MenuService menuService;

	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}


	@GET
	@Produces("application/json")
	@Path("/random")
	public List<Ingredient> getRandomMenu() {
		return menuService.getRandomMenu();
		

	}

}
