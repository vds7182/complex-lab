package com.example.backend.service;

import com.example.backend.models.User;
import com.example.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User create(User user) {
        return repo.save(user);
    }

    public List<User> getAll() {
        return repo.findAll();
    }

    public User getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User update(Long id, User updated) {
        User user = getById(id);
        user.setUsername(updated.getUsername());
        user.setPhone(updated.getPhone());
        return repo.save(user);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}