package com.ip.bankmanager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int     client_id;
    public String  client_name;
    public String  client_short_name;
    public String  address;
    public int     org_legal_form_id;

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_short_name() {
        return client_short_name;
    }

    public void setClient_short_name(String client_short_name) {
        this.client_short_name = client_short_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOrg_legal_form_id() {
        return org_legal_form_id;
    }

    public void setOrg_legal_form_id(int org_legal_form_id) {
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
