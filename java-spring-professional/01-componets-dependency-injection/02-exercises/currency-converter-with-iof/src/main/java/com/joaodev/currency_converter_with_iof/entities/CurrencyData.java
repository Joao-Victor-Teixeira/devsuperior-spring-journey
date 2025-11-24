package com.joaodev.currency_converter_with_iof.entities;

public class CurrencyData {

    private Double amount;
    private Double price;

    public CurrencyData(){
    }

    public CurrencyData(Double amount, Double price) {
        this.amount = amount;
        this.price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    
}
