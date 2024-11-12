package com.mthree.trustBank.TrustBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class TrustBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrustBankApplication.class, args);
	}

}
