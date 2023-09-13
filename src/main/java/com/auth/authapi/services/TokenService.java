package com.auth.authapi.services;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.authapi.ApplicationConfig;
import com.auth.authapi.dtos.TokenReturnDTO;
import com.auth.authapi.models.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

@Service
public class TokenService {
	@Autowired
	UserService userService;
	@Autowired
	private ApplicationConfig config;
	
	public TokenReturnDTO create(String login, String password) throws Exception { // List<String> resources) {
		User user = userService.readByLoginAndPassoword(login, password);
		String token = JWT
				.create()
				//.withClaim("resources", user.getResources())
				.withSubject(user.getUserId().toString())
				.withExpiresAt(Date.from(ZonedDateTime.now().plusSeconds(config.getExpiration()).toInstant()))
				.sign(Algorithm.HMAC256(config.getKey().getBytes()));
		return new TokenReturnDTO(token);
	}
	
	public boolean verifyToken(String token) throws Exception {
		boolean valid = true;
		try {
			Algorithm algorithm = Algorithm.HMAC256(config.getKey().getBytes());
			
			JWTVerifier verifier = JWT.require(algorithm).build();
			
			DecodedJWT decode = verifier.verify(token);
			
			//Map<String, Claim> claims = decode.getClaims();
			
			valid = decode != null ? true : false;
		} catch (Error err) {
			throw new Exception("Invalid Token");
		}
		
		return valid;
	}
	

}
