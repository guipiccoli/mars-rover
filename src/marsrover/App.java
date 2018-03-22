package marsrover;

import java.util.ArrayList;

import marsrover.Plateau;
import marsrover.Rover;
import marsrover.Squad;;

public class App {
	public static void main(String[] args) {
		Plateau plateau = new Plateau(new int[] {5,5});
		ArrayList<Rover> rovers = new ArrayList<Rover>();
		Rover r0 = new Rover(1, 2, "N");
		Rover r1 = new Rover(3, 3, "E");
		Rover r2 = new Rover(1, 1, "N");
		Rover r3 = new Rover (2,3, "S");
		rovers.add(r0);
		rovers.add(r1);
		
		Squad squad = new Squad(rovers, plateau.getUpperRight()[0], plateau.getUpperRight()[1]);
		squad.addRover(r2);
		squad.addRover(r3);
		
		try {
			r0.sendCommands("LMLMLMLMM");
			r1.sendCommands("MMMMMMMMM");
			r2.sendCommands("MMMMMMM");
			r3.sendCommands("MRMRMLM");
			System.out.println(squad);
		}
		catch(Exception e) {
			System.out.println(e.getMessage() + "\n");
		}
		finally {
			System.out.println(squad);
		}
		
		
	}
}