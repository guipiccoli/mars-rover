package marsrover;

public class Plateau {
	private int[] upperRight;
	private int[] lowerLeft;
	
	public Plateau(int[] upperRight) {
		this.setUpperRight(upperRight);
		this.setLowerLeft(new int[] {0, 0});
	}
	
	public Plateau(int[] upperRight, int[] lowerLeft) {
		this.setUpperRight(upperRight);
		this.setLowerLeft(lowerLeft);
	}
	
	private void setLowerLeft(int[] lowerLeft) {
		this.lowerLeft = lowerLeft;
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
		int base = this.upperRight[0] - this.lowerLeft[0];
		int height = this.upperRight[1] - this.lowerLeft[1];
		
		return base * height;
	}
	
	public String toString() {
		String result = "Upper Right - X:" + this.upperRight[0] + " Y:" + this.upperRight[1] + "\n";
		result += "Lower Left - X:" + this.lowerLeft[0] + " Y:" + this.lowerLeft[1];
		
		return result; 
	}
}
