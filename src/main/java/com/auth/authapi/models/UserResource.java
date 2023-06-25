package com.auth.authapi.models;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="USER_RESOURCES")
public class UserResource {
	@Id
	private UUID userResourceId = UUID.randomUUID();

	@ManyToOne
	@JsonBackReference(value="user")
	@JoinColumn(name="userId", nullable=false)
	private User user;
	
	@ManyToOne
	@JsonBackReference(value="resource")
	@JoinColumn(name="resourceId", nullable=false)
	private Resource resource;

	private String intervalUnit;

	private Integer rateLimit;
	
	@CreatedDate
	private Date createdAt;
	
	@LastModifiedDate
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
