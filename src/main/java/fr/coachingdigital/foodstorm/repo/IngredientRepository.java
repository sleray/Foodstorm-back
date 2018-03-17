/**
 * 
 */
package fr.coachingdigital.foodstorm.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.coachingdigital.foodstorm.bean.Ingredient;

/**
 * @author sleray
 *
 */
public interface IngredientRepository extends CrudRepository<Ingredient, Long>{
	List<Ingredient> findByName(String name);

}
