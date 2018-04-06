/**
 * 
 */
package fr.coachingdigital.foodstorm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.coachingdigital.foodstorm.model.GroupIngredient;
import fr.coachingdigital.foodstorm.repo.GroupIngredientRepository;

/**
 * @author sleray
 *
 */
@Service
public class GroupIngredientService {


	GroupIngredientRepository groupIngredientRepository;
	
	/**
	 * @param ingredientRepository
	 */
	public GroupIngredientService(GroupIngredientRepository groupIngredientRepository) {
		
		this.groupIngredientRepository = groupIngredientRepository;
	}

	public Optional<GroupIngredient> getGroupIngredientById(long id) {
		
		return groupIngredientRepository.findById(id);
		
	}
	
	public List<GroupIngredient> getAllGroupIngredients() {
		Iterable<GroupIngredient> datas = groupIngredientRepository.findAll();
		List<GroupIngredient> result = new ArrayList<>();
		datas.forEach(result::add);
		return result;
		
	}

	public void deleteGroupIngredient(Long oid) {
		//Good practice ??
		GroupIngredient groupIngredientToDelete = new GroupIngredient();
		groupIngredientToDelete.setId(oid);
		groupIngredientRepository.delete(groupIngredientToDelete);
		
	}

	public GroupIngredient updateGroupIngredient( GroupIngredient groupIngredient) {
		return groupIngredientRepository.save(groupIngredient);
		
	}

	public GroupIngredient addGroupIngredient(GroupIngredient groupIngredient) {
		return groupIngredientRepository.save(groupIngredient);
		
	}
}
