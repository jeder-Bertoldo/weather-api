package com.example.weatherapi.repository;

import com.example.weatherapi.model.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ObservationRepository extends JpaRepository<Observation, Long> {
    List<Observation> findByEventIdOrderByDateDesc(Long eventId);
}
