package com.auth.authapi.models;

import java.sql.Date;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class Resource {

	private UUID resourceId  = UUID.randomUUID();
	
	private Date createdAt;
	
	private Date updatedAt;
	
	private String name;
	
	private Boolean enable;

	private final List<UserResource> usuarios = new ArrayList<>();
	
	public UUID getResourceId() {
		return resourceId;
	}
	
	public String getName() {
		return name;
	}
	
	public Boolean getEnable() {
		return enable;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public List<UserResource> getUsers() {
		return usuarios;
	}
	
	public Resource() {}
	
	public Resource(String name, Boolean enable) {
		this.name = name;
		this.enable = enable;
	}

}
