package com.joaodev.payment_system.services;

import org.springframework.stereotype.Service;


@Service
public class TaxService {
    
    
    public double tax(double amount) { 
        if (amount < 3000.0) {
            return 0.0;
        }
        if (amount < 5000.0) {
            return amount * 01;
        }
        else{
            return amount * 0.2;
        }
        
    }
}
