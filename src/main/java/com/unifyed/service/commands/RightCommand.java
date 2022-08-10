package com.unifyed.service.commands;

import com.unifyed.model.Plataeu;
import com.unifyed.model.Rover;
import com.unifyed.service.commands.Command.Command;
import com.unifyed.service.commands.Command.CommandFactory;
import org.springframework.stereotype.Component;

/**
 * The RightCommand is an implementation of commandInterface, RoboCommands. This class takes care of 
 * calling the robot's method to turn "RIGHT". This class checks if the Robot is placed properly before
 * executing Robot's methods.
 *
 * @author Sharvari Nagesh
 * 
 */
@Component("R")
public class RightCommand implements Command {
    @Override
    public void execute(CommandFactory command, Rover rover, Plataeu plataeu) {

    }
//private Rover rover;
//
//static
//{
//	Rover tempRobot = null;
//	CommandFactory.getInstance().registerCommand("RIGHT", new RightCommand(tempRobot, ""));
//}
//	public RightCommand(Rover robot, String command)
//	{
//	   this.rover = robot;
//	}
//
//	public RightCommand createCommandObject(Rover robot, String commandLine)
//	{
//		return new RightCommand(robot, commandLine);
//	}
//
//	public String execute()
//	{
//		if(rover != null && rover.isRobotPlaced())
//		{
//			rover.turnRight();
//		}
//		return null;
//
//	}
}
