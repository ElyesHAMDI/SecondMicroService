package com.exemple.seceond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.exemple.seceond.adapter.client")
public class SecondRestApplication {
	private static final Logger log = LoggerFactory.getLogger(SecondRestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SecondRestApplication.class, args);
		log.info("Microservice SecondRestApplication démarré !");
	}
}
