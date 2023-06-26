package com.auth.authapi.dtos;

import java.util.ArrayList;
import java.util.List;

import com.auth.authapi.models.UserResource;

public class ResourceDTO {
	private String resourceId;
	
	private String name;
	
	private Boolean enable;

	private List<UserResource> users = new ArrayList<>();
	
	public String getResourceId() {
		return resourceId;
	}
	
	public String getName() {
		return name;
	}
	
	public Boolean getEnable() {
		return enable;
	}
	
	public List<UserResource> getUsuarios() {
		return users;
	}
	
	public ResourceDTO() {}
	
	public ResourceDTO(String resourceId, String name, Boolean enable, List<UserResource> users) {
		this.resourceId = resourceId;
		this.name = name;
		this.enable = enable;
		this.users = users;
	}
	
	public ResourceDTO(String name, Boolean enable) {
		this.name = name;
		this.enable = enable;
	}

}
