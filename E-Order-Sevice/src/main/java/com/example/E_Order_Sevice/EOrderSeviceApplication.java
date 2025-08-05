package com.example.E_Order_Sevice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class EOrderSeviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EOrderSeviceApplication.class, args);
	}

}
