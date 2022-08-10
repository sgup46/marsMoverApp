package com.unifyed.service.commands;

import com.unifyed.exception.MarsRoverException;
import com.unifyed.model.Coordinates;
import com.unifyed.model.Plataeu;
import com.unifyed.model.Rover;
import com.unifyed.service.commands.Command.Command;
import com.unifyed.service.commands.Command.CommandFactory;
import org.springframework.stereotype.Component;

/**
 * The moveCommand is an implementation of command for move operations and will change the coordinates
 *
 * @author Sushant Gupta
 *
 */
@Component("M")
public class MoveCommand implements Command {

    @Override
    public void execute(Rover rover, Plataeu plataeu) {
        Coordinates newCoordinates = new Coordinates(rover.getCoordinates());
        newCoordinates = rover.getDirection().moveInDirection(newCoordinates);
        if (plataeu.canProceed(newCoordinates)) {
            rover.setCoordinates(newCoordinates);
        } else {
            throw new MarsRoverException("Unable to place rover:" + rover + " on new coordinates: " +
                    newCoordinates + " having plateu: " + plataeu);
        }
    }

}
