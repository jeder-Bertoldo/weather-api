package com.example.weatherapi.service;

import com.example.weatherapi.model.ExtremeWeatherEvent;
import com.example.weatherapi.repository.ExtremeWeatherEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtremeWeatherEventService {
    private final ExtremeWeatherEventRepository eventRepository;

    @Autowired
    public ExtremeWeatherEventService(ExtremeWeatherEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public ExtremeWeatherEvent createEvent(ExtremeWeatherEvent event) {
        return eventRepository.save(event);
    }

    public List<ExtremeWeatherEvent> getAllEvents() {
        return eventRepository.findAll();
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
