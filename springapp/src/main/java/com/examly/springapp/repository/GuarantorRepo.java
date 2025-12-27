package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.Guarantor;

public interface GuarantorRepo extends JpaRepository<Guarantor, Long> {
}
