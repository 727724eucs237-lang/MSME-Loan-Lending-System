package com.examly.springapp.controller;

import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Loan;
import com.examly.springapp.service.LoanService;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService service;

    public LoanController(LoanService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Loan> addLoan(@RequestBody Loan loan) {
        return new ResponseEntity<>(service.addLoan(loan), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return service.getAllLoans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable int id) {
        return ResponseEntity.ok(service.getLoanById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loan> updateLoan(
            @PathVariable int id,
            @RequestBody Loan loan) {
        return ResponseEntity.ok(service.updateLoan(id, loan));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<?> getLoansByStatus(@PathVariable String status) {
        List<Loan> loans = service.getLoansByStatus(status);
        if (loans.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("No loans found with status: " + status);
        }
        return ResponseEntity.ok(loans);
    }
}
