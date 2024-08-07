package com.example.weatherapi.service;

import com.example.weatherapi.model.ExtremeWeatherEvent;
import com.example.weatherapi.repository.ExtremeWeatherEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtremeWeatherEventService {
    private final ExtremeWeatherEventRepository eventRepository;

    @Autowired
    public ExtremeWeatherEventService(ExtremeWeatherEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public ExtremeWeatherEvent saveEvent(ExtremeWeatherEvent event) {
        return eventRepository.save(event);
    }
}
