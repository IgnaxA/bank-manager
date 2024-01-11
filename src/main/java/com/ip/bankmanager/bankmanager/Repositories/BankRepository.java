package com.ip.bankmanager.bankmanager.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ip.bankmanager.bankmanager.Entities.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {
    
}
