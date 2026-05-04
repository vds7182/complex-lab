package com.example.backend.models;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Seat {
    private Long id;
    private Long eventId;
    private String number;
    private boolean isAvailable;
}