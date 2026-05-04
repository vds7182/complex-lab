package com.example.backend.controller;

import com.example.backend.models.Place;
import com.example.backend.service.PlaceService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {

    private final PlaceService places;

    public PlaceController(PlaceService place) {
        this.places = place;
    }

    @GetMapping
    public List<Place> getAll() {
        return places.getAll();
    }

    @GetMapping("/{id}")
    public Place getById(@PathVariable Long id) {
        return places.getById(id);
    }

    @PostMapping
    public ResponseEntity<Place> create(@RequestBody Place place) {
        return new ResponseEntity<>(places.create(place), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Place update(@PathVariable Long id, @RequestBody Place place) {
        return places.update(id, place);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        places.delete(id);
        return ResponseEntity.noContent().build();
    }
}