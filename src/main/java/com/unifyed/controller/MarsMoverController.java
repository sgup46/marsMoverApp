package com.unifyed.controller;

import com.unifyed.exception.MarsRoverException;
import com.unifyed.model.Plataeu;
import com.unifyed.model.RoverCommands;
import com.unifyed.service.PlateuService;
import com.unifyed.service.RoverCommandService;
import com.unifyed.service.RoverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

@Component
public class MarsMoverController {

    @Autowired
    private PlateuService plateuService;

    @Autowired
    private RoverService roverService;

    @Autowired
    private RoverCommandService roverCommandService;


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
            Plataeu plataeu = plateuService.process(Arrays.asList(plateuInput));
            logger.info(plataeu.toString());

            String roverInput = null;
            String roverCommandsInput = null;
            RoverCommands roverCommands = null;

            while (inputScanner.hasNextLine()) {
                roverInput = inputScanner.nextLine();
                roverCommandsInput = inputScanner.nextLine();
                roverCommands = roverService.process(Arrays.asList(roverInput, roverCommandsInput));
                logger.info(roverCommands.toString());
            }

        } catch (Exception e) {
            throw new MarsRoverException(e.getMessage());
        }
    }
}
