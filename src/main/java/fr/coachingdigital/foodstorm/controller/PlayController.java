package fr.coachingdigital.foodstorm.controller;

import java.util.Arrays;
import java.util.List;

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
		List<String> fruits = Arrays.asList("melon", "abricot", "fraise", "cerise");
		
		//Expression lambda 
		//(fmt, arg) -> String.format(fmt, arg) appelle la méthode format de String
	    String result = afficher(fruits, (fmt, arg) -> String.format(fmt, arg));
	    
	    
	    //Référence de méthode statique. Résultat identique mais plus joli !
	    String result2 = afficher(fruits, String::format);
	    
	    return new ResponseEntity<String>(result,HttpStatus.OK);
	  }

	  private static String afficher(List<String> liste, MonFormateur formateur) {
	    int i = 0;
	    StringBuilder sb = new StringBuilder();
	    for (String element : liste) {
	      i++;
	      sb.append(formateur.formater("%3d %s%n", i, element));
	    }
	    return sb.toString();
	  }
	  
	  /**
		 * What about playing with streams ?
		 * @return OK
		 */
		@RequestMapping(value = "/stream", method= RequestMethod.GET)
		public ResponseEntity<String> playWithStream() {
			//FIXME
			return new ResponseEntity<String>("Check back later",HttpStatus.OK);
		}
	}

	@FunctionalInterface
	interface MonFormateur {
	  String formater(String format, Object... arguments);
	}
