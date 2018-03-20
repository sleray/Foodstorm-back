/**
 * 
 */
package fr.coachingdigital.foodstorm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.coachingdigital.foodstorm.model.Ingredient;
import fr.coachingdigital.foodstorm.repo.IngredientRepository;

/**
 * @author sleray
 *
 */
@Service
public class IngredientService {


	IngredientRepository ingredientRepository;
	
	/**
	 * @param ingredientRepository
	 */
	public IngredientService(IngredientRepository ingredientRepository) {
		
		this.ingredientRepository = ingredientRepository;
	}

	public Optional<Ingredient> getIngredientById(long id) {
		
		return ingredientRepository.findById(id);
		
	}
	
	public List<Ingredient> getAllIngredients() {
		Iterable<Ingredient> datas = ingredientRepository.findAll();
		List<Ingredient> result = new ArrayList<>();
		datas.forEach(result::add);
		return result;
		
	}

	public void deleteIngredient(Long oid) {
		//Good practice ??
		Ingredient ingredientToDelete = new Ingredient();
		ingredientToDelete.setId(oid);
		ingredientRepository.delete(ingredientToDelete);
		
	}

	public void updateIngredient( Ingredient ingredient) {
		ingredientRepository.save(ingredient);
		
	}

	public void addIngredient(Ingredient ingredient) {
		ingredientRepository.save(ingredient);
		
	}
}
