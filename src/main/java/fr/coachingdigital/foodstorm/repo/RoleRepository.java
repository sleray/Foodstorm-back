package fr.coachingdigital.foodstorm.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.coachingdigital.foodstorm.model.Role;

/**
 * 
 * @author Jean-Philippe
 *
 */
@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {
	List<Role> findByName(String name);
}
