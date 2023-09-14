package com.auth.authapi.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.auth.authapi.models.User;

public interface UserRepository extends JpaRepository<User, UUID> {

	@Query("from User where login =:login and password =:password")
	Optional<User> findByLoginAndPassword(@Param("login") String login, @Param("password") String password);

	@Query("from User where login =:login")
	Optional<User> findByLogin(@Param("login") String login);

}