package com.ip.bankmanager.bankmanager.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
