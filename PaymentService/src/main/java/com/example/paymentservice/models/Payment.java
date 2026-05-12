package com.example.paymentservice.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long booking;
    private LocalDateTime createdAt;
    private String status; // PAID, PENDING
    private String paymentDetails;
}