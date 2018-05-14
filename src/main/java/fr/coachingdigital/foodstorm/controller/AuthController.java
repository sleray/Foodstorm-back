package fr.coachingdigital.foodstorm.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.coachingdigital.foodstorm.bean.SignInBean;
import fr.coachingdigital.foodstorm.model.Member;
import fr.coachingdigital.foodstorm.service.AuthService;
import fr.coachingdigital.foodstorm.service.MemberService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final AuthService authService;
	private final MemberService memberService;

	public AuthController(final AuthService authService, final MemberService memberService) {
		this.authService = authService;
		this.memberService = memberService;
	}

	@RequestMapping(value = "/sign-in", method= RequestMethod.POST)
	public ResponseEntity<Member> login(@RequestBody final SignInBean signInBean) {
		final String login = signInBean.getLogin();
		final String password = signInBean.getPassword();
		String token = null;
		HttpStatus statutRetour = HttpStatus.OK;
		Member member = null;
		final Optional<Member> oMember = memberService.getMemberByLogin(login);
		if(oMember.isPresent()) {
			member = oMember.get();
			if(member.getPasswd().equals(password)) {
				token = authService.generateToken();
				member.setToken(token);
			}else {
				member = null;
				statutRetour = HttpStatus.NOT_FOUND;
			}
		}else {
			statutRetour = HttpStatus.NOT_FOUND;
		}

		return new ResponseEntity<Member>(member, statutRetour);
	}

}
