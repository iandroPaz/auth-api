package com.auth.authapi.models;

import java.util.Date;
import java.util.UUID;

public class UserResource {
	private UUID userResourceId = UUID.randomUUID();

	private User user;
	
	private Resource resource;

	private String intervalUnit;

	private Integer rateLimit;
	
	private Date createdAt;
	
	private Date updatedAt;
	
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
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public UserResource() {	}
	
	public UserResource(User user, Resource resource, String intervalUnit, Integer rateLimit) {
		this.user = user;
		this.resource = resource;
		this.intervalUnit = intervalUnit;
		this.rateLimit = rateLimit;
	}
	
}
