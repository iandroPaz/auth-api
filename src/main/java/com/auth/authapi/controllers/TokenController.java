package com.auth.authapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.authapi.dtos.TokenDTO;
import com.auth.authapi.services.TokenService;

@RestController
@RequestMapping("/auth/token")
public class TokenController {
	@Autowired
	TokenService tokenService;

	@ResponseBody
	@GetMapping(produces="application/json")
	public ResponseEntity<Object> read(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) throws Exception {
		String token = "" ;
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7); // Remove "Bearer "
        }
		return tokenService.verifyToken(token)
				? ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null)
				: ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<Object> create(@RequestBody TokenDTO tokenDto) throws Exception {
		return ResponseEntity.status(HttpStatus.CREATED).body(tokenService.create(tokenDto));
	}


}
