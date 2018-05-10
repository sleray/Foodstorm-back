package fr.coachingdigital.foodstorm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
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
	public ResponseEntity<List<TypeIngredient>> getAllTypeIngredients() {
		//HttpHeaders responseHeaders = new HttpHeaders();
		//To allow localhost to access data from stagging or prod.
		//responseHeaders.set("Access-Control-Allow-Origin", "*");
		return new ResponseEntity<List<TypeIngredient>>(typeIngredientService.getAllTypeIngredients(),HttpStatus.OK);

	}

	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public ResponseEntity<TypeIngredient> getTypeIngredient(@PathVariable("id") Long id) {
		
		Optional<TypeIngredient> result = typeIngredientService.getTypeIngredientById(id);
		if (result.isPresent()) {
			return new ResponseEntity<TypeIngredient>(result.get(), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<TypeIngredient>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<TypeIngredient> addTypeIngredient(@RequestBody TypeIngredient typeIngredient) {
		/*HttpHeaders responseHeaders = new HttpHeaders();
		//To allow localhost to access data from stagging or prod.
		responseHeaders.set("Access-Control-Allow-Origin", "*");
		responseHeaders.set("Access-Control-Allow-Methods", "POST");
		responseHeaders.set("Access-Control-Allow-headers", "Content-Type,Accept");*/
		TypeIngredient result = typeIngredientService.addTypeIngredient(typeIngredient);
		return new ResponseEntity<TypeIngredient>(result,HttpStatus.CREATED);
	}/*
	// Answer to the preflight CORS request that all is allowed cross domain (free donuts !)
	@RequestMapping(value = "/", method = RequestMethod.OPTIONS)
	public ResponseEntity<String> handleCORS() {
		HttpHeaders responseHeaders = new HttpHeaders();
		//To allow localhost to access data from stagging or prod.
		responseHeaders.set("Access-Control-Allow-Origin", "*");
		responseHeaders.set("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
		responseHeaders.set("Access-Control-Allow-headers", "Content-Type,Accept");
		return new ResponseEntity<String>("Donuts ", responseHeaders,HttpStatus.OK);
	}*/

	@RequestMapping(value = "/", method= RequestMethod.PUT)
	public ResponseEntity<TypeIngredient> updateTypeIngredient(TypeIngredient typeIngredient) {
		TypeIngredient result = typeIngredientService.updateTypeIngredient(typeIngredient);
		return new ResponseEntity<TypeIngredient>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<String> deleteTypeIngredient(@PathVariable("id") Long id) {
		typeIngredientService.deleteTypeIngredient(id);
		return new ResponseEntity<String>("TypeIngredient deleted successfully", HttpStatus.OK);
	}
}
