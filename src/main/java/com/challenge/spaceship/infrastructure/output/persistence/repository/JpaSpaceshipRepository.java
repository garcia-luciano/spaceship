package com.challenge.spaceship.infrastructure.output.persistence.repository;

import com.challenge.spaceship.infrastructure.output.persistence.entity.SpaceshipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaSpaceshipRepository extends JpaRepository<SpaceshipEntity, Long> {
} 