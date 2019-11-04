package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utility {
	
	private final static String SALT = "WHUFjju77(#$kk$%#";


	public static String hashPassword(String in) throws NoSuchAlgorithmException {
		StringBuilder hash = new StringBuilder();
		MessageDigest sha = MessageDigest.getInstance("SHA-1");
		String input = in + SALT;
		byte[] hashedBytes = sha.digest(input.getBytes());
		char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		for (int idx = 0; idx < hashedBytes.length; idx++) {
			byte b = hashedBytes[idx];
			hash.append(digits[(b & 0xf0) >> 4]);
			hash.append(digits[b & 0x0f]);
		}
		return hash.toString();
	}

	
}
