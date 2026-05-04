package com.example.backend.models;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Event {
    @Id
    @GeneratedValue
    private Long id;
    private String type;
    private String title;
    private LocalDateTime date;
    private Long placeId;
}