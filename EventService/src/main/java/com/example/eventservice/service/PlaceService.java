package com.example.eventservice.service;

import com.example.eventservice.models.Place;
import com.example.eventservice.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlaceService {

    private final PlaceRepository repo;

    public PlaceService(PlaceRepository repo) {
        this.repo = repo;
    }

    public Place create(Place place) {
        return repo.save(place);
    }

    public List<Place> getAll() {
        return repo.findAll();
    }

    public Place getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Place not found"));
    }

    public Place update(Long id, Place updated) {
        Place p = getById(id);

        p.setName(updated.getName());
        p.setAddress(updated.getAddress());
        p.setPhone(updated.getPhone());
        p.setEmail(updated.getEmail());

        return repo.save(p);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}