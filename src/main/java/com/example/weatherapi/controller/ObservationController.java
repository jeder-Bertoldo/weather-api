package com.example.weatherapi.controller;

import com.example.weatherapi.model.Observation;
import com.example.weatherapi.service.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/observations")
public class ObservationController {
    private final ObservationService observationService;

    @Autowired
    public ObservationController(ObservationService observationService) {
        this.observationService = observationService;
    }

    @PostMapping
    public ResponseEntity<Observation> createObservation(@RequestBody Observation observation) {
        Observation createdObservation = observationService.saveObservation(observation);
        return new ResponseEntity<>(createdObservation, HttpStatus.CREATED);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<List<Observation>> getObservationsByEvent(@PathVariable Long eventId) {
        List<Observation> observations = observationService.getObservationsByEvent(eventId);
        return ResponseEntity.ok(observations);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteObservation(@PathVariable Long id) {
        observationService.deleteObservation(id);
        return ResponseEntity.noContent().build();
    }
}
