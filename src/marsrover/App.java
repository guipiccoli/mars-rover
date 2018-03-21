package marsrover;

import java.util.ArrayList;

import marsrover.Plateau;
import marsrover.Rover;
import marsrover.Squad;;

public class App {
	public static void main(String[] args) {
		Plateau plateau = new Plateau(new int[] {5,5});
		ArrayList<Rover> rovers = new ArrayList<Rover>();
		Rover gesiel = new Rover(1, 2, "N");
		Rover gesiel2 = new Rover(4, 4, "E");
		rovers.add(gesiel);
		rovers.add(gesiel2);
		
		Squad squad = new Squad(rovers, plateau.getUpperRight()[0], plateau.getUpperRight()[1]);
		Rover gesiel3 = new Rover(0, 0, "N");
		squad.addRover(gesiel3);
		
		try {
			gesiel.sendCommands("LMLMLMLMM");
			gesiel2.sendCommands("MMMMMRMRRM");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(squad);
		}
		
		System.out.println(squad);
	}
}