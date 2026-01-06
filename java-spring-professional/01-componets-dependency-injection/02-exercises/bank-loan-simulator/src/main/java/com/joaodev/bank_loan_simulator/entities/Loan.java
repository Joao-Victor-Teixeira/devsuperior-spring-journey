package com.joaodev.bank_loan_simulator.entities;

public class Loan {

    private Double amount;
    private Integer months;

    public Loan(){
    }

    public Loan(Double amount, Integer months) {
        this.amount = amount;
        this.months = months;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    
}
