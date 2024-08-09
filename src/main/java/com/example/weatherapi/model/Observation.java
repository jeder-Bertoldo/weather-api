package com.example.weatherapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)  // Certifique-se de que a chave estrangeira não seja nula
    private ExtremeWeatherEvent event;

    @Column(name = "`user`")
    private String user;

    private String comment;
    private LocalDateTime date;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExtremeWeatherEvent getEvent() {
        return event;
    }

    public void setEvent(ExtremeWeatherEvent event) {
        this.event = event;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
