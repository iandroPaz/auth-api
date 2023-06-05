package com.auth.authapi.models;

import java.util.UUID;

public class UserResource {
	private UUID userResourceId = UUID.randomUUID();

	private User user;
	
	private Resource resource;

	private String intervalUnit;

	private Integer rateLimit;
	
	public UUID getUserResourceId() {
		return userResourceId;
	}
	
	public User getUser() {
		return user;
	}
	
	public Resource getResource() {
		return resource;
	}
	
	public String getIntervalUnit() {
		return intervalUnit;
	}
	
	public Integer getRateLimit() {
		return rateLimit;
	}
	
	public UserResource() {	}
	
}
