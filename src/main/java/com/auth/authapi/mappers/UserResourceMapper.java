package com.auth.authapi.mappers;

import com.auth.authapi.dtos.UserResourceDTO;
import com.auth.authapi.models.UserResource;

public class UserResourceMapper {
	public static UserResourceDTO map(UserResource userResource) {
		return new UserResourceDTO(
				userResource.getUserResourceId().toString(),
				userResource.getUser().getUserId().toString(),
				userResource.getResource().getResourceId().toString(),
				userResource.getIntervalUnit(),
				userResource.getRateLimit()
			);
	}
	
	/*
	 * public static UserResource map(UserResourceDTO userResourceDto) { return new
	 * UserResource( userResourceDto.getUser(), userResourceDto.getResource(),
	 * userResourceDto.getIntervalUnit(), userResourceDto.getRateLimit() ); }
	 */
}
