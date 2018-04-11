/**
 * 
 */
package fr.coachingdigital.foodstorm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.coachingdigital.foodstorm.model.GroupIngredient;
import fr.coachingdigital.foodstorm.model.Ingredient;

/**
 * @author sleray
 *
 */
@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long>{
	List<Ingredient> findByName(String name);
	List<Ingredient> findByGroups(GroupIngredient group);
	long countByGroups(GroupIngredient group);
	
	@Query(value="SELECT i.* FROM Ingredient i, ingredient_group_ingredient igi where igi.ingredients_ingr_id = i.ingr_id AND igi.groups_ingr_group_id = :groupId ORDER BY RANDOM() LIMIT 1;", nativeQuery = true)
	Ingredient findRandomByGroup(@Param("groupId") Long groupId);

}
