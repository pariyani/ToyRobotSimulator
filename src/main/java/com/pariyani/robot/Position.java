package com.pariyani.robot;

import com.pariyani.exception.PositionOutOfBoundException;

/**
 * @author imran
 *
 */
public class Position {
	int x;
	int y;
	
	/**
	 * @param x
	 * @param y
	 * @throws PositionOutOfBoundException
	 */
	public Position(int x,int y) throws PositionOutOfBoundException{
		checkBounds(x, y);
		this.x=x;
		this.y=y;
	}

	/**
	 * Based on the direction  x y co-ordinates are passed to this method from {@link ToyRobot}. This method moves the robot in the desired direction.
	 * @param x
	 * @param y
	 * @throws PositionOutOfBoundException
	 */
	public void move(int x, int y) throws PositionOutOfBoundException {
		int newX = this.x+x;
		int newY = this.y+y;
		checkBounds(newX, newY);
		
		this.x = newX;
		this.y = newY;
    }
	
	/**
	 * Check if the movement is within the allowed limit. If it goes over the limit it throws {@link PositionOutOfBoundException}
	 * @param x
	 * @param y
	 * @throws PositionOutOfBoundException
	 */
	private void checkBounds(int x,int y) throws PositionOutOfBoundException{
		if (x > TableTop.MAXIMUM_X || x < 0 || y > TableTop.MAXIMUM_Y || y < 0)
            throw new PositionOutOfBoundException();
	}
}
