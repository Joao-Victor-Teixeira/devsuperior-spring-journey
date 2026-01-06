package com.joaodev.payment_system.entities;

public class Employee {
    
    private String name;
    private Double dailyIncome;
    private Integer daysWorked;

    public Employee(){
    }

     public Employee(String name, Double dailyIncome, Integer daysWorked) {
        this.name = name;
        this.dailyIncome = dailyIncome;
        this.daysWorked = daysWorked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(Double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }

    public Integer getDaysWorked() {
        return daysWorked;
    }

    public void setDaysWorked(Integer daysWorked) {
        this.daysWorked = daysWorked;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", dailyIncome=" + dailyIncome + ", daysWorked=" + daysWorked + "]";
    }

   

    
}
