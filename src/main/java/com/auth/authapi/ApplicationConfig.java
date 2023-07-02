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
	
	public String getKey() {
		return key;
	}
	
	public int getExpiration() {
		return expiration;
	}
}
