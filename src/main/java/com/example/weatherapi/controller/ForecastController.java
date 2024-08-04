package com.example.weatherapi.controller;

import com.example.weatherapi.model.Forecast;
import com.example.weatherapi.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/forecast")
public class ForecastController {
    private final ForecastService forecastService;

    @Autowired
    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<List<Forecast>> getForecast(@PathVariable String city) {
        List<Forecast> forecasts = forecastService.getForecast(city);
        if (!forecasts.isEmpty()) {
            return ResponseEntity.ok(forecasts);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
