package com.example.backend.service;

import com.example.backend.models.Place;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlaceService {

    private final Map<Long, Place> places = new HashMap<>();
    private Long counter = 1L;

    public List<Place> getAll() {
        return new ArrayList<>(places.values());
    }

    public Place getById(Long id) {
        Place event = places.get(id);
        if (event == null) {
            throw new RuntimeException("Place not found");
        }
        return event;
    }

    public Place create(Place event) {
        event.setId(counter++);
        places.put(event.getId(), event);
        return event;
    }

    public Place update(Long id, Place updated) {
        Place existing = getById(id);

        existing.setType(updated.getType());
        existing.setName(updated.getName());
        existing.setPhone(updated.getPhone());
        existing.setEmail(updated.getEmail());
        existing.setAddress(updated.getAddress());

        return existing;
    }

    public void delete(Long id) {
        if (!places.containsKey(id)) {
            throw new RuntimeException("Place not found");
        }
        places.remove(id);
    }
}