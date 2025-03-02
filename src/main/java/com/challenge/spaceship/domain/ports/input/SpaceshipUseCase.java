package com.challenge.spaceship.domain.ports.input;

import com.challenge.spaceship.domain.model.Spaceship;
import java.util.List;
import java.util.Optional;

public interface SpaceshipUseCase {
    Spaceship createSpaceship(Spaceship spaceship);
    Optional<Spaceship> getSpaceship(Long id);
    List<Spaceship> getAllSpaceships();
    Spaceship updateSpaceship(Spaceship spaceship);
    void deleteSpaceship(Long id);
} 