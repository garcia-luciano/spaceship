package com.challenge.spaceship.infrastructure.output.persistence;

import com.challenge.spaceship.domain.model.Spaceship;
import com.challenge.spaceship.domain.ports.output.SpaceshipRepository;
import com.challenge.spaceship.infrastructure.output.persistence.mapper.SpaceshipMapper;
import com.challenge.spaceship.infrastructure.output.persistence.repository.JpaSpaceshipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SpaceshipRepositoryAdapter implements SpaceshipRepository {

    private final JpaSpaceshipRepository jpaRepository;
    private final SpaceshipMapper mapper;

    @Override
    public Spaceship save(Spaceship spaceship) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(spaceship)));
    }

    @Override
    public Optional<Spaceship> findById(Long id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Spaceship> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
} 