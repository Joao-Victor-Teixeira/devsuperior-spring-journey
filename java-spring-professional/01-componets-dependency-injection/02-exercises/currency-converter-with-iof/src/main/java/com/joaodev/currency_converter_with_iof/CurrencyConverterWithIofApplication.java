package com.joaodev.currency_converter_with_iof;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joaodev.currency_converter_with_iof.entities.CurrencyData;
import com.joaodev.currency_converter_with_iof.services.CurrencyService;

@SpringBootApplication
public class CurrencyConverterWithIofApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverterWithIofApplication.class, args);
	}
	
	@Autowired
	CurrencyService currencyService;

	@Override
	public void run(String... args) throws Exception {
	    CurrencyData currencyData = new CurrencyData(500.0, 5.0);

		double total = currencyService.finalValue(currencyData);

		System.out.println(total);


	}

}
