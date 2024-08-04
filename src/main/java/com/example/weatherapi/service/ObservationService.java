package com.example.weatherapi.service;

import com.example.weatherapi.model.Observation;
import com.example.weatherapi.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ObservationService {
    private final ObservationRepository observationRepository;

    @Autowired
    public ObservationService(ObservationRepository observationRepository) {
        this.observationRepository = observationRepository;
    }

    public Observation createObservation(Observation observation) {
        observation.setDate(LocalDateTime.now());
        return observationRepository.save(observation);
    }

    public List<Observation> getObservationsByEventId(Long eventId) {
        return observationRepository.findByEventId(eventId);
    }

    public void deleteObservation(Long id) {
        observationRepository.deleteById(id);
    }
}
