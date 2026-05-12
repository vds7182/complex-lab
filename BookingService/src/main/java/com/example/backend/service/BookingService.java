package com.example.backend.service;

import com.example.backend.models.Booking;
import com.example.backend.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookings;

    public BookingService(BookingRepository booking) {
        this.bookings = booking;
    }

    public List<Booking> getAll() {
        return bookings.findAll();
    }

    public Booking getById(Long id) {
        return bookings.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public Booking create(Booking booking) {
        return bookings.save(booking);
    }

    public Booking update(Long id, Booking updated) {
        Booking existing = getById(id);

        existing.setEvent(updated.getEvent());
        existing.setUser(updated.getUser());

        return bookings.save(existing);
    }

    public void delete(Long id) {
        bookings.deleteById(id);
    }
}