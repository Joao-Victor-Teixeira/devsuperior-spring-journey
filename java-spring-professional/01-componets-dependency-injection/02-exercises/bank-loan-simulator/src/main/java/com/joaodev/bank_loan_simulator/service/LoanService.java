package com.joaodev.bank_loan_simulator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaodev.bank_loan_simulator.entities.Loan;

@Service
public class LoanService {

    @Autowired
    private InterestService interestService;

    public Double totalPayment(Loan loan){
        double amount = loan.getAmount();
        int months = loan.getMonths();
        
        return amount + interestService.interestCalculation(amount, months);
    }
}
