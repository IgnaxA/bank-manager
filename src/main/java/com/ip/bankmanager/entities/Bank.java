package com.ip.bankmanager.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="banks")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_id")
    private Integer bankId;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bic")
    private Integer bic;
    
    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Integer getBic() {
        return bic;
    }

    public void setBic(Integer bic) {
        this.bic = bic;
    }

    public Bank() {
        this.bankId = null;
        this.bankName = null;
        this.bic = null;
    }

    public Bank(int bank_id, String bank_name, int bic) {
        this.bankId = bank_id;
        this.bankName = bank_name;
        this.bic = bic;
    }

    @Override
    public String toString() {
        return "Bank [bank_id=" + bankId + ", bank_name=" + bankName + ", bic=" + bic + "]";
    }
}
