package com.unicesumar.ads.tcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TccApplication {
	public static void main(String[] args) {
		SpringApplication.run(TccApplication.class, args);
		System.out.println("Senha criptografada para teste: " + new BCryptPasswordEncoder().encode("12345"));
	}
}