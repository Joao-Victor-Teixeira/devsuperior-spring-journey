package com.joaodev.payment_system.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaodev.payment_system.entities.Employee;

@Service
public class PayService {
    
    @Autowired
    private TaxService taxService; 

    public double netSalary(Employee employee) {
        double gross = employee.getDaysWorked() * employee.getDailyIncome();
        double tax = taxService.tax(gross);
        
        return gross - tax;
    }
}
