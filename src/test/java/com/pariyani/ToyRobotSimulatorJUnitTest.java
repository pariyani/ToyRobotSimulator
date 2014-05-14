package com.pariyani;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.pariyani.exception.PositionOutOfBoundException;
import com.pariyani.robot.Facing;
import com.pariyani.robot.Position;
import com.pariyani.robot.ToyRobot;

/**
 * Test class to test the robot functionality. 
 * @author imran
 *
 */
public class ToyRobotSimulatorJUnitTest{

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	private ToyRobot robot;

	@Before
	public void setUp() throws Exception {
		this.robot = new ToyRobot();
	}

	@Test
	public void testSenarioA() {
		try {
	        robot.place(new Position(0, 0), Facing.NORTH);
	        robot.move();
			Assert.assertEquals(robot.report(), "0,1,NORTH");
        } catch (PositionOutOfBoundException e) {
        	e.printStackTrace();
        }
	}
	
	@Test
	public void testSenarioB() {
		try {
			robot.place(new Position(0, 0), Facing.NORTH);
			robot.rotateLeft();
			Assert.assertEquals(robot.report(), "0,0,WEST");
        } catch (PositionOutOfBoundException e) {
        	e.printStackTrace();
        }
	}
	
	@Test
	public void testSenarioC() {
		try {
			robot.place(new Position(1, 2), Facing.EAST);
			robot.move();
			robot.move();
			robot.rotateLeft();
			robot.move();
			Assert.assertEquals(robot.report(), "3,3,NORTH");
        } catch (PositionOutOfBoundException e) {
        	e.printStackTrace();
        }
	}
	
	@Test
	public void testSenarioD() {
		try {
			robot.place(new Position(1, 4), Facing.NORTH);
			robot.move();
			robot.move();
	        exception.expect(PositionOutOfBoundException.class);
        } catch (PositionOutOfBoundException e) {
        }
	}
}