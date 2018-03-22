package marsrover;


public class Rover {
	private int x;
	private int y;
	
	private String[] directions;
	private int directionIndex;
	
	public int limitX;
	public int limitY;
	
	public boolean movementError = false;
	
	public Rover(int x, int y, String initialDirection) {
		directions = new String[] {"W", "N", "E", "S"};
		
		this.x = x;
		this.y = y;
		this.setDirection(initialDirection);
	}
	
	
	public int [] getPosition() {
		int[] direction =  new int [2];
		direction [0] = this.x;
		direction [1] = this.y;
		return direction;
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
		int initialX = this.x;
		int initialY = this.y;
		int initialDirectionIndex = this.directionIndex;

		for (int i = 0; i < commands.length(); i++ ) {
			process(commands.charAt(i));
		}
		
		if(this.movementError) {
			this.x = initialX;
			this.y = initialY;
			this.directionIndex = initialDirectionIndex;
			
			throw new IllegalArgumentException("Movimentação inválida em algum Robo. Ele voltará a sua posição de origem!! ");
		}
	}
	
	private void process(Character command) {
		switch(command) {
			case 'L': this.turnLeft(); break;
			case 'R': this.turnRight(); break;
			case 'M': this.move(); break;
			default: this.movementError = true;
		}
	}
	
	private void move() {
		if(this.directionIndex == 0) {
			if(this.x>=1) 
				this.x--; 
			else
				this.movementError = true;
		}
		
		else if(directionIndex == 1) {
			if(this.limitY > y)
				this.y++; 
			else 
				this.movementError = true;
		}
		
		else if(directionIndex == 2) {
			if(this.limitX > x)
				this.x++; 
			else
				this.movementError = true;
		}
		
		else if(directionIndex == 3) {
			if(this.y>=1)
				this.y--; 
			else 
				this.movementError = true;
		}
		
		else {
			this.movementError = true;
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
