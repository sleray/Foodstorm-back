/**
 * 
 */
package fr.coachingdigital.foodstorm.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.coachingdigital.foodstorm.model.TypeIngredient;

/**
 * @author sleray
 *
 */
@Repository
public interface TypeIngredientRepository extends CrudRepository<TypeIngredient, Long>{
	

}
