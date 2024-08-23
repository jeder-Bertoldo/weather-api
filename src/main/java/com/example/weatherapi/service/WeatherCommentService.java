package com.example.weatherapi.service;

import com.example.weatherapi.model.WeatherComment;
import com.example.weatherapi.repository.WeatherCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class WeatherCommentService {
    private final WeatherCommentRepository weatherCommentRepository;

    @Autowired
    public WeatherCommentService(WeatherCommentRepository weatherCommentRepository) {
        this.weatherCommentRepository = weatherCommentRepository;
    }

    public WeatherComment addComment(WeatherComment comment) {
        comment.setTimestamp(LocalDateTime.now());
        return weatherCommentRepository.save(comment);
    }

    public List<WeatherComment> getCommentsByCity(String city) {
        return weatherCommentRepository.findByCityOrderByTimestampDesc(city);
    }

    public Optional<WeatherComment> getCommentById(Long id) {
        return weatherCommentRepository.findById(id);
    }

    public WeatherComment updateComment(Long id, WeatherComment updatedComment) {
        return weatherCommentRepository.findById(id)
                .map(existingComment -> {
                    existingComment.setComment(updatedComment.getComment());
                    existingComment.setTimestamp(LocalDateTime.now());
                    return weatherCommentRepository.save(existingComment);
                })
                .orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    public void deleteComment(Long id) {
        weatherCommentRepository.deleteById(id);
    }
}

