package com.example.backend.controller;

import com.example.backend.models.Payment;
import com.example.backend.service.PaymentService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService payments;

    public PaymentController(PaymentService payment) {
        this.payments = payment;
    }

    @GetMapping
    public List<Payment> getAll() {
        return payments.getAll();
    }

//    @GetMapping("/{id}")
//    public Payment getById(@PathVariable Long id) {
//        return payments.getById(id);
//    }
//
//    @PostMapping
//    public ResponseEntity<Payment> create(@RequestBody Payment payment) {
//        return new ResponseEntity<>(payments.create(payment), HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}")
//    public Payment update(@PathVariable Long id, @RequestBody Payment payment) {
//        return payments.update(id, payment);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        payments.delete(id);
//        return ResponseEntity.noContent().build();
//    }
}