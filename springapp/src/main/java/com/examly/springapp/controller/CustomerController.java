package com.examly.springapp.controller;

import java.util.List;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Customer;
import com.examly.springapp.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody(required = false) Customer customer) {
        if (customer == null) return ResponseEntity.badRequest().build();
        return new ResponseEntity<>(service.addCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
        return ResponseEntity.ok(service.getCustomerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable int id, @RequestBody Customer customer) {
        return ResponseEntity.ok(service.updateCustomer(id, customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
        service.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

   
    @GetMapping("/page/{page}/{size}")
    public Page<Customer> paginate(@PathVariable int page, @PathVariable int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Customer> list = service.getAllCustomers();
        int start = Math.min(page * size, list.size());
        int end = Math.min(start + size, list.size());
        return new PageImpl<>(list.subList(start, end), pageable, list.size());
    }

    // Day-12 — Get customer by email
@GetMapping("/email/{email}")
public ResponseEntity<?> getCustomerByEmail(@PathVariable String email) {

    Customer customer = service.getCustomerByEmail(email);

    if (customer == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Customer not found with email: " + email);
    }

    return ResponseEntity.ok(customer);
}

// Day-12 — Get customers by credit score
@GetMapping("/creditScore/{score}")
public ResponseEntity<?> getCustomersByCreditScore(@PathVariable Double score) {

    List<Customer> customers = service.getCustomersByCreditScore(score);

    if (customers.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No customers found with credit score >= " + score);
    }

    return ResponseEntity.ok(customers);
}

}
