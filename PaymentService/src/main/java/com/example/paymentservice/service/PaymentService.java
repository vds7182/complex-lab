package com.example.paymentservice.service;

import com.example.paymentservice.models.Payment;
import com.example.paymentservice.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository repo;
    private final RestTemplate restTemplate;

    public PaymentService(PaymentRepository repo,
                          RestTemplate restTemplate) {
        this.repo = repo;
        this.restTemplate = restTemplate;
    }

    public Payment createPayment(Long bookingId) {

        String url = "http://localhost:8082/bookings/" + bookingId;

        try {
            restTemplate.getForObject(url, Object.class);
        } catch (Exception e) {
            throw new RuntimeException("Booking not found or service unavailable");
        }
        Payment payment = new Payment();
        payment.setBooking(bookingId);
        payment.setStatus("PENDING");
        payment.setCreatedAt(LocalDateTime.now());

        return repo.save(payment);
    }

    public Payment pay(Long paymentId) {

        Payment payment = repo.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setStatus("PAID");

        return repo.save(payment);
    }

    public Payment getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    public List<Payment> getAll() {
        return repo.findAll();
    }
}