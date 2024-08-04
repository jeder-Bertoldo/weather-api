package com.example.weatherapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private ExtremeWeatherEvent event;

    private String user;
    private String comment;
    private LocalDateTime date;

    public void setDate(LocalDateTime now) {
    }

    // Getters and Setters
}
