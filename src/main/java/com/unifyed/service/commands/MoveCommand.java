package com.unifyed.service.commands;

import com.unifyed.exception.MarsRoverException;
import com.unifyed.model.Coordinates;
import com.unifyed.model.Plataeu;
import com.unifyed.model.Rover;
import com.unifyed.service.commands.Command.Command;
import com.unifyed.service.commands.Command.CommandFactory;
import org.springframework.stereotype.Component;

/**
 * MoveCommand implements the RoboCommands interface. It takes care of calling the move function of the
 * Robot. Before calling the Robot's move function, this class makes sure, the new move is within the table,
 * and Robot is properly initialized and placed on the table.
 *  
 * To make sure the move is within the table, the class gets a copy of xy Coordinates of the Robot, moves
 * the robot in the direction it is facing and checks if the new XY coordinate lies within the Table.
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
