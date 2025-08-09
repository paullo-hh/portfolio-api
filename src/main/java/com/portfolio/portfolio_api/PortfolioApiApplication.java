package com.portfolio.portfolio_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.portfolio.portfolio_api.config.EnvConfig.loadEnv;

@SpringBootApplication
public class PortfolioApiApplication {

	public static void main(String[] args) {
		loadEnv();
		SpringApplication.run(PortfolioApiApplication.class, args);
	}
}
