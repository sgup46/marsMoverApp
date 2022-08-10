package com.unifyed.service.commands;

import com.unifyed.exception.MarsRoverException;
import com.unifyed.util.DIRECTION;
import com.unifyed.model.Plataeu;
import com.unifyed.model.Rover;
import com.unifyed.service.commands.Command.Command;
import org.springframework.stereotype.Component;

/**
 * The LeftCommand is an implementation of command for Left operations with the help of ordinal
 *
 * @author Sushant Gupta
 * 
 */
@Component("L")
public class LeftCommand implements Command {

    @Override
    public void execute(Rover rover, Plataeu plataeu) {
        DIRECTION direction = rover.getDirection();
        int index = rover.getDirection().ordinal();
        index = ((index - 1) >=0)? (index -1) : (direction.NO_OF_DIRECTIONS -1);
        direction = DIRECTION.values()[index];
        rover.setDirection(direction);
    }
}
