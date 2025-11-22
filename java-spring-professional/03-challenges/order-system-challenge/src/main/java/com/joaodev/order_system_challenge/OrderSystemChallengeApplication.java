package com.joaodev.order_system_challenge;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joaodev.order_system_challenge.entities.Order;
import com.joaodev.order_system_challenge.services.OrderService;

@SpringBootApplication
public class OrderSystemChallengeApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(OrderSystemChallengeApplication.class, args);
	}

	@Autowired
	OrderService orderService;

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("---DADOS DO PEDIDO---");
		System.out.print("Código do pedido: ");
		Integer code = sc.nextInt();
		System.out.print("Valor básico: ");
		Double basic = sc.nextDouble();
		System.out.print("Desconto: ");
		Double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);

		double total = orderService.total(order);

		System.out.printf("Pedido código %d%n", order.getCode());
		System.out.printf("Valor total: R$ %.2f%n", total);

		sc.close();
	}


}
