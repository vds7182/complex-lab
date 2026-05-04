package com.example.backend.models;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Ticket {
    private Long id;
    private Long bookingId;
    private Long seatId;
}