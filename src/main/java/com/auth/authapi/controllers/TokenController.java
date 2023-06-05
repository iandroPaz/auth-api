package com.auth.authapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/token")
public class TokenController {

	@GetMapping
	@ResponseBody
	public ResponseEntity<String> read() {
		return ResponseEntity.ok("Token");
	}
	
	//@Autowired
	//private TravelService travelService;
	
	//@PostMapping
	//@ResponseBody
	//public ResponseEntity<Object> create(@RequestBody TokenDTO token) {}
	

}
