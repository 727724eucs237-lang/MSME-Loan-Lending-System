package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Loan;

@Service
public class LoanService {

    private final List<Loan> loans = new ArrayList<>();
    private int id = 1;

    public Loan addLoan(Loan loan) {
        loan.setLoanId((long) id++);
        loans.add(loan);
        return loan;
    }

    public List<Loan> getAllLoans() {
        return loans;
    }

    public Loan getLoanById(int id) {
        return loans.stream()
                .filter(l -> l.getLoanId() == id)
                .findFirst()
                .orElse(null);
    }

    public Loan updateLoan(int id, Loan updated) {
        Loan loan = getLoanById(id);
        if (loan == null) return null;

        loan.setLoanAmount(updated.getLoanAmount());
        loan.setInterestRate(updated.getInterestRate());
        loan.setTenureMonths(updated.getTenureMonths());
        loan.setStatus(updated.getStatus());
        loan.setCustomer(updated.getCustomer());
        loan.setLoanType(updated.getLoanType());

        return loan;
    }

    // Day-11
    public List<Loan> getLoansByStatus(String status) {
        return loans.stream()
                .filter(l -> l.getStatus() != null &&
                             l.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }
}
