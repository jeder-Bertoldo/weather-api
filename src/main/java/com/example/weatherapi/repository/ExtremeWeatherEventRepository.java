package com.example.weatherapi.repository;

import com.example.weatherapi.model.ExtremeWeatherEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtremeWeatherEventRepository extends JpaRepository<ExtremeWeatherEvent, Long> {
}
