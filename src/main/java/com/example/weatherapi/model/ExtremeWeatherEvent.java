package com.example.weatherapi.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class ExtremeWeatherEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String eventType; // e.g., Storm, Flood, Heatwave
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;

    @OneToMany(mappedBy = "event")
    private List<Observation> observations;

    // Getters and Setters
}
