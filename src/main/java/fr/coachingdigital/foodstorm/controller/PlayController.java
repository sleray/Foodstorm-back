package fr.coachingdigital.foodstorm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller allow us to play with some useless methods
 * Only for the pleasure of science :)
 * @author sleray
 *
 */
@RestController
@RequestMapping("/play")

public class PlayController {

	
	public PlayController() {
		
	}


	/**
	 * What about playing with lambdas expressions ?
	 * @return OK
	 */
	@RequestMapping(value = "/lambda", method= RequestMethod.GET)
	public ResponseEntity<String> playWithLambda() {
		return new ResponseEntity<String>("Cheers !",HttpStatus.CHECKPOINT);

		

	}

}
