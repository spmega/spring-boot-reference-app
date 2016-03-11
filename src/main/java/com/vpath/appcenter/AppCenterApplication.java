package com.vpath.appcenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppCenterApplication {
	private static final Logger log = LoggerFactory.getLogger(AppCenterApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AppCenterApplication.class);
		app.setAdditionalProfiles("dev");
		app.run(args);
	}
	
	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			log.debug("HELLO WORLD");
		};
	}
}
