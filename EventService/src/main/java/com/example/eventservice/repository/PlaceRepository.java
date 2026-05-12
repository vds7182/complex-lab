package com.example.eventservice.repository;

import com.example.eventservice.models.Event;
import com.example.eventservice.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}

