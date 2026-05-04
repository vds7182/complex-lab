package com.example.backend.models;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Booking {
    private Long id;
    private Long eventId;
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
}