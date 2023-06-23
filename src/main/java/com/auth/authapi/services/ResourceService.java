package com.auth.authapi.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.authapi.dtos.ResourceDTO;
import com.auth.authapi.mappers.ResourceMapper;
import com.auth.authapi.models.Resource;
import com.auth.authapi.repositories.ResourceRepository;

@Service
public class ResourceService {
	@Autowired
	ResourceRepository resourceRepository;
	
	public ResourceDTO create(ResourceDTO resourceDto) {
		Resource resource = new Resource(resourceDto.getName(), resourceDto.getEnable());
		return ResourceMapper.map(resourceRepository.save(resource));
	}
	
	public Resource readEntity(UUID resourceId) {
		return resourceRepository.findById(resourceId).orElse(null);
	}



}
