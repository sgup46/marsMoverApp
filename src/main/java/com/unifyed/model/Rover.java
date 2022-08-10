package com.unifyed.model;

import com.unifyed.util.DIRECTION;
import lombok.Data;
import lombok.ToString;

/**
 
 * This is the Rover , having the direction and cooridinates of Plateu
 *  
 * @author Sushant Gupta
 */

@Data
public class Rover {
	private DIRECTION direction;
	private Coordinates coordinates;
	public Rover(final DIRECTION direction, final Coordinates xycoordinates)
	{
		this.direction = direction;
		this.coordinates = xycoordinates;
	}

	@Override
	public String toString() {
		return coordinates.getXCoordinate() + " " + coordinates.getYCoordinate() + " " + direction.name();
	}


}
