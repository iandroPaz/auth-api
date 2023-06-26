package com.auth.authapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.authapi.dtos.UserDTO;
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
			return ResponseEntity.status(HttpStatus.CREATED).body(userResourceService.create(userResourceDTO));
		} catch (Error err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err.getMessage());
		}
	}
	
	@ResponseBody
	@GetMapping(value="/{user-resource-id}", produces="application/json")
	public ResponseEntity<Object> read(@PathVariable("user-resource-id") String userResourceId) {
		try {
			return ResponseEntity.ok(userResourceService.read(userResourceId));
		} catch (Error err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err.getMessage());
		}
	}
	
	@ResponseBody
	@PatchMapping(produces="application/json") 
	public ResponseEntity<Object> update(@RequestBody UserResourceDTO userResourceDTO ) { 
	  try { 
		  return ResponseEntity.ok(userResourceService.update(userResourceDTO)); 
	  } catch (Error err) { 
		  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err.getMessage());
	  } 
	}
	 	
	@ResponseBody
	@DeleteMapping(value="/{user-resource-id}", produces="application/json")
	public ResponseEntity<Object> delete(@PathVariable("user-id") String userResourceId) {
		try {
			userResourceService.delete(userResourceId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		} catch (Error err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err.getMessage());
		}
	}

}
