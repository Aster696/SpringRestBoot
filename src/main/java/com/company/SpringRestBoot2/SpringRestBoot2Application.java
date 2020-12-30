package com.company.SpringRestBoot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.company.SpringRestBoot2"})
public class SpringRestBoot2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestBoot2Application.class, args);
	}

}
