package com.unifyed.service;

import com.unifyed.exception.MarsRoverException;
import com.unifyed.model.Coordinates;
import com.unifyed.model.DIRECTION;
import com.unifyed.model.Rover;
import com.unifyed.model.RoverCommands;
import com.unifyed.service.commands.Command.Command;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;

@Service
public class RoverService  implements MarsMoverService<List<String>, RoverCommands>{
    @Override
    public RoverCommands process(List<String> inputs) {

        try {
            String roverinput[] = inputs.get(0).split(" ");
            DIRECTION direction = DIRECTION.valueOf(roverinput[2]);
            Coordinates coordinates = new Coordinates(Integer.parseInt(roverinput[0]), Integer.parseInt(roverinput[1]));
            Rover rover = new Rover(direction, coordinates);

            LinkedHashSet<Command> roverCommands = new LinkedHashSet<>();
            String commandinput[] = inputs.get(1).split(" ");
            return new RoverCommands(rover, roverCommands);
        } catch (Exception e) {
            throw new MarsRoverException("invalid input for Rovers");
        }
    }
}
