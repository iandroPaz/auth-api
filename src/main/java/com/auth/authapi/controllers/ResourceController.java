package com.auth.authapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.authapi.dtos.UserDTO;

@RestController
@RequestMapping("/auth/resource")
public class ResourceController {

	@GetMapping
	@ResponseBody
	public ResponseEntity<String> read() {
		return ResponseEntity.ok("TOP");
	}
	
	//@Autowired
	//private TravelService travelService;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<String> create(@RequestBody UserDTO user) {
		return ResponseEntity.ok("TOP");
	}
	

}
