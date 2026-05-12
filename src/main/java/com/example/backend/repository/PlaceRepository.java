package com.example.backend.repository;

import com.example.backend.models.Event;
import com.example.backend.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}

