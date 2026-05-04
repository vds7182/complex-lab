package com.example.backend.service;

import com.example.backend.models.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final Map<Long, User> users = new HashMap<>();
    private Long counter = 1L;

    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    public User getById(Long id) {
        User event = users.get(id);
        if (event == null) {
            throw new RuntimeException("User not found");
        }
        return event;
    }

    public User create(User event) {
        event.setId(counter++);
        users.put(event.getId(), event);
        return event;
    }

    public User update(Long id, User updated) {
        User existing = getById(id);

        existing.setUsername(updated.getUsername());
        existing.setPhone(updated.getPhone());

        return existing;
    }

    public void delete(Long id) {
        if (!users.containsKey(id)) {
            throw new RuntimeException("User not found");
        }
        users.remove(id);
    }
}