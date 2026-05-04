package com.example.backend.models;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Event {
    private Long id;
    private String type;
    private String title;
    private LocalDateTime date;
    private Long placeId;
}