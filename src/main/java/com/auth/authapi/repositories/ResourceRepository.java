package com.auth.authapi.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.auth.authapi.models.Resource;

public interface ResourceRepository extends JpaRepository<Resource, UUID> {

	@Query("from Resource where name =:name")
	Optional<Resource> findByName(@Param("name") String name);


}