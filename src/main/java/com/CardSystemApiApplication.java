package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.cardsystem")
public class CardSystemApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CardSystemApiApplication.class, args);
    }
}