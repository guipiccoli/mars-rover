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
		for(Rover r : rovers) {
			r.setLimit(limitX, limitY);
		}
		
		this.rovers = new ArrayList<Rover>(rovers);	
	}
	
	public void addRover(Rover rover) {
		rover.setLimit(this.limitX, this.limitY);
		this.rovers.add(rover);
	}
	
	public void removeRover(int index) {
		this.rovers.remove(index);
	}
	
	public String toString() {
		String result = "";
		for(int i = 0; i < this.rovers.size(); i ++) {
			Rover r = this.rovers.get(i);
			result += "Rover: " + i + "\n";
			result += r.toString();
			result += "\n";
			result += "\n";
		}
		
		return result;
	}
}
