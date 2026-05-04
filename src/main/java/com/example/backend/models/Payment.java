package com.example.backend.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String status; // PAID, PENDING
    private String paymentDetails;
}