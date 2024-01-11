package com.ip.bankmanager.bankmanager.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ip.bankmanager.bankmanager.Entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    
}
