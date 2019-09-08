package com.cloudera.stockcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cloudera", "com.microsoft", "hu.mnb"})
public class StockCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockCalculatorApplication.class, args);
	}

}
