package com.ip.bankmanager.bankmanager.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ip.bankmanager.bankmanager.Entities.Deposit;

public interface DepositRepository extends JpaRepository<Deposit, Integer> {
    
}
