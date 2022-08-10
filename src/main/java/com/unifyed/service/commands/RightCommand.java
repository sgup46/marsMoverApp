package com.unifyed.service.commands;

import com.unifyed.model.Plataeu;
import com.unifyed.model.Rover;
import com.unifyed.service.commands.Command.Command;
import com.unifyed.util.DIRECTION;
import org.springframework.stereotype.Component;

/**
 * The RightCommand is an implementation of commandInterface, RoboCommands. This class takes care of 
 * calling the robot's method to turn "RIGHT". This class checks if the Robot is placed properly before
 * executing Robot's methods.
 *
 * @author Sushant
 * 
 */
@Component("R")
public class RightCommand implements Command {

    @Override
    public void execute(Rover rover, Plataeu plataeu) {
        DIRECTION direction = rover.getDirection();
        int index = rover.getDirection().ordinal();
        index = (index + 1) % direction.NO_OF_DIRECTIONS;
        direction = DIRECTION.values()[index];
        rover.setDirection(direction);
    }

}
