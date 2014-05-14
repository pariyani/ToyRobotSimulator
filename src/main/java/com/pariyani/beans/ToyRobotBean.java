package com.pariyani.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.pariyani.exception.PositionOutOfBoundException;
import com.pariyani.faceshelper.FacesUtils;
import com.pariyani.robot.Facing;
import com.pariyani.robot.Position;
import com.pariyani.robot.ToyRobot;

/**
 * JSF BEAN: Test the toy robot functionality on the browser.
 * @author imran
 *
 */
@ManagedBean(name="toyBean")
@SessionScoped
public class ToyRobotBean  implements Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = -5710613376163963934L;
    
	private ToyRobot robot;
	
	private int x;
	
	private int y;
	
	private Facing facing;
	
    @PostConstruct
	public void initBean() {
    	robot = new ToyRobot();
	}
    
    public String place(){
    	try {
	        robot.place(new Position(x, y), facing);
        } catch (PositionOutOfBoundException e) {
        	FacesUtils.addMessage(null, FacesMessage.SEVERITY_ERROR, "place.invalid");
	        return null;
        }
    	return "/index.html?faces-redirect=true";
    }
    
    public String left(){
        robot.rotateLeft();
    	return "/index.html?faces-redirect=true";
    }
    
    public String right(){
        robot.rotateRight();
    	return "/index.html?faces-redirect=true";
    }
    
    public String move(){
    	try {
	        robot.move();
        } catch (PositionOutOfBoundException e) {
        	FacesUtils.addMessage(null, FacesMessage.SEVERITY_ERROR, "move.error");
	        return null;
        }
    	return "/index.html?faces-redirect=true";
    }

    public String getReport(){
    	return this.robot.report();
    }
    
    public void checkPosition(){
    	if (robot.getPosition()==null) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("place.html");
			} catch (IOException e) {
				FacesUtils.addMessage(null, FacesMessage.SEVERITY_ERROR, "exception.IOException");
			}
		}
    }
    
	public ToyRobot getRobot() {
    	return robot;
    }

	public void setRobot(ToyRobot robot) {
    	this.robot = robot;
    }

	public int getX() {
    	return x;
    }

	public void setX(int x) {
    	this.x = x;
    }

	public int getY() {
    	return y;
    }

	public void setY(int y) {
    	this.y = y;
    }

	public Facing getFacing() {
    	return facing;
    }

	public void setFacing(Facing facing) {
    	this.facing = facing;
    }
	
	public Facing[] getDirections() {
		return Facing.values();
	}
}
