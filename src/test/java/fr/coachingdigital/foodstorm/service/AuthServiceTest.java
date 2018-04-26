package fr.coachingdigital.foodstorm.service;

import java.time.Duration;
import java.time.Instant;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import fr.coachingdigital.foodstorm.FoodstormApplication;
/**
 * Test action around AuthService
 * @author jetrilla
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
  webEnvironment = WebEnvironment.RANDOM_PORT,
  classes = FoodstormApplication.class)
public class AuthServiceTest {

	
	@Autowired
	AuthService authService;
	
	@Test
	public void verifyTokenOK() {
		String token = authService.generateToken();
		boolean retour = authService.verifyToken(token);
		
		Assert.assertTrue(retour);
	}
	
	@Test
	public void verifyTokenExpire() {
		Instant instant = Instant.parse("2018-04-22T00:00:00Z");
		String token = authService.generateToken(instant,Duration.ofMinutes(30));
		boolean retour = authService.verifyToken(token);
		
		Assert.assertFalse(retour);
	}
	@Test
	public void verifyBadToken() {
		String token = "ceciestuntest";
		boolean retour = authService.verifyToken(token);
		
		Assert.assertFalse(retour);
	}
}
