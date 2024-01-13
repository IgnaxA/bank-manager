package com.ip.bankmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ip.bankmanager.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    
}
