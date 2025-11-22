package com.joaodev.streaming_subscription.entities;


public class Subscription {

    private Double monthlyPrice;
    private Integer months;
    

    public Subscription(){
    }

    public Subscription(Double monthlyPrice, Integer months) {
        this.monthlyPrice = monthlyPrice;
        this.months = months;
        
    }

    public Double getMonthlyPrice() {
        return monthlyPrice;
    }

    public void setMonthlyPrice(Double monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }    
}
