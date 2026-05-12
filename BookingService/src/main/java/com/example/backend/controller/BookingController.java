package com.example.backend.controller;

import com.example.backend.models.Booking;
import com.example.backend.service.BookingService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookings;

    public BookingController(BookingService booking) {
        this.bookings = booking;
    }

    @GetMapping
    public List<Booking> getAll() {
        return bookings.getAll();
    }

    @GetMapping("/{id}")
    public Booking getById(@PathVariable Long id) {
        return bookings.getById(id);
    }

    @PostMapping
    public ResponseEntity<Booking> create(@RequestBody Booking booking) {
        return new ResponseEntity<>(bookings.create(booking), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Booking update(@PathVariable Long id, @RequestBody Booking booking) {
        return bookings.update(id, booking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookings.delete(id);
        return ResponseEntity.noContent().build();
    }
}