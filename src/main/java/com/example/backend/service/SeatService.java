package com.example.backend.service;

import com.example.backend.models.Seat;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SeatService {

    private final Map<Long, Seat> seats = new HashMap<>();
    private Long counter = 1L;

    public List<Seat> getAll() {
        return new ArrayList<>(seats.values());
    }

    public Seat getById(Long id) {
        Seat event = seats.get(id);
        if (event == null) {
            throw new RuntimeException("Seat not found");
        }
        return event;
    }

    public Seat create(Seat event) {
        event.setId(counter++);
        seats.put(event.getId(), event);
        return event;
    }

    public Seat update(Long id, Seat updated) {
        Seat existing = getById(id);

        existing.setNumber(updated.getNumber());
        //existing.setEventId(updated.getEventId());


        return existing;
    }

    public void delete(Long id) {
        if (!seats.containsKey(id)) {
            throw new RuntimeException("Seat not found");
        }
        seats.remove(id);
    }
}