package com.exemple.seceond;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.exemple.seceond.adapter.client")
public class SecondRestApplication {
	private static final Logger log = LoggerFactory.getLogger(SecondRestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SecondRestApplication.class, args);
		log.info("YOUSSEF AND ANAS AND YOSR YASMINE Details");
	}
}

