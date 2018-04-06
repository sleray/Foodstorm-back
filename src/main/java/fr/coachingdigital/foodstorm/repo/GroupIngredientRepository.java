/**
 * 
 */
package fr.coachingdigital.foodstorm.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.coachingdigital.foodstorm.model.GroupIngredient;

/**
 * @author sleray
 *
 */
@Repository
public interface GroupIngredientRepository extends CrudRepository<GroupIngredient, Long>{
	

}
