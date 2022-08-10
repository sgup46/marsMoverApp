package com.unifyed;

import com.sun.deploy.util.ArrayUtil;
import com.unifyed.exception.MarsRoverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

			if (args != null && args.length ==1) {
				processInputFile(args[0]);
			} else {
				logger.error("Invalid input to process");
			}
		};
	}

	protected void processInputFile(String fileName) {
		try {
			logger.error("Going to process file :" + fileName);
			Scanner inputScanner = new Scanner(new File(fileName));

			if(inputScanner == null)
			{
				throw new MarsRoverException("Invalid Input in the file");
			}

			String plateuInput = inputScanner.nextLine();
			logger.info(plateuInput);
			String roverInput = null;
			String roverCommandsInput = null;
			while (inputScanner.hasNextLine()) {
				roverInput = inputScanner.nextLine();
				roverCommandsInput = inputScanner.nextLine();
				logger.info(roverInput);
				logger.info(roverCommandsInput);
			}

		} catch (Exception e) {
			throw new MarsRoverException(e.getMessage());
		}
	}

}
