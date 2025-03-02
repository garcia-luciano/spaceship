package com.challenge.spaceship.infrastructure.output.persistence.mapper;

import com.challenge.spaceship.domain.model.Spaceship;
import com.challenge.spaceship.infrastructure.output.persistence.entity.SpaceshipEntity;
import org.springframework.stereotype.Component;

@Component
public class SpaceshipMapper {

    public SpaceshipEntity toEntity(Spaceship spaceship) {
        return SpaceshipEntity.builder()
                .id(spaceship.getId())
                .name(spaceship.getName())
                .model(spaceship.getModel())
                .capacity(spaceship.getCapacity())
                .status(spaceship.getStatus())
                .build();
    }

    public Spaceship toDomain(SpaceshipEntity entity) {
        return Spaceship.builder()
                .id(entity.getId())
                .name(entity.getName())
                .model(entity.getModel())
                .capacity(entity.getCapacity())
                .status(entity.getStatus())
                .build();
    }
} 