package com.unifyed.controller;

import com.unifyed.exception.MarsRoverException;
import com.unifyed.model.Plataeu;
import com.unifyed.model.RoverCommands;
import com.unifyed.service.Iservice.InputService;
import com.unifyed.service.Iservice.OutputService;
import com.unifyed.service.Iservice.ProcessService;
import com.unifyed.service.MarsMoverOutputService;
import com.unifyed.service.MarsMoverPlateuInputService;
import com.unifyed.service.MarsMoverProcessService;
import com.unifyed.service.MarsMoverRoverInputService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

@Component
public class MarsMoverController {

    @Autowired
    @Qualifier("marsMoverPlateuInputService")
    private InputService marsMoverPlateuInputService;

    @Autowired
    @Qualifier("marsMoverRoverInputService")
    private InputService marsMoverRoverInputService;

    @Autowired
    @Qualifier("marsMoverProcessService")
    private ProcessService marsMoverProcessService;

    @Autowired
    @Qualifier("marsMoverOutputService")
    private OutputService marsMoverOutputService;


    Logger logger = LoggerFactory.getLogger(MarsMoverController.class);

    public String processInput(String fileName) {
        try {
            logger.error("Going to process file :" + fileName);
            Scanner inputScanner = new Scanner(new File(fileName));

            if(inputScanner == null)
            {
                throw new MarsRoverException("Invalid Input in the file");
            }

            String plateuInput = inputScanner.nextLine();
            Plataeu plataeu = ((MarsMoverPlateuInputService)marsMoverPlateuInputService).processInput(Arrays.asList(plateuInput));
            logger.info(plataeu.toString());

            String roverInput = null;
            String roverCommandsInput = null;
            RoverCommands roverCommands = null;

            while (inputScanner.hasNextLine()) {
                roverInput = inputScanner.nextLine();
                roverCommandsInput = inputScanner.nextLine();
                roverCommands = ((MarsMoverRoverInputService)marsMoverRoverInputService).processInput(Arrays.asList(roverInput, roverCommandsInput));
                logger.info(roverCommands.toString());

                // final process each rover sequentially with rover commands
                ((MarsMoverProcessService)marsMoverProcessService).process(roverCommands, plataeu);
            }

            return ((MarsMoverOutputService)marsMoverOutputService).processOutput(plataeu);

        } catch (Exception e) {
            throw new MarsRoverException(e.getMessage());
        }
    }
}
