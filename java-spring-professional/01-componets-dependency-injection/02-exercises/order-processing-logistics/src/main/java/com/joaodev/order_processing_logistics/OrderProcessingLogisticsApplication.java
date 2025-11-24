package com.joaodev.order_processing_logistics;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joaodev.order_processing_logistics.entities.Order;
import com.joaodev.order_processing_logistics.entities.Product;
import com.joaodev.order_processing_logistics.entities.enums.ShippingRates;
import com.joaodev.order_processing_logistics.services.OrderService;

@SpringBootApplication
public class OrderProcessingLogisticsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OrderProcessingLogisticsApplication.class, args);
	}

	@Autowired
	OrderService orderService;

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("--- Entre com os dados do produto ---");
		System.out.print("Produto: ");
		String name = sc.nextLine();
		System.out.print("Preço: ");
		Double price = sc.nextDouble();
		
		Product p1 = new Product(name, price);

		System.out.println("--- Entre com os dados do pedido ---");
		System.out.print("Código do pedido: ");
		Integer code = sc.nextInt();
		System.out.print("Percentual de desconto: ");
		Double discountPercent = sc.nextDouble();
		System.out.print("Região: ");
		ShippingRates region = ShippingRates.valueOf(sc.next().toUpperCase());

		Order o1 = new Order(code, p1, discountPercent, region);

		Double total = orderService.total(o1);

		System.out.println("--- Total do pedido ---");
		System.out.printf("Total R$%.2f%n",total);		

		sc.close();
	}

}
