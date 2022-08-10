package com.unifyed.model;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Plataeu will store the rectangular coordinates
 * and will also store the rovers added by NASA
 * 
 * @author Sushant Gupta
 */

@Data
@ToString(callSuper=true, includeFieldNames=true)
public class Plataeu {

	private int xAxisValue = 5;
	private int yAxisValue = 5;

	// intialize with empty rovers
	private List<Rover> rovers = new ArrayList<>();

	public Plataeu(final int width, int breadth) {
		this.xAxisValue = width;
		this.yAxisValue = breadth;
	}

	public boolean canProceed(Coordinates xy)
	{
		int x = xy.getXCoordinate();
		int y = xy.getYCoordinate();
		return ((x<= xAxisValue && x>=0) &&( y<= yAxisValue && y>=0))?  true :  false;
	}

	public void addRover(Rover rover) {
		rovers.add(rover);
	}

	@Override
	public String toString() {
		return xAxisValue + " " + yAxisValue;
	}
}
