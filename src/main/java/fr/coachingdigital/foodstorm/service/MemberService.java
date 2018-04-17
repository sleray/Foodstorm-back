package fr.coachingdigital.foodstorm.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.coachingdigital.foodstorm.model.Member;
import fr.coachingdigital.foodstorm.repo.MemberRepository;

/**
 * 
 * @author Jean-Philippe
 *
 */
@Service
public class MemberService {
	/**
	 * Repository for the member table
	 */
	MemberRepository memberRepository;
	
	/**
	 * Default
	 * @param memberRepository the reposistory to set
	 */
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	/**
	 * Method for getting a member by id
	 * @param id the id of the member to get
	 * @return An optional refered to member
	 */
	public Optional<Member> getMemberById(long id){
		return memberRepository.findById(id);
	}
	
	/**
	 * Method for getting a member by login
	 * @param login the login of the member to get
	 * @return An optional refered to member
	 */
	public Optional<Member> getMemberByLogin(String login){
		return memberRepository.findByLogin(login);
	}
	
	/**
	 * Method for getting member by mail
	 * @param mail the mail of the member to get
	 * @return An optional refered to member
	 */
	public Optional<Member> getMemberByMail(String mail){
		return memberRepository.findByMail(mail);
	}
	
	/**
	 * Method for updating a member
	 * @param member the member to update
	 * @return the member updated
	 */
	public Member updateMember(Member member) {
		return memberRepository.save(member);
	}
	
	/**
	 * Method for adding a member
	 * @param member the member to add
	 * @return the member added
	 */
	public Member addMember(Member member) {
		return memberRepository.save(member);
	}
	
	/**
	 * Meyhod for deleting a member by id
	 * @param id the id of the member to delete
	 */
	public void deleteMemberById(long id) {
		memberRepository.deleteById(id);
	}
	
	/**
	 * Method for deleting a member by member
	 * @param member the member to delete
	 */
	public void deleteMemberByMember(Member member) {
		memberRepository.delete(member);
	}
}
