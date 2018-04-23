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
	 * Method that generate RSAPublicKey from filr
	 * @param publicKey the filr representing public key
	 * @return the rsa public key
	 */
	public static RSAPublicKey generatePublicKey(File publicKey) {
		RSAPublicKey pubKey = null;
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream(publicKey));
			byte[] pubKeyBytes = new byte[(int) publicKey.length()];
			dis.readFully(pubKeyBytes);
			dis.close();
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			X509EncodedKeySpec pubSpec = new X509EncodedKeySpec(pubKeyBytes);
			pubKey = (RSAPublicKey) keyFactory.generatePublic(pubSpec);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return pubKey;
	}

	/**
	 * Method that generate RSAPrivateKey from file
	 * @param privateKey the file representing private key
	 * @return the rsa private key
	 */
	public static RSAPrivateKey generatePrivateKey(File privateKey) {
		RSAPrivateKey privKey = null;
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream(privateKey));
			byte[] privKeyBytes = new byte[(int) privateKey.length()];
			dis.read(privKeyBytes);
			dis.close();
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PKCS8EncodedKeySpec privSpec = new PKCS8EncodedKeySpec(privKeyBytes);
			privKey = (RSAPrivateKey) keyFactory.generatePrivate(privSpec);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return privKey;
	}

}
