package com.auth.authapi.dtos;

import java.util.ArrayList;
import java.util.List;

import com.auth.authapi.models.UserResource;

public class UserDTO {
	private String userId;
	
	private String login;

	private String password;
	
	private Boolean status;
    
	private List<UserResource> resources = new ArrayList<>();
	
	public String getUserId() {
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
	
	public List<UserResource> getResources() {
		return resources;
	}
	
	public UserDTO() { }
	
	public UserDTO(String userId, String login, Boolean status, List<UserResource> resources) {
		this.userId = userId;
		this.login = login;
		this.status = status;
		this.resources = resources;
	}
	
	public UserDTO(String login, String password, Boolean status) {
		this.login = login;
		this.password = password;
		this.status = status;	
	}
}

