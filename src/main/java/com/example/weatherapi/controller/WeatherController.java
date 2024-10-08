package com.example.weatherapi.controller;

import com.example.weatherapi.model.WeatherData;
import com.example.weatherapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<WeatherData> getWeather(@PathVariable String city) {
        WeatherData weatherData = weatherService.getWeatherData(city);
        if (weatherData != null) {
            return ResponseEntity.ok(weatherData);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/history/{city}")
    public ResponseEntity<List<WeatherData>> getWeatherHistory(@PathVariable String city) {
        List<WeatherData> weatherHistory = weatherService.getWeatherHistory(city);
        if (weatherHistory != null && !weatherHistory.isEmpty()) {
            return ResponseEntity.ok(weatherHistory);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
