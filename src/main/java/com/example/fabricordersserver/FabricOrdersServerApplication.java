package com.example.fabricordersserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FabricOrdersServerApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                FabricOrdersServerApplication.class,
                args
        );
    }
}