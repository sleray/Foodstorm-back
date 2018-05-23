/**
 * 
 */
package fr.coachingdigital.foodstorm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.coachingdigital.foodstorm.model.GroupIngredient;
import fr.coachingdigital.foodstorm.model.Ingredient;
import fr.coachingdigital.foodstorm.repo.GroupIngredientRepository;
import fr.coachingdigital.foodstorm.repo.IngredientRepository;

/**
 * @author sleray
 *
 */
@Service
public class MenuService {


	IngredientRepository ingredientRepository;
	
	GroupIngredientRepository groupIngredientRepository;
	
	/**
	 * @param ingredientRepository
	 */
	public MenuService(IngredientRepository ingredientRepository, GroupIngredientRepository groupIngredientRepository) {
		
		this.ingredientRepository = ingredientRepository;
		
		this.groupIngredientRepository = groupIngredientRepository;
	}

	/**
	 * Create a random Menu, picking one ingredient of each group from the DB.
	 * @return
	 */
	public List<Ingredient> getRandomMenu() {
		Iterable<GroupIngredient> datas = groupIngredientRepository.findAll();
		List<GroupIngredient> result = new ArrayList<>();
		datas.forEach(result::add);
		
		List<Ingredient> menu = new ArrayList<>();
		
		for (GroupIngredient groupIngredient : result) {
			//Pick one Ingredient by its groupID
			Ingredient ingredient = ingredientRepository.findRandomByGroup(groupIngredient.getId());
			if (ingredient != null) {				
				if (ingredient.getGroups().size() > 1) {
					// on vide la liste de groupe d'ingrédients liée à cet ingrédient dans le cas où un ingrédient appartient à 2 groupes
					ingredient.getGroups().clear();
					ingredient.getGroups().add(groupIngredient);
				}				
				//Add it to the menu
				menu.add(ingredient);	
				System.out.println(ingredient);
				
				
			}
				
			
			
		}
		
		return menu;
		
		
	}

}
