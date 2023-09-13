package com.auth.authapi.mechanisms;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class CryptPassword {
	public static String encode(String password) throws Exception {
		
		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), password.getBytes(), 65536, 128);
		
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

		return bytesToHex(factory.generateSecret(spec).getEncoded());
		
	}
	
    private static String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte b : bytes) result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }
}