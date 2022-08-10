package com.unifyed.util;

import com.unifyed.model.Coordinates;

/**
 * Rover Enum of direction
 * 
 * @author Sushant Gupta
 *
 */
public enum DIRECTION {
	N
	{
		public Coordinates moveInDirection(Coordinates xy){
			xy.incrementY();
			return xy;
		}
			
	},
	E
	{
		public Coordinates moveInDirection(Coordinates xy){
			xy.incrementX();
			return xy;
		}
	},
	S
	{
		public Coordinates moveInDirection(Coordinates xy){
			xy.decrementY();
			return xy;
		}
	},
	
	W
	{
		public Coordinates moveInDirection(Coordinates xy){
			xy.decrementX();
			return xy;
		}
	};

	public final int NO_OF_DIRECTIONS = 4;

	public abstract Coordinates moveInDirection(Coordinates xy);
}