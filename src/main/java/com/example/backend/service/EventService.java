package com.example.backend.service;

import com.example.backend.models.Event;
import com.example.backend.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventService {

    private final EventRepository repo;

    public EventService(EventRepository repo) {
        this.repo = repo;
    }

    public Event create(Event event) {
        return repo.save(event);
    }

    public List<Event> getAll() {
        return repo.findAll();
    }

    public Event getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public Event update(Long id, Event updated) {
        Event e = getById(id);
        e.setTitle(updated.getTitle());
        e.setType(updated.getType());
        e.setDate(updated.getDate());
        //e.setPlace(updated.getPlace());
        return repo.save(e);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}