package com.example.backend.service;

import com.example.backend.models.Seat;
import com.example.backend.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SeatService {

    private final SeatRepository repo;

    public SeatService(SeatRepository repo) {
        this.repo = repo;
    }

    public Seat create(Seat seat) {
        return repo.save(seat);
    }

    public List<Seat> getAll() {
        return repo.findAll();
    }

    public Seat getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Seat not found"));
    }

    public Seat update(Long id, Seat updated) {
        Seat s = getById(id);
        s.setAvailable(updated.isAvailable());
        s.setEvent(updated.getEvent());
        return repo.save(s);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}