package com.unifyed;

import com.unifyed.controller.MarsMoverController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MarsMoverAppApplication {

	@Autowired
	MarsMoverController marsMoverController;

	Logger logger = LoggerFactory.getLogger(MarsMoverAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MarsMoverAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunnerBean() {
		return (args) -> {
			logger.info("In CommandLineRunnerImpl ");

			if (args != null && args.length ==1) {
				marsMoverController.processInput(args[0]);
			} else {
				logger.error("Invalid input to process");
			}
		};
	}


}
