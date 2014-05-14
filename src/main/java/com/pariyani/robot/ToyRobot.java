package com.pariyani.robot;

import com.pariyani.exception.PositionOutOfBoundException;

/**
 * @author imran
 *
 */
public class ToyRobot{
	
	/**
	 * Current position on the TableTop
	 */
	private Position	position;
	
	/**
	 * Current direction
	 */
	private Facing	 facing;

	/**
	 * @param position
	 * @param facing
	 */
	public void place(final Position position, final Facing facing) {
		this.position = position;
		this.facing = facing;
	}

	/**
	 * move the robot one sted in the direction it is facing.
	 * @throws PositionOutOfBoundException
	 */
	public void move() throws PositionOutOfBoundException {
		switch (facing) {
			case NORTH:
				position.move(0, 1);
				break;
			case EAST:
				position.move(1, 0);
				break;
			case SOUTH:
				position.move(0, -1);
				break;
			case WEST:
				position.move(-1, 0);
				break;
		}
	}

	/**
	 * Rotates the robot by 90 degrees on right side
	 */
	public void rotateRight() {
		switch (facing) {
			case NORTH:
				facing = Facing.EAST;
				break;
			case EAST:
				facing = Facing.SOUTH;
				break;
			case SOUTH:
				facing = Facing.WEST;
				break;
			case WEST:
				facing = Facing.NORTH;
				break;
			default:
				break;
		}
	}

	/**
	 * Rotates the robot by 90 degrees on reft side
	 */
	public void rotateLeft() {
		switch (facing) {
			case NORTH:
				facing = Facing.WEST;
				break;
			case WEST:
				facing = Facing.SOUTH;
				break;
			case SOUTH:
				facing = Facing.EAST;
				break;
			case EAST:
				facing = Facing.NORTH;
				break;
			default:
				break;
		}
	}

	/**
	 * @return {@link Position}
	 */
	public Position getPosition() {
    	return position;
    }

	/**
	 * @return {@link Facing}
	 */
	public Facing getFacing() {
    	return facing;
    }

	/**
	 * @return {@link String} return the x,y co-ordinates and the present direction.
	 */
	public String report() {
		return this.position.x+","+this.position.y+","+this.facing.toString();
    }
}
