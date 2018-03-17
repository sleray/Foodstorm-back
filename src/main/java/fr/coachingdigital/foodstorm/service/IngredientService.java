/**
 * 
 */
package fr.coachingdigital.foodstorm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.coachingdigital.foodstorm.bean.Ingredient;
import fr.coachingdigital.foodstorm.repo.IngredientRepository;

/**
 * @author sleray
 *
 */
public class IngredientService {

	@Autowired
	IngredientRepository repository;
	
	public Optional<Ingredient> getIngredientById(long id) {
		return repository.findById(id);
		
	}
	
	public List<Ingredient> getIngredients() {
		Iterable<Ingredient> datas = repository.findAll();
		List<Ingredient> result = new ArrayList<>();
		datas.forEach(result::add);
		return result;
		
	}
}
