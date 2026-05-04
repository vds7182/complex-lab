package com.example.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Place {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;
    private String address;
    private String phone;
    private String email;
}