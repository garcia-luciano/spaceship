package com.challenge.spaceship.infrastructure.output.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "spaceships")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpaceshipEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String model;
    
    private Integer capacity;
    
    @Column(nullable = false)
    private String status;
} 