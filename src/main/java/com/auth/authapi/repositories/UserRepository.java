package com.auth.authapi.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.authapi.models.User;

public interface UserRepository extends JpaRepository<User, UUID> {

  List<User> findByLoginAndPassword(String login, String password);

  User findByUserId(UUID id);
}