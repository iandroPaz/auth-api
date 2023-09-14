package com.auth.authapi.mechanisms;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.authapi.ApplicationConfig;

@Service
public class CryptPassword {

	@Autowired
	private ApplicationConfig config;

	public String encode(String password) throws Exception {

		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), password.getBytes(), config.getIterations(), config.getKeyLength());

		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

		return bytesToHex(factory.generateSecret(spec).getEncoded());

	}

    private static String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte b : bytes) result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }
}