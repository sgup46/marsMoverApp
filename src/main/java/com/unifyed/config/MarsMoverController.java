package com.unifyed.config;

import com.unifyed.MarsMoverAppApplication;
import com.unifyed.exception.MarsRoverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Scanner;

@Component
public class MarsMoverController {

    Logger logger = LoggerFactory.getLogger(MarsMoverController.class);

    public void processInput(String fileName) {
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
