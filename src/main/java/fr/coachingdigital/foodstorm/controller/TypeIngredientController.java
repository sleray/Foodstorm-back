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

import fr.coachingdigital.foodstorm.model.TypeIngredient;
import fr.coachingdigital.foodstorm.service.TypeIngredientService;

@RestController
@RequestMapping("/typeingredients")
public class TypeIngredientController {

	private final TypeIngredientService typeIngredientService;

	public TypeIngredientController(TypeIngredientService typeIngredientService) {
		this.typeIngredientService = typeIngredientService;
	}

	@RequestMapping(value = "/", method= RequestMethod.GET)
	public Collection<TypeIngredient> getAllTypeIngredients() {
		return typeIngredientService.getAllTypeIngredients();
	}

	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public ResponseEntity<String> getTypeIngredient(@PathVariable("id") Long id) {
		Optional<TypeIngredient> result = typeIngredientService.getTypeIngredientById(id);
		if (result.isPresent()) {
			return new ResponseEntity<String>("TypeIngredient found", HttpStatus.FOUND);
		} else {
			return new ResponseEntity<String>("TypeIngredient not found", HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<String> addTypeIngredient(@RequestBody TypeIngredient typeIngredient) {
		typeIngredientService.addTypeIngredient(typeIngredient);
		return new ResponseEntity<String>("TypeIngredient created successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/", method= RequestMethod.PUT)
	public ResponseEntity<String> updateTypeIngredient(TypeIngredient typeIngredient) {
		typeIngredientService.updateTypeIngredient(typeIngredient);
		return new ResponseEntity<String>("TypeIngredient updated successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<String> deleteTypeIngredient(@PathVariable("id") Long id) {
		typeIngredientService.deleteTypeIngredient(id);
		return new ResponseEntity<String>("TypeIngredient deleted successfully", HttpStatus.OK);
	}
}
