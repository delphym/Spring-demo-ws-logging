package com.trimble.wslicensemgr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoWsLicenseMgrApplication {

	@Bean
	HealthIndicator healthIndicator() {
		return () -> Health.status("I <3 Production!").build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoWsLicenseMgrApplication.class, args);
	}

}
