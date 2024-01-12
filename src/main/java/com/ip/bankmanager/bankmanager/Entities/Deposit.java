package com.ip.bankmanager.bankmanager.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    public int getDepositId() {
        return deposit_id;
    }
    public void setDepositId(int deposit_id) {
        this.deposit_id = deposit_id;
    }

    public int getClientId() {
        return client_id;
    }
    public void setClientId(int client_id) {
        this.client_id = client_id;
    }

    public int getBankId() {
        return bank_id;
    }
    public void setBankId(int bank_id) {
        this.bank_id = bank_id;
    }

    public Date getOpeningDate() {
        return opening_date;
    }
    public void setOpeningDate(Date opening_date) {
        this.opening_date = opening_date;
    }

    public int getPercent() {
        return percent;
    }
    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getPeriodMonth() {
        return period_month;
    }
    public void setPeriodMonth(int period_month) {
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
