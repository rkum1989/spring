package com.spring.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringHelloworldCfApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "rituraj");
		SpringApplication.run(SpringHelloworldCfApplication.class, args);
	}

}
