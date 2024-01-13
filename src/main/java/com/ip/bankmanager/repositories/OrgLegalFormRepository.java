package com.ip.bankmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ip.bankmanager.entities.OrgLegalForm;

@Repository
public interface OrgLegalFormRepository extends JpaRepository<OrgLegalForm, Integer> {
    
}
