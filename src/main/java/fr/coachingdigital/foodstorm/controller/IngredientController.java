package fr.coachingdigital.foodstorm.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.coachingdigital.foodstorm.model.Ingredient;
import fr.coachingdigital.foodstorm.service.IngredientService;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

	private final IngredientService ingredientService;

	public IngredientController(IngredientService ingredientService) {
		this.ingredientService = ingredientService;
	}

	@RequestMapping(value = "/", method= RequestMethod.GET)
	public Collection<Ingredient> getAllIngredients() {

		return ingredientService.getAllIngredients();
	}

	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public ResponseEntity<String> getIngredient(@PathVariable("id") Long id) {
		Optional<Ingredient> result = ingredientService.getIngredientById(id);
		if (result.isPresent()) {
			return new ResponseEntity<String>("Ingredient found", HttpStatus.FOUND);
		} else {
			return new ResponseEntity<String>("Ingredient not found", HttpStatus.NOT_FOUND);
		}


	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<String> addIngredient(@RequestBody Ingredient ingredient) {
		ingredientService.addIngredient(ingredient);
		return new ResponseEntity<String>("Ingredient created successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<String> updateIngredient(@RequestBody Ingredient ingredient) {
		ingredientService.updateIngredient(ingredient);
		return new ResponseEntity<String>("Ingredient updated successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<String> deleteIngredient(@PathVariable("id") Long id) {
		ingredientService.deleteIngredient(id);
		return new ResponseEntity<String>("Ingredient deleted successfully", HttpStatus.OK);
	}
}
