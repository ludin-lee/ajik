package com.ajik;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AjikApiApplication implements CommandLineRunner {

    @Value("${spring.profiles.active:}")
    private String activeProfile;


    @Override
    public void run(String... args) throws Exception {
        System.out.printf("Active profile: '%s'" ,activeProfile );

        if ("prod".equals(activeProfile)) {
            System.out.println("Production profile detected. Attaching APM.");
        }
    }


    public static void main(String[] args) {
        SpringApplication.run(AjikApiApplication.class, args);
    }
}