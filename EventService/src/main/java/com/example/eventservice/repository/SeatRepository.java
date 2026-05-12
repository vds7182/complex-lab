package com.example.eventservice.repository;

import com.example.eventservice.models.Event;
import com.example.eventservice.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
