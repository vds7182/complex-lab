package com.example.backend.service;

import com.example.backend.DTO.PaymentResponse;
import com.example.backend.models.Ticket;
import com.example.backend.repository.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;




@Service
public class TicketService {

    private final TicketRepository repo;
    private final RestTemplate restTemplate;

    public TicketService(TicketRepository repo,
                         RestTemplate restTemplate) {
        this.repo = repo;
        this.restTemplate = restTemplate;
    }

    public Ticket generate(Long paymentId) {

        // 🔥 CALL PAYMENT SERVICE
        String url = "http://payment-service:8083/payments/" + paymentId;

        PaymentResponse payment;

        try {
            payment = restTemplate.getForObject(url, PaymentResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Payment not found or service unavailable");
        }

        if (!"PAID".equals(payment.getStatus())) {
            throw new RuntimeException("Payment is not completed");
        }

        Ticket ticket = new Ticket();
        ticket.setPayment(paymentId);
        ticket.setBooking(payment.getBooking());
        ticket.setQrCode(UUID.randomUUID().toString());

        return repo.save(ticket);
    }

    public List<Ticket> getAll() {
        return repo.findAll();
    }
}
