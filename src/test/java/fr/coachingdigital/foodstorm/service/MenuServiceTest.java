/**
 * 
 */
package fr.coachingdigital.foodstorm.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import fr.coachingdigital.foodstorm.FoodstormApplication;


/**
 * testing methods of IngredientService
 * @author sleray
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
  webEnvironment = WebEnvironment.RANDOM_PORT,
  classes = FoodstormApplication.class)
public class MenuServiceTest {
	@Autowired
	MenuService menuService;
	
	@Test
	public void randomMenuTest() {
		System.out.println(menuService.getRandomMenu());
		
		
	}

}
