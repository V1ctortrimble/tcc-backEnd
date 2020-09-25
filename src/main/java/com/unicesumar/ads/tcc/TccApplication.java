package com.unicesumar.ads.tcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TccApplication {
	public static void main(String[] args) {
		SpringApplication.run(TccApplication.class, args);
		System.out.println("Senha criptografada para teste: " + new BCryptPasswordEncoder().encode("12345"));
	}
}