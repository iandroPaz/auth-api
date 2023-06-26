package com.auth.authapi.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.UUID;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="RESOURCES")
@EntityListeners(AuditingEntityListener.class)
public class Resource {
	@Id
	@Column(name="resource_id")
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
	
	public Resource(UUID resourceId, String name, Boolean enable) {
		this.resourceId = resourceId;
		this.name = name;
		this.enable = enable;
	}
	
	public Resource(String name, Boolean enable) {
		this.name = name;
		this.enable = enable;
	}

}
