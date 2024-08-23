package com.example.weatherapi.controller;

import com.example.weatherapi.model.WeatherComment;
import com.example.weatherapi.service.WeatherCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class WeatherCommentController {
    private final WeatherCommentService weatherCommentService;

    @Autowired
    public WeatherCommentController(WeatherCommentService weatherCommentService) {
        this.weatherCommentService = weatherCommentService;
    }

    @PostMapping
    public ResponseEntity<WeatherComment> addComment(@RequestBody WeatherComment comment) {
        WeatherComment createdComment = weatherCommentService.addComment(comment);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<WeatherComment>> getCommentsByCity(@PathVariable String city) {
        List<WeatherComment> comments = weatherCommentService.getCommentsByCity(city);
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WeatherComment> getCommentById(@PathVariable Long id) {
        return weatherCommentService.getCommentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<WeatherComment> updateComment(@PathVariable Long id, @RequestBody WeatherComment updatedComment) {
        try {
            WeatherComment updated = weatherCommentService.updateComment(id, updatedComment);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        weatherCommentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}
