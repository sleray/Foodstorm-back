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

	/**
	 * Repository for the family table
	 */
	FamilyRepository familyRepository;
	
	/**
	 * Default
	 * @param familyRepository the familyrepository to set
	 */
	public FamilyService(FamilyRepository familyRepository) {
		this.familyRepository = familyRepository;
	}
	
	/**
	 * Method to get a family by id
	 * @param id the id of the search
	 * @return An optional refered to Family object
	 */
	public Optional<Family> getFamilyById(long id){
		return familyRepository.findById(id);
	}
	
	
	/**
	 * Method for updating an existing family
	 * @param family the family to update
	 * @return the family updated
	 */
	public Family updateFamily(Family family) {
		return familyRepository.save(family);
	}
	
	/**
	 * Method for adding a family on BDD
	 * @param family the family to add
	 * @return the family updated
	 */
	public Family addFamily(Family family) {
		return familyRepository.save(family);
	}
	
	/**
	 * Method for deleting a family by id
	 * @param id the id of the family to delte
	 */
	public void deleteFamilyById(long id) {
		familyRepository.deleteById(id);
	}
	/**
	 * Method for deleting a family by family object
	 * @param family the family object to delete
	 */
	public void deleteFamilyByFamily(Family family) {
		familyRepository.delete(family);
	}
}
