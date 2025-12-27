package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Customer;

@Service
public class CustomerService {

    private final List<Customer> customers = new ArrayList<>();
    private int id = 1;

    public Customer addCustomer(Customer customer) {
        customer.setCustomerId((long) id++);
        customers.add(customer);
        return customer;
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer getCustomerById(int id) {
        return customers.stream()
                .filter(c -> c.getCustomerId() == id)
                .findFirst()
                .orElse(null);
    }

    public Customer updateCustomer(int id, Customer updated) {
        Customer customer = getCustomerById(id);
        if (customer == null) return null;

        customer.setCustomerName(updated.getCustomerName());
        customer.setEmail(updated.getEmail());
        customer.setPhoneNumber(updated.getPhoneNumber());
        customer.setAddress(updated.getAddress());
        customer.setCreditScore(updated.getCreditScore());

        return customer;
    }

    public void deleteCustomer(int id) {
        customers.removeIf(c -> c.getCustomerId() == id);
    }

    // Day-12
    public Customer getCustomerByEmail(String email) {
        return customers.stream()
                .filter(c -> c.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    public List<Customer> getCustomersByCreditScore(Double score) {
        List<Customer> result = new ArrayList<>();
        for (Customer c : customers) {
            if (c.getCreditScore() >= score) {
                result.add(c);
            }
        }
        return result;
    }
}
