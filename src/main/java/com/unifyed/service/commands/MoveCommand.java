package com.unifyed.service.commands;

import com.unifyed.service.commands.Command.Command;

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
public class MoveCommand implements Command {
//	private Rover rover;
//	private String command;
//	private Coordinates newXYCoordinates;
//	private DIRECTIONS robotDirection;
//	static
//	{
//		Rover tempRobot = null;
//		CommandFactory.getInstance().registerCommand("MOVE", new MoveCommand(tempRobot, ""));
//	}
//  public MoveCommand(Rover robot, String command)
//  {
//	this.rover = robot;
//	this.command = command;
//  }
//
//  public String execute()
//  {
//	  if(rover != null && rover.isRobotPlaced())
//	  {
//		  newXYCoordinates = new Coordinates(rover.getCoordinates());
//		  robotDirection = rover.getDirection();
//		  newXYCoordinates = robotDirection.moveInDirection(newXYCoordinates);
//		  if(Plataeu.getInstance().isOnTable(newXYCoordinates))
//		  {
//		    rover.move();
//		  }
//	  }
//	return null;
//  }
//
//  public MoveCommand createCommandObject(Rover robot, String commandLine)
//	{
//		return new MoveCommand(robot, commandLine);
//	}
}
