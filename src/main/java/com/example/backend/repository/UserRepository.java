package com.example.backend.repository;

import com.example.backend.models.Event;
import com.example.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
