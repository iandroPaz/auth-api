package com.auth.authapi.services;

import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.authapi.models.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Service
public class TokenService {
	@Autowired
	UserService userService;
	
	public String create(String login, String password, String resourceId) {
		User user = userService.readByLoginAndPassoword(login, password);
		String token = JWT
				.create()
				.withClaim("userId", user.getUserId().toString())
				.withSubject(user.getUserId().toString())
				.withExpiresAt(Date.from(ZonedDateTime.now().plusSeconds(900).toInstant()))
				.sign(Algorithm.HMAC512("hash1234crypto".getBytes()));
		return token;
	}

}
