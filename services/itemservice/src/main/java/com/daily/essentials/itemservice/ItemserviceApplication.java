package com.daily.essentials.itemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ItemserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemserviceApplication.class, args);
	}

}
