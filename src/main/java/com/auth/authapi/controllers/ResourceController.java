package com.auth.authapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.authapi.dtos.ResourceDTO;
import com.auth.authapi.services.ResourceService;

@RestController
@RequestMapping("/auth/resource")
public class ResourceController {
	@Autowired
	ResourceService resourceService;
	
	
	@ResponseBody
	@PostMapping(produces = "application/json")
	public ResponseEntity<Object> create(@RequestBody ResourceDTO resourceDto) {
		try {
			return ResponseEntity.ok(resourceService.create(resourceDto));
		} catch (Error err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err.getMessage());
		}
	}

	@GetMapping
	@ResponseBody
	public ResponseEntity<String> read() {
		return ResponseEntity.ok("TOP");
	}
		

}
