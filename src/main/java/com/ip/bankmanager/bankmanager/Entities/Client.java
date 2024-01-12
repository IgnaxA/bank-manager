package com.ip.bankmanager.bankmanager.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int     client_id;
    public String  client_name;
    public String  client_short_name;
    public String  address;
    public int     org_legal_form_id;

    public int getClientId() {
        return client_id;
    }

    public void setClientId(int client_id) {
        this.client_id = client_id;
    }

    public String getClientName() {
        return client_name;
    }

    public void setClientName(String client_name) {
        this.client_name = client_name;
    }

    public String getClientShortName() {
        return client_short_name;
    }

    public void setClientShortName(String client_short_name) {
        this.client_short_name = client_short_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOrgLegalFormId() {
        return org_legal_form_id;
    }

    public void setOrgLegalFormId(int org_legal_form_id) {
        this.org_legal_form_id = org_legal_form_id;
    }

    public Client() {}

    public Client(int client_id, String client_name, String client_short_name, String address, int org_legal_form_id) {
        this.client_id = client_id;
        this.client_name = client_name;
        this.client_short_name = client_short_name;
        this.address = address;
        this.org_legal_form_id = org_legal_form_id;
    }
}
