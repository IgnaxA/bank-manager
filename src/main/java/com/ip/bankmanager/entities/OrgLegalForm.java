package com.ip.bankmanager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrgLegalForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int org_legal_forms_id;
    private String org_legal_forms_name;

    public int getOrgLegalFormsId() {
        return org_legal_forms_id;
    }
    public void setOrgLegalFormsId(int org_legal_forms_id) {
        this.org_legal_forms_id = org_legal_forms_id;
    }

    public String getOrgLegalFormsName() {
        return org_legal_forms_name;
    }
    public void setOrgLegalFormsName(String org_legal_forms_name) {
        this.org_legal_forms_name = org_legal_forms_name;
    }
    
    public OrgLegalForm() {}

    public OrgLegalForm(int org_legal_forms_id, String org_legal_forms_name) {
        this.org_legal_forms_id = org_legal_forms_id;
        this.org_legal_forms_name = org_legal_forms_name;
    }
    
}
