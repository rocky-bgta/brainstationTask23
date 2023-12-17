package com.salahin.rocky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringSeedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSeedApplication.class, args);
	}

}
