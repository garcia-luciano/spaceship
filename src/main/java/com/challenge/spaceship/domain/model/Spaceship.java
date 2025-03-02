package com.challenge.spaceship.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               
@Builder            
@NoArgsConstructor  
@AllArgsConstructor 
public class Spaceship {
    private Long id;
    private String name;
    private String model;
    private Integer capacity;
    private String status;
}