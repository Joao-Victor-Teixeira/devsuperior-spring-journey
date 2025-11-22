package com.joaodev.bank_loan_simulator.service;

import org.springframework.stereotype.Service;

@Service
public class InterestService {

    public double interestCalculation(double amount, int months){

        if (months <= 6) {
            return amount * 0.02 * months;
        }
        else{
            return amount * 0.015 * months;
        }
    }
}
