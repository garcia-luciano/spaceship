package com.challenge.spaceship.domain.ports.output;

import com.challenge.spaceship.domain.model.Spaceship;
import java.util.List;
import java.util.Optional;

public interface SpaceshipRepository {
    Spaceship save(Spaceship spaceship);
    Optional<Spaceship> findById(Long id);
    List<Spaceship> findAll();
    void deleteById(Long id);
} 