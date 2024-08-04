package com.example.weatherapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Forecast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private LocalDate date;
    private double temperature;
    private String description;

    public void setDate(LocalDate dt) {
    }

    public void setTemperature(Object o) {
    }

    public void setDescription(Object o) {
    }

    public void setCity(String city) {
    }

    // Getters and Setters
}
