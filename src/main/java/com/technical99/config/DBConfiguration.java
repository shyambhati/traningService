package com.technical99.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//@ConfigurationProperties("spring.datasource")
public class DBConfiguration {

	@Profile("dev")
	@Bean
	public String devDatabaseConnection() {
		return "DB connection for DEV - H2";
	}

	@Profile("test")
	@Bean
	public String testDatabaseConnection() {
		return "DB Connection to DB_TEST - Low Cost Instance";
	}

	@Profile("prod")
	@Bean
	public String prodDatabaseConnection() {
		return "DB Connection to DB_LIVE - High Performance Instance";
	}
}
