package marsrover;


public class Rover {
	public static final int N = 1;
	public static final int E = 2;
	public static final int S = 3;
	public static final int W = 4;
	int x = 0;
	int y = 0;
	int face = N;
	public Rover() {
	}
	public void setPosition(int x, int y, int facing) {
		this.x = x;
		this.y = y;
		this.face = facing;
	}
	public void printPosition() {
		char dir = 'N';
		if (face == 1) {
			dir = 'N';
		} else if (face == 2) {
			dir = 'E';
		} else if (face == 3) {
			dir = 'S';
		} else if (face == 4) {
			dir = 'W';
		}
		System.out.println(x +  " "  + y  + " " +  dir);
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
		if (face == N) {
			this.y++  ;
		} else if (face == E) {
			this.x++  ;
		} else if (face == S) {
			this.y--;
		} else if (face == W) {
			this.x--;
		}
	}
	private void turnLeft() {
		face = (face - 1) < N ? W : face - 1;
	}
	private void turnRight() {
		face = (face +  1) > W ? N : face +  1;
	}
}
