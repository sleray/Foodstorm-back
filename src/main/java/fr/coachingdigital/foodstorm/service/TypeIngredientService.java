/**
 * 
 */
package fr.coachingdigital.foodstorm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.coachingdigital.foodstorm.model.TypeIngredient;
import fr.coachingdigital.foodstorm.repo.TypeIngredientRepository;

/**
 * @author sleray
 *
 */
@Service
public class TypeIngredientService {


	TypeIngredientRepository typeIngredientRepository;
	
	/**
	 * @param ingredientRepository
	 */
	public TypeIngredientService(TypeIngredientRepository typeIngredientRepository) {
		
		this.typeIngredientRepository = typeIngredientRepository;
	}

	public Optional<TypeIngredient> getTypeIngredientById(long id) {
		
		return typeIngredientRepository.findById(id);
		
	}
	
	public List<TypeIngredient> getAllTypeIngredients() {
		Iterable<TypeIngredient> datas = typeIngredientRepository.findAll();
		List<TypeIngredient> result = new ArrayList<>();
		datas.forEach(result::add);
		return result;
		
	}

	public void deleteTypeIngredient(Long oid) {
		//Good practice ??
		TypeIngredient typeIngredientToDelete = new TypeIngredient();
		typeIngredientToDelete.setId(oid);
		typeIngredientRepository.delete(typeIngredientToDelete);
		
	}

	public TypeIngredient updateTypeIngredient( TypeIngredient typeIngredient) {
		return typeIngredientRepository.save(typeIngredient);
		
	}

	public TypeIngredient addTypeIngredient(TypeIngredient typeIngredient) {
		return typeIngredientRepository.save(typeIngredient);
		
	}
}
