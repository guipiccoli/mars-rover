package marsrover;

public class Plateau {
	private int[] upperRight;
	private int[] lowerLeft;
	
	public Plateau(int[] upperRight) {
		this.setUpperRight(upperRight);
		this.lowerLeft = new int[] {0, 0};
	}


	public void setUpperRight(int[] upperRight) {
		this.upperRight = upperRight;
	}
	
	public int[] getUpperRight() {
		return this.upperRight;
	}
	
	public int[] getLowerLeft() {
		return this.lowerLeft;
	}
	
	public int getArea() {
		return this.getWidth() * this.getHeight();
	}
	
	public int getWidth() {
		return this.upperRight[0] - this.lowerLeft[0]; 
	}
	
	public int getHeight() {
		return this.upperRight[1] - this.lowerLeft[1];
	}
	
	public String toString() {
		String result = "Upper Right - X:" + this.upperRight[0] + " Y:" + this.upperRight[1] + "\n";
		result += "Lower Left - X:" + this.lowerLeft[0] + " Y:" + this.lowerLeft[1];
		
		return result; 
	}
}
