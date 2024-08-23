package com.example.weatherapi.repository;

import com.example.weatherapi.model.WeatherComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherCommentRepository extends JpaRepository<WeatherComment, Long> {
    List<WeatherComment> findByCityOrderByTimestampDesc(String city);
}

