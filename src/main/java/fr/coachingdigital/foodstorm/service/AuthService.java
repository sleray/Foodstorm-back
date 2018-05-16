package fr.coachingdigital.foodstorm.service;

import java.io.File;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;

import fr.coachingdigital.foodstorm.tool.AuthTool;

/**
 *
 * @author jetrilla
 *
 */
@Service
public class AuthService {

	public static final String ISSUER = "foodstorm";
	/**
	 * Key private for encryption
	 */
	private final RSAPrivateKey privateKey;

	/**
	 * Key public for decryption
	 */
	private final RSAPublicKey publicKey;

	public AuthService() {
		final ClassLoader classLoader = getClass().getClassLoader();
		privateKey = AuthTool.generatePrivateKey(new File(classLoader.getResource("rsapriv.der").getFile()));
		publicKey = AuthTool.generatePublicKey(new File(classLoader.getResource("rsapub.der").getFile()));
	}

	/**
	 * Method to generate a token with default values
	 * @return the token encoded
	 */
	public String generateToken() {
		return generateToken(Instant.now(), Duration.ofMinutes(30));
	}

	/**
	 * Method to generate a token with specify values.
	 * @param issuerInstant
	 * @param expireAfter
	 * @return
	 */
	public String generateToken(final Instant issuerInstant, final Duration expireAfter) {
		String token = null;
		final Date issuerDate = Date.from(issuerInstant);
		final Date expiresAt = Date.from(issuerInstant.plus(expireAfter.toMinutes(), ChronoUnit.MINUTES));
		final Algorithm algorithm = Algorithm.RSA256(publicKey, privateKey);
		token = JWT.create().withIssuer(ISSUER)
				.withIssuedAt(issuerDate)
				.withExpiresAt(expiresAt).sign(algorithm);

		return token;
	}

	/**
	 * Method tu verify that a token is still valid
	 * @param token the token to verify
	 */
	public boolean verifyToken(final String token) {
		boolean retour = true;
		final Algorithm algorithm = Algorithm.RSA256(publicKey, privateKey);
		final JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUER).acceptLeeway(1).build(); // Reusable verifier instance
		try {
			verifier.verify(token);
		}catch(TokenExpiredException | JWTDecodeException exceptions) {
			retour = false;
		}


		return retour;
	}

}
