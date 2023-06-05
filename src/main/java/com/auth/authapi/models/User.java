package com.auth.authapi.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class User {	
	private UUID userId = UUID.randomUUID();
	
	private String login;

	private String password;
	
	private Boolean status;
	
	private Date createdAt;
	
	private Date updatedAt;

	private final List<UserResource> resources = new ArrayList<>();
    
	public UUID getUserId() {
		return userId;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Boolean getStatus() {
		return status;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public List<UserResource> getResources() {
		return resources;
	}
	
	public User() { }
	
	public User(String login, String password, Boolean status) {
		this.login = login;
		this.password = password;
		this.status = status;
	}
}