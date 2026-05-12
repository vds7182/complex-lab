package com.example.paymentservice.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long booking;
    private Long user;
    private String status; // PAID, PENDING
    private String paymentDetails;
}