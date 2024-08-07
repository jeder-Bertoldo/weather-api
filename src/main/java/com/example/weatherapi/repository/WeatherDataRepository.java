package com.example.weatherapi.repository;

import com.example.weatherapi.model.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
    List<WeatherData> findByCityOrderByTimestampDesc(String city);
}
