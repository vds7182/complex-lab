package com.example.backend.service;

import com.example.backend.models.Payment;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PaymentService {

    private final Map<Long, Payment> payments = new HashMap<>();
    private Long counter = 1L;

    public List<Payment> getAll() {
        return new ArrayList<>(payments.values());
    }

    public Payment getById(Long id) {
        Payment event = payments.get(id);
        if (event == null) {
            throw new RuntimeException("Payment not found");
        }
        return event;
    }

    public Payment create(Payment event) {
        event.setId(counter++);
        payments.put(event.getId(), event);
        return event;
    }

    public Payment update(Long id, Payment updated) {
        Payment existing = getById(id);

        existing.setBookingId(updated.getBookingId());
        existing.setPaymentDetails(updated.getPaymentDetails());

        existing.setStatus(updated.getStatus());



        return existing;
    }

    public void delete(Long id) {
        if (!payments.containsKey(id)) {
            throw new RuntimeException("Payment not found");
        }
        payments.remove(id);
    }
}