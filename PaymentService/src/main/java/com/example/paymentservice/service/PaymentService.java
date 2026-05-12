package com.example.paymentservice.service;

import com.example.paymentservice.models.Payment;
import com.example.paymentservice.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PaymentService {

    private final PaymentRepository repo;
    private final BookingRepository bookingRepo;

    public PaymentService(PaymentRepository repo, BookingRepository bookingRepo) {
        this.repo = repo;
        this.bookingRepo = bookingRepo;
    }

    public Payment pay(Long bookingId) {

        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        Payment payment = new Payment();
        payment.setBooking(booking);
        payment.setStatus("PAID");

        return repo.save(payment);
    }

    public List<Payment> getAll() {
        return repo.findAll();
    }
}