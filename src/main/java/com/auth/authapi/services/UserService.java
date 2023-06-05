package com.auth.authapi.services;

import com.auth.authapi.models.User;

import org.springframework.stereotype.Service;

import com.auth.authapi.dtos.UserDTO;
import com.auth.authapi.mappers.UserMapper;

@Service
public class UserService {
	public UserDTO create (UserDTO userDto) {
		User user = new User(userDto.getLogin(), userDto.getPassword(), userDto.getStatus());
		return UserMapper.map(user);
	}

}
