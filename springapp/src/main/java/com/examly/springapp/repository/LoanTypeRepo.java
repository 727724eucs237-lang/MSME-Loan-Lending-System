package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.LoanType;

public interface LoanTypeRepo extends JpaRepository<LoanType, Long> {
}
