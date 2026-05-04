package com.example.backend.models;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Payment {
    private Long id;
    private Long bookingId;
    private Long userId;
    private String status; // PAID, PENDING
    private String paymentDetails;
}