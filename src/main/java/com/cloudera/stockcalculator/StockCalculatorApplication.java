package com.cloudera.stockcalculator;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.cloudera")
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.cloudera")
@EnableWebMvc
public class StockCalculatorApplication extends ResourceConfig {

	public static void main(String[] args) {
		SpringApplication.run(StockCalculatorApplication.class, args);
	}

}
