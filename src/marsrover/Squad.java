package marsrover;

import java.util.ArrayList;

import marsrover.Rover;

public class Squad {
	private int limitX;
	private int limitY;
	
	ArrayList<Rover> rovers;
	public Squad(int limitX, int limitY) {
		this.limitX = limitX;
		this.limitY = limitY;
		this.rovers = new ArrayList<Rover>();
	}
	
	public Squad(ArrayList<Rover> rovers, int limitX, int limitY) {
		this.rovers.forEach(r -> r.setLimit(limitX, limitY));
		this.rovers = new ArrayList<Rover>(rovers);	
	}
	
	public void addRover(Rover rover) {
		rover.setLimit(this.limitX, this.limitY);
		this.rovers.add(rover);
	}
	
	public void removeRover(int index) {
		this.rovers.remove(index);
	}
}