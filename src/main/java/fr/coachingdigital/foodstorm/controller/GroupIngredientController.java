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
	public ResponseEntity<GroupIngredient> getGroupIngredient(@PathVariable("id") Long id) {
		Optional<GroupIngredient> result = groupIngredientService.getGroupIngredientById(id);
		if (result.isPresent()) {
			return new ResponseEntity<GroupIngredient>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<GroupIngredient>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<GroupIngredient> addGroupIngredient(@RequestBody GroupIngredient groupIngredient) {
		GroupIngredient result = groupIngredientService.addGroupIngredient(groupIngredient);
		return new ResponseEntity<GroupIngredient>(result, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<GroupIngredient> updateGroupIngredient(@RequestBody GroupIngredient groupIngredient) {
		GroupIngredient result = groupIngredientService.updateGroupIngredient(groupIngredient);
		return new ResponseEntity<GroupIngredient>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<String> deleteGroupIngredient(@PathVariable("id") Long id) {
		groupIngredientService.deleteGroupIngredient(id);
		return new ResponseEntity<String>("GroupIngredient deleted successfully", HttpStatus.OK);
	}
}
