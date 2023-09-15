package com.auth.authapi.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.authapi.models.Resource;
import com.auth.authapi.models.User;
import com.auth.authapi.models.UserResource;

public interface UserResourceRepository extends JpaRepository<UserResource, UUID> {

	Optional<UserResource>findByUserAndResource (User user, Resource resource);
}