import java.util.Scanner;


public class TxtAdventGameBasement {
	TxtAdventGameMainFloor mainFlrRef = new TxtAdventGameMainFloor();
	public void TxtAdventGameBasement() {
		
		
	}
	public void BasementMain(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		
		
		room = whereToGo[4][6];
		Scanner newScan = new Scanner(System.in);
		String directChoice;
		
		
		System.out.println("You are on the " + roomName[4]);
		System.out.println(" ");
		System.out.println("You see: Nothing");
		System.out.println(" ");
		System.out.println("You can go the following directions: ");
		System.out.println(" ");
		System.out.println(directions[2] + ", " + directions[3]+ ", " + directions[4]);
		System.out.println(" ");
		System.out.println("Where do you want to go/what would you like to interact with?");
		System.out.println(" ");
		
		directChoice = newScan.next();

		directChoice = directChoice.substring(0, 1).toLowerCase();
		
		
		switch (directChoice) {
		
		case "i":
			room = whereToGo[4][6];
			mainFlrRef.invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
			break;
		case "e":
			mainFlrRef.endGame();
			break;
		case "w":
			mainFlrRef.endGame();
			break;
		case "u":
			mainFlrRef.MainFloorECorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
			break;
			default:
			System.out.println("Unrecognized input.");	
			System.out.println(" ");
			room = whereToGo[4][6];
			BasementMain(room, roomName, whereToGo, directions, myStats, invo, flags);
			
		}
	}

}
