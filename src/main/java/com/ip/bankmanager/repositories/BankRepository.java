package com.ip.bankmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ip.bankmanager.entities.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {
    
}
