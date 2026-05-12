package com.example.backend.controller;

import com.example.backend.models.User;
import com.example.backend.service.UserService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService users;

    public UserController(UserService user) {
        this.users = user;
    }

    @GetMapping
    public List<User> getAll() {
        return users.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return users.getById(id);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return new ResponseEntity<>(users.create(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return users.update(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        users.delete(id);
        return ResponseEntity.noContent().build();
    }
}