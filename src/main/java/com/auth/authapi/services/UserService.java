package com.auth.authapi.services;

import com.auth.authapi.models.User;

import org.springframework.stereotype.Service;

import com.auth.authapi.UserMapper;
import com.auth.authapi.dtos.UserDTO;

@Service
public class UserService {
	
	public UserDTO create (UserDTO userDto) {
		User user = new User(userDto.getLogin(), userDto.getPassword(), userDto.getStatus());
		return UserMapper.map(user);
	}

}
