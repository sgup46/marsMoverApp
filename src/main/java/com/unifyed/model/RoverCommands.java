package com.unifyed.model;

import com.unifyed.service.commands.Command.Command;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 
 * This class will encapsulate the rover in action and list of commands send by RASA
 *  
 * @author Sushant Gupta
 */

@Data
@ToString(callSuper=true, includeFieldNames=true)
public class RoverCommands {
	private Rover rover;
	private List<Command> roverCommands;

	public RoverCommands(final Rover rover, List<Command> roverCommands) {
		this.rover = rover;
		this.roverCommands = roverCommands;
	}

}
