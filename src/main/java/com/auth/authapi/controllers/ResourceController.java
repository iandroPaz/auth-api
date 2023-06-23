package com.auth.authapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.authapi.dtos.ResourceDTO;
import com.auth.authapi.dtos.UserDTO;
import com.auth.authapi.services.ResourceService;

@RestController
@RequestMapping("/auth/resource")
public class ResourceController {
	@Autowired
	ResourceService resourceService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<String> read() {
		return ResponseEntity.ok("TOP");
	}
	
	//@Autowired
	//private TravelService travelService;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<ResourceDTO> create(@RequestBody ResourceDTO resourceDto) {
		return ResponseEntity.ok(resourceService.create(resourceDto));
	}
	

}
