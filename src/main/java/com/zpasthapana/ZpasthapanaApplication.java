package com.zpasthapana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ZpasthapanaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZpasthapanaApplication.class, args);
	}

}
