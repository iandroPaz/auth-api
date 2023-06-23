package com.auth.authapi.mappers;

import com.auth.authapi.dtos.ResourceDTO;
import com.auth.authapi.models.Resource;

public class ResourceMapper {
	public static ResourceDTO map(Resource resource) {
		return new ResourceDTO(resource.getResourceId().toString() ,resource.getName(), resource.getEnable(), resource.getUsers());
	}
}
