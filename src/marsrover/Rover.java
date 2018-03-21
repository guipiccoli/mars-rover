package marsrover;


public class Rover {
	private int x;
	private int y;
	
	private String[] directions;
	private int directionIndex;
	
	public int limitX;
	public int limitY;
	
	public Rover(int x, int y, String initialDirection) {
		directions = new String[] {"W", "N", "E", "S"};
		
		this.x = x;
		this.y = y;
		this.setDirection(initialDirection);
	}
	
	public void setLimit(int limitX, int limitY) {
		this.limitX = limitX;
		this.limitY = limitY;
	}
	
	
	private void setDirection(String initialDirection) {
		switch(initialDirection) {
			case "W": this.directionIndex = 0; break; //West
			case "N": this.directionIndex = 1; break; //North
			case "E": this.directionIndex = 2; break; //East
			case "S": this.directionIndex = 3; break; //South
		}	
	}
		
	public void sendCommands(String commands) {
		for (int i = 0; i < commands.length(); i++  ) {
			process(commands.charAt(i));
		}
	}
	
	private void process(Character command) {
		switch(command) {
			case 'L': this.turnLeft(); break;
			case 'R': this.turnRight(); break;
			case 'M': this.move(); break;
			default: throw new IllegalArgumentException("Comando inválido");
		}
	}
	
	private void move() {
		switch(this.directionIndex) {
			case 0: this.x--; break; //West
			case 1: this.y++; break; //North
			case 2: this.x++; break; //East
			case 3: this.y--; break; //South
		}
	}
	
	
	private void turnLeft() {
		if(this.directionIndex == 0) {
			this.directionIndex = 3;
		} else {
			this.directionIndex--;
		}
	}
	
	private void turnRight() {
		if(this.directionIndex == 3) {
			this.directionIndex = 0;
		} else {
			this.directionIndex++;
		}
	}
	
	public String getDirection() {
		return this.directions[this.directionIndex];
	}
	
	public String toString() {
		return this.x + " " + this.y + " " + this.directions[this.directionIndex];
	}
}
