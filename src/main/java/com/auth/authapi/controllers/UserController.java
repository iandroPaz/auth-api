package com.auth.authapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<UserDTO> create(@RequestBody UserDTO user) {
		return ResponseEntity.ok(userService.create(user));
	}
		
	@GetMapping
	@ResponseBody
	public ResponseEntity<String> read() {
		return ResponseEntity.ok("User");
	}
	
}
