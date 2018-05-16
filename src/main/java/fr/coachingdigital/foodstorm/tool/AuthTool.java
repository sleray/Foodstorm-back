package fr.coachingdigital.foodstorm.tool;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Tool for authentification
 *
 * @author jetrilla
 *
 */
public class AuthTool {

	/**
	 * Method that generate RSAPrivateKey from file
	 * @param privateKey the file representing private key
	 * @return the rsa private key
	 */
	public static RSAPrivateKey generatePrivateKey(final File privateKey) {
		RSAPrivateKey privKey = null;
		try (DataInputStream dis = new DataInputStream(new FileInputStream(privateKey));) {

			final byte[] privKeyBytes = new byte[(int) privateKey.length()];
			dis.read(privKeyBytes);
			final KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			final PKCS8EncodedKeySpec privSpec = new PKCS8EncodedKeySpec(privKeyBytes);
			privKey = (RSAPrivateKey) keyFactory.generatePrivate(privSpec);
		} catch (final IOException |NoSuchAlgorithmException |InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return privKey;
	}
	/**
	 * Method that generate RSAPublicKey from file
	 * @param publicKey the file representing public key
	 * @return the rsa public key
	 */
	public static RSAPublicKey generatePublicKey(final File publicKey) {
		RSAPublicKey pubKey = null;
		try (DataInputStream dis = new DataInputStream(new FileInputStream(publicKey));) {

			final byte[] pubKeyBytes = new byte[(int) publicKey.length()];
			dis.readFully(pubKeyBytes);
			final KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			final X509EncodedKeySpec pubSpec = new X509EncodedKeySpec(pubKeyBytes);
			pubKey = (RSAPublicKey) keyFactory.generatePublic(pubSpec);

		} catch (final IOException |NoSuchAlgorithmException |InvalidKeySpecException e) {
			e.printStackTrace();

		}
		return pubKey;
	}

	/**
	 * Default for sonar complaience
	 */
	private AuthTool() {

	}

}
