package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CarDetailUserCompositeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarDetailUserCompositeApplication.class, args);
	}

}
