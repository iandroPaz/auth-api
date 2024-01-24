package com.auth.authapi.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.authapi.dtos.UserDTO;
import com.auth.authapi.mappers.UserMapper;
import com.auth.authapi.mechanisms.CryptPassword;
import com.auth.authapi.models.User;
import com.auth.authapi.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	CryptPassword cipher;

	public UserDTO create(UserDTO userDto) throws Exception {
		User oldUser = this.readByLogin(userDto.getLogin());
		if (oldUser == null) {
			User user = new User(userDto.getLogin(), cipher.encode(userDto.getPassword()), userDto.getStatus());
			return UserMapper.mapEntityToDto(userRepository.save(user));
		}
		return null;
	}

	public UserDTO read(String userId) {
		return UserMapper.mapEntityToDto(userRepository.findById(UUID.fromString(userId)).orElse(null));
	}

	  public UserDTO update(UserDTO userDto) throws Exception {
		  UUID userUuid = UUID.fromString(userDto.getUserId());
		  User oldUser = this.readEntity(userUuid);
		  //Preciso fazer mais ajustes aqui
		  if (oldUser != null) {
			  User user = new User(
					  userUuid,
					  userDto.getLogin(),
					  cipher.encode(userDto.getPassword()),
					  userDto.getStatus(),
					  oldUser.getCreatedAt()
					  );
			  return UserMapper.mapEntityToDto(userRepository.save(user));
		  }
		  return null;
	  }

	public void delete(String userId) {
		userRepository.deleteById(UUID.fromString(userId));
	}

	public void updatePassword(String userId, String password) throws Exception {
	  UUID userUuid = UUID.fromString(userId);
	  User oldUser = this.readEntity(userUuid);
	  if (oldUser != null) {
		  User user = new User(
				  userUuid,
				  oldUser.getLogin(),
				  cipher.encode(oldUser.getPassword()),
				  oldUser.getStatus(),
				  oldUser.getCreatedAt()
				  );
		  userRepository.save(user);  
	  }
	  
	}
	
	public User readEntity(UUID userId) {
		return userRepository.findById(userId).orElse(null);
	}

	public User readByLoginAndPassoword(String login, String password) throws Exception {
		return userRepository.findByLoginAndPassword(login, cipher.encode(password)).orElse(null);
	}

	public User readByLogin(String login) {
		return userRepository.findByLogin(login).orElse(null);
	}

}
