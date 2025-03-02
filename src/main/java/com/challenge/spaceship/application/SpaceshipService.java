package com.challenge.spaceship.application;

import com.challenge.spaceship.domain.model.Spaceship;
import com.challenge.spaceship.domain.ports.input.SpaceshipUseCase;
import com.challenge.spaceship.domain.ports.output.SpaceshipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpaceshipService implements SpaceshipUseCase {
    
    private final SpaceshipRepository spaceshipRepository;

    @Override
    public Spaceship createSpaceship(Spaceship spaceship) {
        return spaceshipRepository.save(spaceship);
    }

    @Override
    public Optional<Spaceship> getSpaceship(Long id) {
        return spaceshipRepository.findById(id);
    }

    @Override
    public List<Spaceship> getAllSpaceships() {
        return spaceshipRepository.findAll();
    }

    @Override
    public Spaceship updateSpaceship(Spaceship spaceship) {
        return spaceshipRepository.save(spaceship);
    }

    @Override
    public void deleteSpaceship(Long id) {
        spaceshipRepository.deleteById(id);
    }
} 