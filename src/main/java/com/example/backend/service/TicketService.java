package com.example.backend.service;

import com.example.backend.models.Payment;
import com.example.backend.models.Ticket;
import com.example.backend.repository.PaymentRepository;
import com.example.backend.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TicketService {

    private final TicketRepository repo;
    private final PaymentRepository paymentRepo;

    public TicketService(TicketRepository repo, PaymentRepository paymentRepo) {
        this.repo = repo;
        this.paymentRepo = paymentRepo;
    }

    public Ticket generate(Long paymentId) {

        Payment payment = paymentRepo.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        if (!"PAID".equals(payment.getStatus())) {
            throw new RuntimeException("Payment not completed");
        }

        Ticket ticket = new Ticket();
        ticket.setBooking(payment.getBooking());

        return repo.save(ticket);
    }

    public List<Ticket> getAll() {
        return repo.findAll();
    }
}