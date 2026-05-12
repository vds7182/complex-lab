package com.example.backend.repository;

import com.example.backend.models.Event;
import com.example.backend.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
