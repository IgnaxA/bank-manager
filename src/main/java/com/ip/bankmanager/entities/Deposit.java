package com.ip.bankmanager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;;

@Entity(name="deposits")
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int   deposit_id;
    private int   client_id;
    private int   bank_id;
    private Date  opening_date;
    private int   percent;
    private int   period_month;

    
    public int getDeposit_id() {
        return deposit_id;
    }

    public void setDeposit_id(int deposit_id) {
        this.deposit_id = deposit_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getBank_id() {
        return bank_id;
    }

    public void setBank_id(int bank_id) {
        this.bank_id = bank_id;
    }

    public Date getOpening_date() {
        return opening_date;
    }

    public void setOpening_date(Date opening_date) {
        this.opening_date = opening_date;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getPeriod_month() {
        return period_month;
    }

    public void setPeriod_month(int period_month) {
        this.period_month = period_month;
    }

    public Deposit() {}

    public Deposit(int deposit_id, int client_id, int bank_id, Date opening_date, int percent, int period_month) {
        this.deposit_id = deposit_id;
        this.client_id = client_id;
        this.bank_id = bank_id;
        this.opening_date = opening_date;
        this.percent = percent;
        this.period_month = period_month;
    }



}
