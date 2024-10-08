package com.MIAGE.jeuxmiagiques;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.MIAGE.jeuxmiagiques.model")
public class JeuxMiagiquesApplication {
    public static void main(String[] args) {
        SpringApplication.run(JeuxMiagiquesApplication.class, args);
    }
}
