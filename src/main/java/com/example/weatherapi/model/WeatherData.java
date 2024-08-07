package com.example.weatherapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    // Getters and Setters
    @JsonProperty
    public Long getId() {
        return id;
    }

    @JsonProperty
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty
    public String getCity() {
        return city;
    }

    @JsonProperty
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty
    public double getTemperature() {
        return temperature;
    }

    @JsonProperty
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @JsonProperty
    public int getHumidity() {
        return humidity;
    }

    @JsonProperty
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    @JsonProperty
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @JsonProperty
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
