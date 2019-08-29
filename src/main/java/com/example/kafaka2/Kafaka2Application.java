package com.example.kafaka2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Kafaka2Application {

    public static void main(String[] args) {
        SpringApplication.run(Kafaka2Application.class, args);
    }

}
