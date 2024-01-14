package com.ip.bankmanager.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="org_legal_form")
public class OrgLegalForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "org_legal_forms_id")
    private Integer orgLegalFormsId;

    @Column(name = "org_legal_forms_name")
    private String  orgLegalFormsName;

    public Integer getOrgLegalFormsId() {
        return orgLegalFormsId;
    }

    public void setOrgLegalFormsId(Integer orgLegalFormsId) {
        this.orgLegalFormsId = orgLegalFormsId;
    }

    public String getOrgLegalFormsName() {
        return orgLegalFormsName;
    }

    public void setOrgLegalFormsName(String orgLegalFormsName) {
        this.orgLegalFormsName = orgLegalFormsName;
    }

    public OrgLegalForm() {
        this.orgLegalFormsId = null;
        this.orgLegalFormsName = null;
    }

    public OrgLegalForm(Integer orgLegalFormsId, String orgLegalFormsName) {
        this.orgLegalFormsId = orgLegalFormsId;
        this.orgLegalFormsName = orgLegalFormsName;
    }

    @Override
    public String toString() {
        return "OrgLegalForm [orgLegalFormsId=" + orgLegalFormsId + ", orgLegalFormsName=" + orgLegalFormsName + "]";
    }
}
