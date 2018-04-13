package fr.coachingdigital.foodstorm.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.coachingdigital.foodstorm.model.Ingredient;
import fr.coachingdigital.foodstorm.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {

	private final MenuService menuService;

	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}



	@RequestMapping(value = "/random", method= RequestMethod.GET)
	public List<Ingredient> getRandomMenu() {
		return menuService.getRandomMenu();
		

	}

}
