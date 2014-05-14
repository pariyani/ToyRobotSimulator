package com.pariyani;

import java.util.Scanner;

import com.pariyani.exception.PositionOutOfBoundException;
import com.pariyani.robot.Facing;
import com.pariyani.robot.Position;
import com.pariyani.robot.TableTop;
import com.pariyani.robot.ToyRobot;

/**
 * @author imran
 *
 */
public class ToyRobotSimulatorCommandLine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ToyRobot robot = new ToyRobot();
		Scanner in = new Scanner(System.in);
		String command = null;
		while (true) {
			command = in.nextLine();
			if (command.equalsIgnoreCase("exit") || command.equalsIgnoreCase("e") || command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("q"))
				break;
			if(robot.getPosition()==null && !command.trim().toLowerCase().startsWith("place")){
				System.out.println("Please initialize the Robot first by executing PLACE command");
			}else if (command.trim().toLowerCase().startsWith("place")) {
				String[] commands = command.split(" ");
				if(commands.length==2){
					String[] parameters = commands[1].split(",");
					if(parameters.length==3){
						try{
							int x = Integer.parseInt(parameters[0].trim());
							int y = Integer.parseInt(parameters[1].trim());
							Facing facing = Facing.valueOf(parameters[2].trim().toUpperCase());
							robot.place(new Position(x, y), facing);
						}catch(NumberFormatException e){
							System.out.println("PLACE command is invalid! Command PLACE should be followed by x co-ordinate then comma then y co-ordinate then comma and then direction. For e.g PLACE 0,0,NORHT" );
						}catch(IllegalArgumentException e){
							System.out.println("Only one of the following directions are allowed: NORTH,SOUTH,EAST,WEST");
						} catch (PositionOutOfBoundException e) {
							System.out.println("Initial position is outside the grid. It can't be more then "+TableTop.MAXIMUM_X+","+TableTop.MAXIMUM_Y);
                        }
					}else
						System.out.println("Place command is invalid! Command PLACE should be followed by x co-ordinate then comma then y co-ordinate then comma and then direction. For e.g PLACE 0,0,NORHT" );
				}else{
					System.out.println("Place command is invalid! Command PLACE should be followed by x co-ordinate then comma then y co-ordinate then comma and then direction. For e.g PLACE 0,0,NORHT" );
				}
			}else {
	            try {
	            	command = command.trim().toLowerCase();
	            	if(command.equals("move") || command.equals("m"))
	            		robot.move();
	            	else if(command.equals("left") || command.equals("l"))
	            		robot.rotateLeft();
	            	else if(command.equals("right") || command.equals("r"))
	            		robot.rotateRight();
	            	else if(command.equals("report") || command.equals("p"))//Print
	            		System.out.println(robot.report());
	            	else
	            		System.out.println("Invalid command!.");
                } catch (PositionOutOfBoundException e) {
	                System.out.println("cannot move in this direction as it has reached the end!");
                }
			}
		}
	}
}
