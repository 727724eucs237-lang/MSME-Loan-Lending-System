package com.examly.springapp.controller;

import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.LoanType;
import com.examly.springapp.service.LoanTypeService;

@RestController
@RequestMapping("/api/loantypes")
public class LoanTypeController {

    private final LoanTypeService service;

    public LoanTypeController(LoanTypeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LoanType> addLoanType(@RequestBody LoanType loanType) {
        return new ResponseEntity<>(service.addLoanType(loanType), HttpStatus.CREATED);
    }

    @GetMapping
    public List<LoanType> getAllLoanTypes() {
        return service.getAllLoanTypes();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanType> updateLoanType(
            @PathVariable int id,
            @RequestBody LoanType loanType) {
        return ResponseEntity.ok(service.updateLoanType(id, loanType));
    }
}
