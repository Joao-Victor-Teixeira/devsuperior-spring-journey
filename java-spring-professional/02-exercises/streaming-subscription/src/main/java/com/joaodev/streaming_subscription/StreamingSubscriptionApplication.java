package com.joaodev.streaming_subscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joaodev.streaming_subscription.entities.Subscription;
import com.joaodev.streaming_subscription.services.SubscriptionService;

@SpringBootApplication
public class StreamingSubscriptionApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StreamingSubscriptionApplication.class, args);
	}

	@Autowired
	SubscriptionService service;

	@Override
	public void run(String... args) throws Exception {
		
		Subscription subscription = new Subscription(80.0, 12);

		double total = service.total(subscription);

		System.out.println(total);
	}

}
