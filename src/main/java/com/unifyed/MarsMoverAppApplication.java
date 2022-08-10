package com.unifyed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MarsMoverAppApplication {

	Logger logger = LoggerFactory.getLogger(MarsMoverAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MarsMoverAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunnerBean() {
		return (args) -> {
			logger.info("In CommandLineRunnerImpl ");

			for (String arg : args) {
				logger.info(arg);
			}
		};
	}

}
