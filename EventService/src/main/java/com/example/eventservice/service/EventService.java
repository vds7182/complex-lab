package com.example.eventservice.service;

import com.example.eventservice.models.Event;
import com.example.eventservice.repository.EventRepository;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable("events")
    public List<Event> getAll() {
        return repo.findAll();
    }

    @Cacheable("event")
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