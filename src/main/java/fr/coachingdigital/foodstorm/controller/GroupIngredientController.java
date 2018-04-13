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

import fr.coachingdigital.foodstorm.model.GroupIngredient;
import fr.coachingdigital.foodstorm.service.GroupIngredientService;

@RestController
@RequestMapping("/groupingredients")
public class GroupIngredientController {

	private final GroupIngredientService groupIngredientService;

	public GroupIngredientController(GroupIngredientService groupIngredientService) {
		this.groupIngredientService = groupIngredientService;
	}

	@RequestMapping(value = "/", method= RequestMethod.GET)
	public Collection<GroupIngredient> getAllGroupIngredients() {

		return groupIngredientService.getAllGroupIngredients();
	}

	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public ResponseEntity<String> getGroupIngredient(@PathVariable("id") Long id) {
		Optional<GroupIngredient> result = groupIngredientService.getGroupIngredientById(id);
		if (result.isPresent()) {
			return new ResponseEntity<String>("GroupIngredient found", HttpStatus.FOUND);
		} else {
			return new ResponseEntity<String>("GroupIngredient not found", HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<String> addGroupIngredient(@RequestBody GroupIngredient groupIngredient) {
		groupIngredientService.addGroupIngredient(groupIngredient);
		return new ResponseEntity<String>("GroupIngredient created successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<String> updateGroupIngredient(@RequestBody GroupIngredient groupIngredient) {
		groupIngredientService.updateGroupIngredient(groupIngredient);
		return new ResponseEntity<String>("GroupIngredient updated successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<String> deleteGroupIngredient(@PathVariable("id") Long id) {
		groupIngredientService.deleteGroupIngredient(id);
		return new ResponseEntity<String>("GroupIngredient deleted successfully", HttpStatus.OK);
	}
}
