package com.example.backend.service;

import com.example.backend.models.Event;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventService {

    private final Map<Long, Event> events = new HashMap<>();
    private Long counter = 1L;

    public List<Event> getAll() {
        return new ArrayList<>(events.values());
    }

    public Event getById(Long id) {
        Event event = events.get(id);
        if (event == null) {
            throw new RuntimeException("Event not found");
        }
        return event;
    }

    public Event create(Event event) {
        event.setId(counter++);
        events.put(event.getId(), event);
        return event;
    }

    public Event update(Long id, Event updated) {
        Event existing = getById(id);

        existing.setTitle(updated.getTitle());
        existing.setType(updated.getType());
        existing.setDate(updated.getDate());
        existing.setPlaceId(updated.getPlaceId());

        return existing;
    }

    public void delete(Long id) {
        if (!events.containsKey(id)) {
            throw new RuntimeException("Event not found");
        }
        events.remove(id);
    }
}