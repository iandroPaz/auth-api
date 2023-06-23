package com.auth.authapi.dtos;

import java.util.Date;

public class UserResourceDTO {
	private String userResourceId;

	private String userId;
	
	private String resourceId;

	private String intervalUnit;

	private Integer rateLimit;
	
	private Date createdAt;
	
	private Date updatedAt;
	
	public String getUserResourceId() {
		return userResourceId;
	}
	
	public String getUser() {
		return userId;
	}
	
	public String getResource() {
		return resourceId;
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
	
	public UserResourceDTO() {	}
	
	public UserResourceDTO(String userId, String resourceId, String intervalUnit, Integer rateLimit) {
		this.userId = userId;
		this.resourceId = resourceId;
		this.intervalUnit = intervalUnit;
		this.rateLimit = rateLimit;
	}
}
