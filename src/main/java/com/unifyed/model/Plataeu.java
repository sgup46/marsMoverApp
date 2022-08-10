package com.unifyed.model;

import com.unifyed.service.commands.Command.Command;
import lombok.Data;
import lombok.ToString;

import java.util.LinkedHashSet;

/**
 * 
 * Table is a singleton class. So it can be accessed from everywhere without instantiating. 
 * Table has length and breadth, which can be set. By default, length and breadth will be
 * set to 5.
 *  
 * Table provides methods to set it's size, get it's length and breadth and to check whether 
 * a (X,Y) co-ordinate lies within the table.
 * 
 * @author Sushant Gupta
 */

@Data
@ToString(callSuper=true, includeFieldNames=true)
public class Plataeu {

	private int width = 5;
	private int breadth = 5;

	private LinkedHashSet<Rover> rovers;

	public Plataeu(final int width, int breadth) {
		this.width = width;
		this.breadth = breadth;
	}
//	public boolean isOnTable(Coordinates xy)
//	{
//		int x = xy.getX();
//		int y = xy.getY();
//		return ((x<= width && x>=0) &&( y<=breadth && y>=0))?  true :  false;
//	}

}
