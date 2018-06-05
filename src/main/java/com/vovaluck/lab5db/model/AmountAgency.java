package com.vovaluck.lab5db.model;

public class AmountAgency {
    long amount;
    Agency agency;

    public AmountAgency() {
    }

    public AmountAgency(long amount, Agency agency) {
        this.amount = amount;
        this.agency = agency;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }
}
