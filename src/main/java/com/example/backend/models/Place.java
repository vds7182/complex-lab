package com.example.backend.models;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Place {
    private Long id;
    private String name;
    private String type;
    private String address;
    private String phone;
    private String email;
}