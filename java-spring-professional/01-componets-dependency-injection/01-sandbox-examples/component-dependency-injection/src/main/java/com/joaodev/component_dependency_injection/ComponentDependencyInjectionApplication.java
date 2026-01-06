package com.joaodev.component_dependency_injection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joaodev.component_dependency_injection.entities.Employee;
import com.joaodev.component_dependency_injection.services.SalaryService;

@SpringBootApplication
public class ComponentDependencyInjectionApplication implements CommandLineRunner {

	@Autowired
	private SalaryService salaryService;

	public static void main(String[] args) {
		SpringApplication.run(ComponentDependencyInjectionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee("João", 4000.00);
		System.out.println(salaryService.netSalary(employee));
	}

}
