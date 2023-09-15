package com.auth.authapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@GetMapping(value="/{token}", produces="application/json")
	public ResponseEntity<Object> read(@PathVariable("token") String token) throws Exception {
		return tokenService.verifyToken(token)
				? ResponseEntity.status(HttpStatus.OK).body(null)
				: ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<Object> create(@RequestBody TokenDTO tokenDto) throws Exception {
		return ResponseEntity.status(HttpStatus.CREATED).body(tokenService.create(tokenDto));
	}


}
