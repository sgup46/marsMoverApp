package com.unifyed.model;

import com.unifyed.service.commands.Command.Command;
import lombok.Data;
import lombok.ToString;

import java.util.LinkedHashSet;

/**
 
 * This is the Robot class which will define the actual Robot. The Robot can be placed, 
 * it can move, turn RIGHT or LEFT. The Robot can also report it's position. A Robot's 
 * position is stored in XY coordinates which will be set when Robot is placed on a Table. 
 * Robot has a DIRECTION, which indicates the direction in which it is facing. When Robot
 * is made to move, it moves in the direction it is facing.
 *  
 * @author Sushant Gupta
 */

@Data
@ToString(callSuper=true, includeFieldNames=true)
public class RoverCommands {
	private Rover rover;
	private LinkedHashSet<Command> roverCommands;

	public RoverCommands(final Rover rover, LinkedHashSet<Command> roverCommands) {
		this.rover = rover;
		this.roverCommands = roverCommands;
	}

}
