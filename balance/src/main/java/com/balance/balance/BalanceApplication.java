package com.balance.balance;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import javax.management.modelmbean.ModelMBean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BalanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BalanceApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		return new  ModelMapper();
	}

}