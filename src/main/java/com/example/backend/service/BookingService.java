package com.example.backend.service;

import com.example.backend.models.Booking;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookingService {

    private final Map<Long, Booking> bookings = new HashMap<>();
    private Long counter = 1L;

    public List<Booking> getAll() {
        return new ArrayList<>(bookings.values());
    }

    public Booking getById(Long id) {
        Booking event = bookings.get(id);
        if (event == null) {
            throw new RuntimeException("Event not found");
        }
        return event;
    }

    public Booking create(Booking event) {
        event.setId(counter++);
        bookings.put(event.getId(), event);
        return event;
    }

    public Booking update(Long id, Booking updated) {
        Booking existing = getById(id);

        existing.setUserId(updated.getUserId());
        existing.setExpiresAt(updated.getExpiresAt());
        existing.setEventId(updated.getEventId());

        return existing;
    }

    public void delete(Long id) {
        if (!bookings.containsKey(id)) {
            throw new RuntimeException("Event not found");
        }
        bookings.remove(id);
    }
}