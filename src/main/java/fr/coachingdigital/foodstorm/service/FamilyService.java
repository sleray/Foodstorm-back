package fr.coachingdigital.foodstorm.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.coachingdigital.foodstorm.model.Family;
import fr.coachingdigital.foodstorm.repo.FamilyRepository;

/**
 * 
 * @author Jean-Philippe
 *
 */
@Service
public class FamilyService {

	FamilyRepository familyRepository;
	
	public FamilyService(FamilyRepository familyRepository) {
		this.familyRepository = familyRepository;
	}
	
	public Optional<Family> getFamilyById(long id){
		return familyRepository.findById(id);
	}
}
