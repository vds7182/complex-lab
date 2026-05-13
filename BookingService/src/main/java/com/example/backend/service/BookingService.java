package com.example.backend.service;

import com.example.backend.models.Booking;
import com.example.backend.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookings;
    private final RestTemplate restTemplate;

    public BookingService(BookingRepository booking,
                          RestTemplate restTemplate) {

        this.bookings = booking;
        this.restTemplate = restTemplate;
    }

    public List<Booking> getAll() {
        return bookings.findAll();
    }

    public Booking getById(Long id) {
        return bookings.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public Booking create(Booking booking) {

        String eventUrl =
                "http://event-service:8081/events/" + booking.getEvent();

        try {
            restTemplate.getForObject(
                    "http://eventservice-event-service-1:8081/events/{id}",
                    Object.class,
                    booking.getEvent()
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        booking.setCreatedAt(LocalDateTime.now());

        return bookings.save(booking);
    }

    public Booking update(Long id, Booking updated) {

        Booking existing = getById(id);

        existing.setEvent(updated.getEvent());
        existing.setUser(updated.getUser());
        existing.setTime(updated.getTime());

        return bookings.save(existing);
    }

    public void delete(Long id) {
        bookings.deleteById(id);
    }
}