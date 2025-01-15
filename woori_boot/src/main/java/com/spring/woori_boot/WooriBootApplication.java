package com.spring.woori_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
public class WooriBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(WooriBootApplication.class, args);
	}

}
