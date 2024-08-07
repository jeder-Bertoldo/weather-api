package com.example.weatherapi.controller;

import com.example.weatherapi.model.ExtremeWeatherEvent;
import com.example.weatherapi.service.ExtremeWeatherEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class ExtremeWeatherEventController {
    private final ExtremeWeatherEventService eventService;

    @Autowired
    public ExtremeWeatherEventController(ExtremeWeatherEventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<ExtremeWeatherEvent> createEvent(@RequestBody ExtremeWeatherEvent event) {
        ExtremeWeatherEvent createdEvent = eventService.saveEvent(event);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
    }
}
