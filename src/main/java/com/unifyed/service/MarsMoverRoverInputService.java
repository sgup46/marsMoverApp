package com.unifyed.service;

import com.unifyed.exception.MarsRoverException;
import com.unifyed.model.Coordinates;
import com.unifyed.service.Iservice.InputService;
import com.unifyed.util.DIRECTION;
import com.unifyed.model.Rover;
import com.unifyed.model.RoverCommands;
import com.unifyed.service.commands.Command.Command;
import com.unifyed.service.commands.Command.CommandFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MarsMoverRoverInputService implements InputService<List<String>, RoverCommands> {
    @Autowired
    private CommandFactory commandFactory;

    @Override
    public RoverCommands processInput(List<String> inputs) {

        try {
            String roverinput[] = inputs.get(0).split(" ");
            DIRECTION direction = DIRECTION.valueOf(roverinput[2]);
            Coordinates coordinates = new Coordinates(Integer.parseInt(roverinput[0]), Integer.parseInt(roverinput[1]));
            Rover rover = new Rover(direction, coordinates);

            List<Command> roverCommands = new ArrayList<>();
            String commandinput[] = inputs.get(1).split("");
            Arrays.stream(commandinput).forEach(commandToProcess -> {
                roverCommands.add(commandFactory.getCommand(commandToProcess));
            });
            return new RoverCommands(rover, roverCommands);
        } catch (Exception e) {
            throw new MarsRoverException("invalid input for Rovers");
        }
    }
}
