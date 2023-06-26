package com.auth.authapi.services;

import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.authapi.dtos.UserDTO;
import com.auth.authapi.dtos.UserResourceDTO;
import com.auth.authapi.mappers.UserMapper;
import com.auth.authapi.mappers.UserResourceMapper;
import com.auth.authapi.models.Resource;
import com.auth.authapi.models.User;
import com.auth.authapi.models.UserResource;
import com.auth.authapi.repositories.UserResourceRepository;

@Service
public class UserResourceService {
	@Autowired
	UserService userService;
	@Autowired
	ResourceService resourceService;
	@Autowired
	UserResourceRepository userResourceRepository;
	
	public UserResourceDTO create(UserResourceDTO userResourceDto) {
		User user = userService.readEntity(UUID.fromString(userResourceDto.getUserId()));
		Resource resource = resourceService.readEntity(UUID.fromString(userResourceDto.getResourceId()));
		UserResource userResource = new UserResource(user, resource, userResourceDto.getIntervalUnit(), userResourceDto.getRateLimit());
		return UserResourceMapper.map(userResourceRepository.save(userResource));
	}
	
	public UserResourceDTO read(String userResourceId) {
		return UserResourceMapper.map(userResourceRepository.findById(UUID.fromString(userResourceId)).orElse(null));
	}
	
	public UserResourceDTO update(UserResourceDTO userResourceDto) {
		UserResource userResourceOld = this.readEntity(UUID.fromString(userResourceDto.getUserResourceId()));
		UserResource userResource = new UserResource(
			  userResourceOld.getUserResourceId(),
			  userResourceOld.getUser(),
			  userResourceOld.getResource(),
			  userResourceDto.getIntervalUnit(),
			  userResourceDto.getRateLimit()
			  );
		return UserResourceMapper.map(userResourceRepository.save(userResource)); 
  	}

	public void delete(String userId) {
		userResourceRepository.deleteById(UUID.fromString(userId));
	}
	
	public UserResource readEntity(UUID userResourceId) {
		return userResourceRepository.findById(userResourceId).orElse(null);
	}

}
