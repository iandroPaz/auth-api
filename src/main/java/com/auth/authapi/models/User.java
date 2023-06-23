package com.auth.authapi.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	@Id
	private UUID userId = UUID.randomUUID();
	
	private String login;

	private String password;
	
	private Boolean status;
	
	@CreatedDate
	private Date createdAt;
	
	@LastModifiedDate
	private Date updatedAt;

	@OneToMany(mappedBy="user", fetch= FetchType.LAZY)
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