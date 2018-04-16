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
	
	public Family updateFamily(Family family) {
		return familyRepository.save(family);
	}
	
	public Family addFamily(Family family) {
		return familyRepository.save(family);
	}
	
	public void deleteFamilyById(long id) {
		familyRepository.deleteById(id);
	}
	public void deleteFamilyByFamily(Family family) {
		familyRepository.delete(family);
	}
}
