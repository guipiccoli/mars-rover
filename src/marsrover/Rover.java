package marsrover;


public class Rover {
	int x = 0;
	int y = 0;
	String face = "N";
	public Rover() {
	}
	public void setPosition(int x, int y, String facing) {
		this.x = x;
		this.y = y;
		this.face = facing;
	}
	public void printPosition() {
		System.out.println(x +  " "  + y  + " " +  face);
	}
	public void process(String commands) {
		for (int i = 0; i < commands.length(); i++  ) {
			process(commands.charAt(i));
		}
	}
	private void process(Character command) {
		if (command.equals('L')) {
			turnLeft();
		} else if (command.equals('R')) {
			turnRight();
		} else if (command.equals('M')) {
			move();
		} else {
			throw new IllegalArgumentException("Comando inválido");
		}
	}
	private void move() {
		if (face.equals("N")) {
			this.y++  ;
		} else if (face.equals("E")) {
			this.x++  ;
		} else if (face.equals("S")) {
			this.y--;
		} else if (face.equals("W")) {
			this.x--;
		}
	}
	private void turnLeft() {
		face = (face - 1) < "N" ? "W" : face - 1;
	}
	private void turnRight() {
		face = (face +  1) > "W" ? "N" : face +  1;
	}
}
