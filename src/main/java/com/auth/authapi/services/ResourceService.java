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
		Resource oldResource = this.readByName(resourceDto.getName());
		if (oldResource == null) {
			Resource resource = new Resource(resourceDto.getName(), resourceDto.getEnable());
			return ResourceMapper.map(resourceRepository.save(resource));
		}
		return null;
	}

	public ResourceDTO read(String resourceId) {
		return ResourceMapper.map(resourceRepository.findById(UUID.fromString(resourceId)).orElse(null));
	}

	public ResourceDTO update(ResourceDTO resourceDto) {
		Resource resource = new Resource(
				  UUID.fromString(resourceDto.getResourceId()),
				  resourceDto.getName(),
				  resourceDto.getEnable()
				  );
		  return ResourceMapper.map(resourceRepository.save(resource));
	}

	public void delete(String resourceId) {
		resourceRepository.deleteById(UUID.fromString(resourceId));
	}

	public Resource readEntity(UUID resourceId) {
		return resourceRepository.findById(resourceId).orElse(null);
	}

	public Resource readByName(String name) {
		return resourceRepository.findByName(name).orElse(null);
	}



}
