package com.example.weatherapi.repository;

import com.example.weatherapi.model.Forecast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForecastRepository extends JpaRepository<Forecast, Long> {
    List<Forecast> findByCityOrderByDateAsc(String city);
}
