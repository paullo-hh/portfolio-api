package com.portfolio.portfolio_api.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvConfig {
  public static void loadEnv() {
    Dotenv dotenv = Dotenv
        .configure()
        .filename("/.env.test")
        .load();
    dotenv.entries().forEach( entry -> {
      System.setProperty(entry.getKey(), entry.getValue());
    });
  }
}
