package com.auth.authapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.authapi.dtos.UserDTO;
import com.auth.authapi.services.UserService;

@RestController
@RequestMapping("/auth/user")
public class UserController {
	@Autowired
	UserService userService;
	
	
	@ResponseBody
	@PostMapping(produces="application/json")
	public ResponseEntity<Object> create(@RequestBody UserDTO user ) {
		try {
			return ResponseEntity.ok(userService.create(user));
		} catch (Error err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err.getMessage());
		}
	}
		
	@ResponseBody
	@GetMapping(value="/{user-id}", produces="application/json")
	public ResponseEntity<Object> read(@PathVariable("user-id") String userId) {
		try {
			return ResponseEntity.ok(userService.read(userId));
		} catch (Error err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err.getMessage());
		}
	}
	
}
