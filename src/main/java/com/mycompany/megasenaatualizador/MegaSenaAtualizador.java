package com.mycompany.megasenatualizador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MegaSenaAtualizador {
    public static void main(String[] args) {
        SpringApplication.run(MegaSenaAtualizador.class, args);
    }
}