package fr.coachingdigital.foodstorm.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.coachingdigital.foodstorm.model.Family;

/**
 * 
 * @author Jean-Philippe
 *
 */
@Repository
public interface FamilyRepository extends CrudRepository<Family,Long> {

}
