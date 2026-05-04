package com.example.backend.service;

import com.example.backend.models.Ticket;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TicketService {

    private final Map<Long, Ticket> tickets = new HashMap<>();
    private Long counter = 1L;

    public List<Ticket> getAll() {
        return new ArrayList<>(tickets.values());
    }

    public Ticket getById(Long id) {
        Ticket event = tickets.get(id);
        if (event == null) {
            throw new RuntimeException("Ticket not found");
        }
        return event;
    }

    public Ticket create(Ticket event) {
        event.setId(counter++);
        tickets.put(event.getId(), event);
        return event;
    }

    public Ticket update(Long id, Ticket updated) {
        Ticket existing = getById(id);

        existing.setSeatId(updated.getSeatId());

        return existing;
    }

    public void delete(Long id) {
        if (!tickets.containsKey(id)) {
            throw new RuntimeException("Ticket not found");
        }
        tickets.remove(id);
    }
}