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

	MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	public Optional<Member> getMemberById(long id){
		return memberRepository.findById(id);
	}
	
	public Optional<Member> getMemberByLogin(String login){
		return memberRepository.findByLogin(login);
	}
	public Optional<Member> getMemberByMail(String mail){
		return memberRepository.findByMail(mail);
	}
}
