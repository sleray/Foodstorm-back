package fr.coachingdigital.foodstorm.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.coachingdigital.foodstorm.model.Member;

/**
 * 
 * @author Jean-Philippe
 *
 */
@Repository
public interface MemberRepository extends CrudRepository<Member,Long> {
	Optional<Member> findByLogin(String login);
	Optional<Member> findByMail(String mail);
	

}
