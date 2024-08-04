package com.example.weatherapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private double temperature;
    private int humidity;
    private String description;
    private LocalDateTime timestamp;

    public void setHumidity(Integer humidity) {
    }

    public void setCity(String city) {
    }

    public void setTemperature(Double temp) {
    }

    public void setDescription(String description) {
    }

    public void setTimestamp(LocalDateTime now) {
    }

    // Getters and Setters
}
