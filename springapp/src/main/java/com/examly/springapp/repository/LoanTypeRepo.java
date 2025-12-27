package com.examly.springapp.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface LoanTypeRepo extends JpaRepository<LoanType, Long>{
    
}
