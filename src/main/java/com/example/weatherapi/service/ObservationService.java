package com.example.weatherapi.service;

import com.example.weatherapi.model.Observation;
import com.example.weatherapi.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObservationService {
    private final ObservationRepository observationRepository;

    @Autowired
    public ObservationService(ObservationRepository observationRepository) {
        this.observationRepository = observationRepository;
    }

    public Observation saveObservation(Observation observation) {
        return observationRepository.save(observation);
    }

    public List<Observation> getObservationsByEvent(Long eventId) {
        return observationRepository.findByEventIdOrderByDateDesc(eventId);
    }

    public void deleteObservation(Long id) {
        observationRepository.deleteById(id);
    }
}
