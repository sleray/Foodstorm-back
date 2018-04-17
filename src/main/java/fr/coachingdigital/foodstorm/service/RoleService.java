package fr.coachingdigital.foodstorm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.coachingdigital.foodstorm.model.Role;
import fr.coachingdigital.foodstorm.repo.RoleRepository;


/**
 * 
 * @author Jean-Philippe
 *
 */
@Service
public class RoleService {
	/**
	 * Repository for the role table
	 */
	RoleRepository roleRepository;
	
	/**
	 * Default
	 * @param roleRepository the repository to set
	 */
	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	/**
	 * Method for getting a role by id
	 * @param id the id of the role to get
	 * @return An optional refered to role
	 */
	public Optional<Role> getRoleById(long id){
		return roleRepository.findById(id);
	}
	
	/**
	 * Method for getting a list of role
	 * @param name the name of the roles to get
	 * @return a list of role
	 */
	public List<Role> gerRoleByName(String name){
		return roleRepository.findByName(name);
	}
	
	/**
	 * Method for updating a role
	 * @param role the role to update
	 * @return the role updated
	 */
	public Role updateRole(Role role) {
		return roleRepository.save(role);
	}
	
	/**
	 * Method for adding a role
	 * @param role the role to add
	 * @return the role added
	 */
	public Role addRole(Role role) {
		return roleRepository.save(role);
	}
	
	/**
	 * Method for deleting a role by id
	 * @param id the id of the role to delete
	 */
	public void deleteRoleById(long id) {
		roleRepository.deleteById(id);
	}
	/**
	 * Method for deleting a role by role 
	 * @param role the role to delete
	 */
	public void deleteRoleByRole(Role role) {
		roleRepository.delete(role);
	}

}
