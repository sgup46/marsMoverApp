package com.unifyed.model;

import lombok.Data;
import lombok.ToString;

/**
 * The class is responsible to store the coordinates of rover
 * Can increment and decrement
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

	//Defining a copy constructor
	public Coordinates(Coordinates xy){
		this.xCoordinate = xy.getXCoordinate();
		this.yCoordinate = xy.getYCoordinate();
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

	public boolean validateCoordinate(){
		return ((xCoordinate >= 0) && (yCoordinate >=0))? true : false;
	}
}
