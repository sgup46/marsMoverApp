package com.unifyed.service.commands;

import com.unifyed.model.Plataeu;
import com.unifyed.model.Rover;
import com.unifyed.service.commands.Command.Command;
import com.unifyed.service.commands.Command.CommandFactory;
import org.springframework.stereotype.Component;

/**
 * The LeftCommand is an implementation of commandInterface, RoboCommands. This class takes care of 
 * calling the robot's method to turn "LEFT". This class checks if the Robot is placed properly before
 * executing Robot's methods.
 *
 * @author Sharvari Nagesh
 * 
 */
@Component("L")
public class LeftCommand implements Command {
    @Override
    public void execute(CommandFactory command, Rover rover, Plataeu plataeu) {

    }
//private Rover rover;
//
//static
//{
//	Rover tempRobot = null;
//	CommandFactory.getInstance().registerCommand("LEFT", new LeftCommand(tempRobot, ""));
//}
//    public LeftCommand(Rover robot, String commandLine)
//    {
//    	this.rover = robot;
//    }
//	public String execute()
//	{
//		if(rover != null && rover.isRobotPlaced())
//		{
//			rover.turnLeft();
//		}
//		return null;
//	}
//
//	public LeftCommand createCommandObject(Rover robot, String commandLine)
//	{
//		return new LeftCommand(robot, commandLine);
//	}
}
