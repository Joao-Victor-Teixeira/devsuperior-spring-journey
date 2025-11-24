package com.joaodev.bank_loan_simulator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joaodev.bank_loan_simulator.entities.Loan;
import com.joaodev.bank_loan_simulator.service.LoanService;

@SpringBootApplication
public class BankLoanSimulatorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BankLoanSimulatorApplication.class, args);
	}

	@Autowired
	LoanService loanService;

	@Override
	public void run(String... args) throws Exception {
		
		Loan loan = new Loan(1000.0, 5);

		double total = loanService.totalPayment(loan);

		System.out.println(total);
	}

}
