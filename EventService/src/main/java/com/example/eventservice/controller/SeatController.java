package com.example.eventservice.controller;

import com.example.eventservice.models.Seat;
import com.example.eventservice.service.SeatService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {

    private final SeatService seats;

    public SeatController(SeatService seat) {
        this.seats = seat;
    }

    @GetMapping
    public List<Seat> getAll() {
        return seats.getAll();
    }

    @GetMapping("/{id}")
    public Seat getById(@PathVariable Long id) {
        return seats.getById(id);
    }

    @PostMapping
    public ResponseEntity<Seat> create(@RequestBody Seat seat) {
        return new ResponseEntity<>(seats.create(seat), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Seat update(@PathVariable Long id, @RequestBody Seat seat) {
        return seats.update(id, seat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        seats.delete(id);
        return ResponseEntity.noContent().build();
    }
}