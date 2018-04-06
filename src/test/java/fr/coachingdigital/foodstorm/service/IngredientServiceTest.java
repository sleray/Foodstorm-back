/**
 * 
 */
package fr.coachingdigital.foodstorm.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import fr.coachingdigital.foodstorm.FoodstormApplication;
import fr.coachingdigital.foodstorm.model.GroupIngredient;
import fr.coachingdigital.foodstorm.model.Ingredient;
import fr.coachingdigital.foodstorm.model.TypeIngredient;


/**
 * testing methods of IngredientService
 * @author sleray
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
  webEnvironment = WebEnvironment.RANDOM_PORT,
  classes = FoodstormApplication.class)
public class IngredientServiceTest {
	@Autowired
	IngredientService ingredientService;
	@Autowired
	TypeIngredientService typeIngredientService;
	@Autowired
	GroupIngredientService groupIngredientService;
	@Test
	public void crudTest() {
		//creating side objects
		GroupIngredient main = new GroupIngredient();
		main.setName("Main");
		//getting full object with generated id
		main = groupIngredientService.addGroupIngredient(main);
		
		//creating side objects
		TypeIngredient viande = new TypeIngredient();
		viande.setName("Viande");
		//getting full object with generated id
		viande = typeIngredientService.addTypeIngredient(viande);
		
		//creating main object
		Ingredient poulet = new Ingredient();
		poulet.setName("PouletTestThisNameShouldBeUnique");
		poulet.setType(viande);
		poulet.setGroups(new HashSet<GroupIngredient>());
		poulet.getGroups().add(main);
		
		poulet = ingredientService.addIngredient(poulet);
		
		//Tying to find our new ingredient by id
		Optional<Ingredient> result = ingredientService.getIngredientById(poulet.getId());
		Assert.assertTrue(result.isPresent());
		//Trying to find our new ingredient by name
		List<Ingredient> result2 = ingredientService.getIngredientByName("PouletTestThisNameShouldBeUnique");
		Assert.assertFalse(result2.isEmpty());
		Assert.assertTrue(result2.size() == 1);
		//Deleting 
		ingredientService.deleteIngredient(result.get().getId());
		//checking if we can't find it anymore
		Optional<Ingredient> result3 = ingredientService.getIngredientById(poulet.getId());
		Assert.assertFalse(result3.isPresent());
		
	}

}
