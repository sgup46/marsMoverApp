package com.unifyed.service;

import com.unifyed.exception.MarsRoverException;
import com.unifyed.model.Coordinates;
import com.unifyed.service.Iservice.InputService;
import com.unifyed.util.DIRECTION;
import com.unifyed.model.Rover;
import com.unifyed.model.RoverCommands;
import com.unifyed.service.commands.Command.Command;
import com.unifyed.service.commands.Command.CommandFactory;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  * Class responsible for processing input for rovers
 */
@Service
@Data
public class MarsMoverRoverInputService implements InputService<List<String>, RoverCommands> {
    @Autowired
    private CommandFactory commandFactory;

    @Override
    public RoverCommands processInput(List<String> inputs) {

        try {
            String roverInput[] = inputs.get(0).split(" ");
            DIRECTION direction = DIRECTION.valueOf(roverInput[2]);
            Coordinates coordinates = new Coordinates(Integer.parseInt(roverInput[0]), Integer.parseInt(roverInput[1]));
            Rover rover = new Rover(direction, coordinates);

            List<Command> roverCommands = new ArrayList<>();
            String commandInput[] = inputs.get(1).split("");
            Arrays.stream(commandInput).forEach(commandToProcess -> {
                roverCommands.add(commandFactory.getCommand(commandToProcess));
            });
            return new RoverCommands(rover, roverCommands);
        } catch (Exception e) {
            throw new MarsRoverException("invalid input for Rovers:"+ inputs);
        }
    }
}
