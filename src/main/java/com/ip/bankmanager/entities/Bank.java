package com.ip.bankmanager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="banks")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int     bank_id;
    public String  bank_name;
    public int     bic;
    
    public int getBankId() {
        return bank_id;
    }
    public void setBankId(int bank_id) {
        this.bank_id = bank_id;
    }
    public String getBankName() {
        return bank_name;
    }
    public void setBankName(String bank_name) {
        this.bank_name = bank_name;
    }
    public int getBic() {
        return bic;
    }
    public void setBic(int bic) {
        this.bic = bic;
    }

    public Bank(int bank_id, String bank_name, int bic) {
        this.bank_id = bank_id;
        this.bank_name = bank_name;
        this.bic = bic;
    }

    public Bank() {}
    @Override
    public String toString() {
        return "Bank [bank_id=" + bank_id + ", bank_name=" + bank_name + ", bic=" + bic + "]";
    }

}
