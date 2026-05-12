package com.example.backend.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long event;
    private Long user;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    private LocalDateTime time;
}