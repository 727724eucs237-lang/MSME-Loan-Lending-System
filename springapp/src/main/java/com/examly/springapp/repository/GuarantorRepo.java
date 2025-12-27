package com.examly.springapp.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface GuarantorRepo extends JpaRepository<Guarantor, Long>{
    
}
