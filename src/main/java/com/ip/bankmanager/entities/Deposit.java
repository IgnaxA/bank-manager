package com.ip.bankmanager.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;;

@Entity(name="deposits")
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deposit_id")
    private Integer depositId;

    @Column(name = "client_id")
    private Integer clientId;

    @Column(name = "bank_id")
    private Integer bankId;

    @Column(name = "opening_date")
    private Date openingDate;

    @Column(name = "percent")
    private Integer percent;

    @Column(name = "period_month")
    private Integer periodMonth;

    public Integer getDepositId() {
        return depositId;
    }

    public void setDepositId(Integer depositId) {
        this.depositId = depositId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public Integer getPeriodMonth() {
        return periodMonth;
    }

    public void setPeriodMonth(Integer periodMonth) {
        this.periodMonth = periodMonth;
    }

    public Deposit() {
        this.depositId = null;
        this.clientId = null;
        this.bankId = null;
        this.openingDate = null;
        this.percent = null;
        this.periodMonth = null;
    }

    public Deposit(Integer depositId, Integer clientId, Integer bankId, Date openingDate, Integer percent, Integer periodMonth) {
        this.depositId = depositId;
        this.clientId = clientId;
        this.bankId = bankId;
        this.openingDate = openingDate;
        this.percent = percent;
        this.periodMonth = periodMonth;
    }

    @Override
    public String toString() {
        return "Deposit [depositId=" + depositId + ", clientId=" + clientId + ", bankId=" + bankId + ", openingDate="
                + openingDate + ", percent=" + percent + ", periodMonth=" + periodMonth + "]";
    }
}
