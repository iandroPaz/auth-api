package com.auth.authapi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.authapi.models.Resource;

public interface ResourceRepository extends JpaRepository<Resource, UUID> {


}