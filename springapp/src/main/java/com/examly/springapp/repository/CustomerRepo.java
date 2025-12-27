package com.examly.springapp.repository;

import org.springframework.stereotype.Repository;

@Repository

public interface CustomerRepo extends JpaRepository<Customer, Long>{
    
}
