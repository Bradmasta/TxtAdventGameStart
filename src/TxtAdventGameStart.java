import java.util.*;
public class TxtAdventGameStart {
	
	public static void main(String[] args) {
		
		String newPlayer;
		
		Scanner newScan = new Scanner(System.in);
		System.out.println("Enter your name >> ");
		newPlayer = newScan.next();
		System.out.println(" ");
		System.out.println("Welcome " + newPlayer + "! Your adventure begins now! Best of luck!");
		
		TxtAdventGameMainFloor newGame = new TxtAdventGameMainFloor();
		newGame.StartGame(newPlayer);
		newScan.close();
	}

}
