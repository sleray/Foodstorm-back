package fr.coachingdigital.foodstorm.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<String> login(@RequestBody final String login, @RequestBody final String password) {
		String token = null;
		HttpStatus statutRetour = HttpStatus.OK;
		final Optional<Member> oMember = memberService.getMemberByLogin(login);
		if(oMember.isPresent()) {
			final Member member = oMember.get();
			if(member.getPasswd().equals(password)) {
				token = authService.generateToken();
			}else {
				statutRetour = HttpStatus.FORBIDDEN;
			}
		}else {
			statutRetour = HttpStatus.NOT_FOUND;
		}

		return new ResponseEntity<String>(token, statutRetour);
	}

}
