/**
 * 
 */
package fr.coachingdigital.foodstorm.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.coachingdigital.foodstorm.model.Ingredient;

/**
 * @author sleray
 *
 */
@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long>{
	List<Ingredient> findByName(String name);

}
