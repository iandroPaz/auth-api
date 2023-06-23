package com.auth.authapi.models;

import java.sql.Date;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="RESOURCES")
public class Resource {
	@Id
	private UUID resourceId  = UUID.randomUUID();
	
	private String name;
	
	private Boolean enable;

	@OneToMany(mappedBy="resource", fetch= FetchType.LAZY)
	private final List<UserResource> usuarios = new ArrayList<>();
	
	@CreatedDate
	private Date createdAt;
	
	@LastModifiedDate
	private Date updatedAt;
	
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
