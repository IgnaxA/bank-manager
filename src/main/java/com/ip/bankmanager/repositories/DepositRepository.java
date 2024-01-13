package com.ip.bankmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ip.bankmanager.entities.Deposit;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Integer> {
    
}
