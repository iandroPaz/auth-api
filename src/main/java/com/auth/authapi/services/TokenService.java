package com.auth.authapi.services;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.authapi.ApplicationConfig;
import com.auth.authapi.dtos.TokenDTO;
import com.auth.authapi.dtos.TokenReturnDTO;
import com.auth.authapi.models.Resource;
import com.auth.authapi.models.User;
import com.auth.authapi.models.UserResource;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

@Service
public class TokenService {
	@Autowired
	UserService userService;
	@Autowired
	ResourceService resourceService;
	@Autowired
	UserResourceService userResourceService;
	@Autowired
	private ApplicationConfig config;

	public TokenReturnDTO create(TokenDTO tokenDto) throws Exception {
		User user = userService.readByLoginAndPassoword(tokenDto.getLogin(), tokenDto.getPassword());
		Resource resource = resourceService.readEntity(UUID.fromString(tokenDto.getResourceId()));
		UserResource userResource = userResourceService.readByUserAndResource(user, resource);
		if (userResource != null) {
			String token = JWT
					.create()
					//.withClaim("resources", user.getResources())
					.withSubject(user.getUserId().toString())
					.withExpiresAt(Date.from(ZonedDateTime.now().plusSeconds(config.getExpiration()).toInstant()))
					.sign(Algorithm.HMAC256(config.getKey().getBytes()));
			return new TokenReturnDTO(token);
		}
		throw new Exception("Invalid informations");
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
