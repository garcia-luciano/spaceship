package com.challenge.spaceship.infrastructure.input.rest;

import com.challenge.spaceship.domain.model.Spaceship;
import com.challenge.spaceship.domain.ports.input.SpaceshipUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spaceships")
@RequiredArgsConstructor
@Tag(name = "Spaceship", description = "Spaceship management APIs")
public class SpaceshipController {

    private final SpaceshipUseCase spaceshipUseCase;

    @PostMapping
    @Operation(summary = "Create a new spaceship")
    public ResponseEntity<Spaceship> createSpaceship(@RequestBody Spaceship spaceship) {
        return new ResponseEntity<>(spaceshipUseCase.createSpaceship(spaceship), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a spaceship by ID")
    public ResponseEntity<Spaceship> getSpaceship(@PathVariable Long id) {
        return spaceshipUseCase.getSpaceship(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Get all spaceships")
    public ResponseEntity<List<Spaceship>> getAllSpaceships() {
        return ResponseEntity.ok(spaceshipUseCase.getAllSpaceships());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a spaceship")
    public ResponseEntity<Spaceship> updateSpaceship(@PathVariable Long id, @RequestBody Spaceship spaceship) {
        spaceship.setId(id);
        return ResponseEntity.ok(spaceshipUseCase.updateSpaceship(spaceship));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a spaceship")
    public ResponseEntity<Void> deleteSpaceship(@PathVariable Long id) {
        spaceshipUseCase.deleteSpaceship(id);
        return ResponseEntity.noContent().build();
    }
} 