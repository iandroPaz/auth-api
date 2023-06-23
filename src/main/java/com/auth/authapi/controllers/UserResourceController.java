package com.auth.authapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.authapi.dtos.UserResourceDTO;
import com.auth.authapi.services.UserResourceService;

@RestController
@RequestMapping("/auth/user-resource")
public class UserResourceController {
	@Autowired
	UserResourceService userResourceService;
	
	@ResponseBody
	@PostMapping(produces = "application/json")
	public ResponseEntity<Object> create(@RequestBody UserResourceDTO userResourceDTO) {
		try {
			return ResponseEntity.ok(userResourceService.create(userResourceDTO));
		} catch (Error err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err.getMessage());
		}
	}

}
