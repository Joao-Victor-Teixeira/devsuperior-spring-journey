package com.joaodev.payment_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joaodev.payment_system.entities.Employee;
import com.joaodev.payment_system.services.PayService;

@SpringBootApplication
public class PaymentSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PaymentSystemApplication.class, args);
	}

	@Autowired
	PayService payService;

	@Override
	public void run(String... args) throws Exception {
		
		Employee employee = new Employee("João", 300.00, 20);

		
		double total = payService.netSalary(employee);
		
		
		System.out.println(total);
	}

}
