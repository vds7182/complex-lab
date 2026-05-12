package com.example.backend.controller;

import com.example.backend.models.Ticket;
import com.example.backend.service.TicketService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService tickets;

    public TicketController(TicketService ticket) {
        this.tickets = ticket;
    }

    @GetMapping
    public List<Ticket> getAll() {
        return tickets.getAll();
    }

//    @GetMapping("/{id}")
//    public Ticket getById(@PathVariable Long id) {
//        return tickets.getById(id);
//    }
//
//    @PostMapping
//    public ResponseEntity<Ticket> create(@RequestBody Ticket ticket) {
//        return new ResponseEntity<>(tickets.create(ticket), HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}")
//    public Ticket update(@PathVariable Long id, @RequestBody Ticket ticket) {
//        return tickets.update(id, ticket);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        tickets.delete(id);
//        return ResponseEntity.noContent().build();
//    }
}