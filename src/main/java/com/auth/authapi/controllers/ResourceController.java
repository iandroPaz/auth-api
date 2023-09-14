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
			return ResponseEntity.status(HttpStatus.CREATED).body(resourceService.create(resourceDto));
		} catch (Error err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err.getMessage());
		}
	}

	@ResponseBody
	@GetMapping(value="/{resource-id}", produces="application/json")
	public ResponseEntity<Object> read(@PathVariable("resource-id") String resourceId) {
		try {
			return ResponseEntity.ok(resourceService.read(resourceId));
		} catch (Error err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err.getMessage());
		}
	}

	@ResponseBody
	@PatchMapping(produces="application/json")
	public ResponseEntity<Object> update(@RequestBody ResourceDTO resourceDto) {
	  try {
		  return ResponseEntity.ok(resourceService.update(resourceDto));
	  } catch (Error err) {
		  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err.getMessage());
	  }
	}

	@ResponseBody
	@DeleteMapping(value="/{resource-id}", produces="application/json")
	public ResponseEntity<Object> delete(@PathVariable("resource-id") String resourceId) {
		try {
			resourceService.delete(resourceId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		} catch (Error err) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err.getMessage());
		}
	}

}
