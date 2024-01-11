package com.ip.bankmanager.bankmanager.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ip.bankmanager.bankmanager.Entities.OrgLegalForm;

public interface OrgLegalFormRepository extends JpaRepository<OrgLegalForm, Integer> {
    
}
