package com.auth.authapi.services;

import org.springframework.stereotype.Service;

import com.auth.authapi.dtos.ResourceDTO;
import com.auth.authapi.mappers.ResourceMapper;
import com.auth.authapi.models.Resource;

@Service
public class ResourceService {
	public ResourceDTO create (ResourceDTO resourceDto) {
		Resource resource = new Resource(resourceDto.getName(), resourceDto.getEnable());
		return ResourceMapper.map(resource);
	}



}
