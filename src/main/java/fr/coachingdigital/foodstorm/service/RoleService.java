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
	
	RoleRepository roleRepository;
	
	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	public Optional<Role> getRoleById(long id){
		return roleRepository.findById(id);
	}
	
	public List<Role> gerRoleByName(String name){
		return roleRepository.findByName(name);
	}

}
