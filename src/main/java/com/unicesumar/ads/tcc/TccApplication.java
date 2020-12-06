package com.unicesumar.ads.tcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class TccApplication {
	public static void main(String[] args) {
		SpringApplication.run(TccApplication.class, args);
		System.out.println("Senha criptografada para teste: " + new BCryptPasswordEncoder().encode("12345"));
		System.out.println("hora agr: " + LocalDate.now() + LocalTime.now() );
	}
}