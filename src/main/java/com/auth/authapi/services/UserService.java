package com.auth.authapi.services;

import com.auth.authapi.models.User;
import com.auth.authapi.repositories.UserRepository;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.authapi.dtos.UserDTO;
import com.auth.authapi.mappers.UserMapper;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public UserDTO create(UserDTO userDto) {
		User user = new User(userDto.getLogin(), userDto.getPassword(), userDto.getStatus());
		return UserMapper.map(userRepository.save(user));
	}
	
	public UserDTO read(String userId) {
		return UserMapper.map(userRepository.findById(UUID.fromString(userId)).orElse(null));
	}
	
	
	  public UserDTO update(UserDTO userDto) {
		  User user = new User(
				  UUID.fromString(userDto.getUserId()), 
				  userDto.getLogin(),
				  userDto.getPassword(),
				  userDto.getStatus()
				  );
		  return UserMapper.map(userRepository.save(user)); 
	  }
	 
	
	public void delete(String userId) {
		userRepository.deleteById(UUID.fromString(userId));
	}
	
	public User readEntity(UUID userId) {
		return userRepository.findById(userId).orElse(null);
	}

}
