package com.auth.authapi.dtos;

public class UserResourceDTO {
	private String userResourceId;

	private String userId;

	private String resourceId;

	private String intervalUnit;

	private Integer rateLimit;

	public String getUserResourceId() {
		return userResourceId;
	}

	public String getUserId() {
		return userId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public String getIntervalUnit() {
		return intervalUnit;
	}

	public Integer getRateLimit() {
		return rateLimit;
	}

	public UserResourceDTO() {	}

	public UserResourceDTO(String userResourceId, String userId, String resourceId, String intervalUnit, Integer rateLimit) {
		this.userResourceId = userResourceId;
		this.userId = userId;
		this.resourceId = resourceId;
		this.intervalUnit = intervalUnit;
		this.rateLimit = rateLimit;
	}

	public UserResourceDTO(String userId, String resourceId, String intervalUnit, Integer rateLimit) {
		this.userId = userId;
		this.resourceId = resourceId;
		this.intervalUnit = intervalUnit;
		this.rateLimit = rateLimit;
	}
}
