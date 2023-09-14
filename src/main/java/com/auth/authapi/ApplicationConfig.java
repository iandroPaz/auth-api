package com.auth.authapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("auth")
@Configuration
public class ApplicationConfig {
	@Value("${auth.token.key}")
	private String key;
	@Value("${auth.token.expiration.time}")
	private int expiration;
	@Value("${auth.cipher.iterations}")
	private int iterations;
	@Value("${auth.cipher.key.length}")
	private int keyLength;

	public String getKey() {
		return key;
	}

	public int getExpiration() {
		return expiration;
	}

	public int getIterations() {
		return iterations;
	}

	public int getKeyLength() {
		return keyLength;
	}
}
