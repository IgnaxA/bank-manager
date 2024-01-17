package com.ip.bankmanager.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    public Integer clientId;

    @Column(name = "client_name")
    public String clientName;

    @Column(name = "client_short_name")
    public String clientShortName;

    @Column(name = "address")
    public String address;

    @Column(name = "org_legal_forms_id")
    public Integer orgLegalFormId;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientShortName() {
        return clientShortName;
    }

    public void setClientShortName(String clientShortName) {
        this.clientShortName = clientShortName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getOrgLegalFormId() {
        return orgLegalFormId;
    }

    public void setOrgLegalFormId(Integer orgLegalFormId) {
        this.orgLegalFormId = orgLegalFormId;
    }

    public Client() {
        this.clientId = null;
        this.clientName = null;
        this.clientShortName = null;
        this.address = null;
        this.orgLegalFormId = null;
    }

    public Client(Integer clientId, String clientName, String clientShortName, String address, Integer orgLegalFormId) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientShortName = clientShortName;
        this.address = address;
        this.orgLegalFormId = orgLegalFormId;
    }

    @Override
    public String toString() {
        return "Client [clientId=" + clientId + ", clientName=" + clientName + ", clientShortName=" + clientShortName
                + ", address=" + address + ", orgLegalFormId=" + orgLegalFormId + "]";
    }
}
