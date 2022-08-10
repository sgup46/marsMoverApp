package com.unifyed.util;

import com.unifyed.model.Coordinates;

/**
 * Robot directions are defined in the enum DIRECTIONS. This way, directions are predefined.
 * Randrom values can not be assigned to enum variables. enum makes it easy to add new directions
 * in future. For adding new directions, the only file which needs to be touched is DIRECTIONS.java.
 * If NORTHEAST has to be added as a direction, add it in between NORTH AND EAST enums and define
 * a proper moveInDirection() method. and update NOOFDIRECTIONS.
 * 
 * ENUMs were introduced from Java 1.5. So this program is not compatible with java older than version 1.5
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