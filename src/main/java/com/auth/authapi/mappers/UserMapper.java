package com.auth.authapi.mappers;

import com.auth.authapi.dtos.UserDTO;
import com.auth.authapi.models.User;

public class UserMapper {
	public static UserDTO mapEntityToDto(User user) {
		return new UserDTO(user.getUserId().toString(), user.getLogin(), user.getStatus(), user.getResources());
	}

	public static User mapDtoToEntity(UserDTO user) {
		return new User(user.getUserId().toString(), user.getLogin(), user.getStatus());
	}
	
}
