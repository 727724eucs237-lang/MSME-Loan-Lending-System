package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Loan;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Long> {
}
