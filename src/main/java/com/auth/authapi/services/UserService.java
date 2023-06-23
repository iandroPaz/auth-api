package com.auth.authapi.services;

import com.auth.authapi.models.User;
import com.auth.authapi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.authapi.dtos.UserDTO;
import com.auth.authapi.mappers.UserMapper;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public UserDTO create (UserDTO userDto) {
		User user = new User(userDto.getLogin(), userDto.getPassword(), userDto.getStatus());
		return UserMapper.map(userRepository.save(user));
	}

}
