package com.unifyed.model;

import lombok.Data;
import lombok.ToString;

/**
 * 
 * This class defines X&Y Coordinates. This class is used to store X&Y coordinates of the Robot. 
 * It also provides functions to increment,decrement,set and get the coordinates. 
 * 
 * isCoordinatesSet() method will return false if the X & Y coordinate values are -ve.
 * Though Robot is allowed to have negative values for X &Y coordinates, isCoordinates() 
 * method considers it as not Set. This function is mainly used by the command control 
 * classes to check if X&Y are set to +ve Value.  
 * 
 * This class also has a copy constructor which helps in creating a copy of the object.
 * 
 * @author Sushant Gupta
 * 
 */
@Data
@ToString(callSuper=true, includeFieldNames=true)
public class Coordinates {
	private int xCoordinate, yCoordinate;
		
	public Coordinates(final int x, final int y)
	{
		xCoordinate = x;
		yCoordinate = y;
	}

	public void incrementX(){
		xCoordinate++;
	}
	public void incrementY(){
		yCoordinate++;
	}
	public void decrementX(){
		xCoordinate--;
	}
	public void decrementY(){
		yCoordinate--;
	}

//	public boolean isCoordinatesSet(){
//		return ((xCoordinate >= 0) && (yCoordinate >=0))? true : false;
//	}
}
