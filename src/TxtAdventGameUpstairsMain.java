import java.util.Scanner;


public class TxtAdventGameUpstairsMain {
	int flagCheck3 = 0;
	int flagChest3 = 0;
	TxtAdventGameMainFloor mainFlrRef = new TxtAdventGameMainFloor();

	public void UpstairsMain(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		
		
		room = whereToGo[13][6];
		Scanner newScan = new Scanner(System.in);
		String directChoice;
		
		
		System.out.println("You are on the " + roomName[13]);
		System.out.println(" ");
		System.out.println("You see: Nothing");
		System.out.println(" ");
		System.out.println("You can go the following directions: ");
		System.out.println(" ");
		System.out.println(directions[5] + ", " + directions[2] + ", " + directions[3]);
		System.out.println(" ");
		System.out.println("Where do you want to go/what would you like to interact with?");
		System.out.println(" ");
		
		directChoice = newScan.next();

		directChoice = directChoice.substring(0, 1).toLowerCase();
		
		
		switch (directChoice) {
		
		case "i":
			room = whereToGo[13][6];
			mainFlrRef.invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
			break;
		case "e":
			mainFlrRef.endGame();
			break;
		case "w":
			mainFlrRef.endGame();
			break;
		case "d":
			mainFlrRef.MainFloorWCorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
			break;
			default:
			System.out.println("Unrecognized input.");	
			System.out.println(" ");
			room = whereToGo[13][6];
			UpstairsMain(room, roomName, whereToGo, directions, myStats, invo, flags);
			
		}
		newScan.close();
	}

}
