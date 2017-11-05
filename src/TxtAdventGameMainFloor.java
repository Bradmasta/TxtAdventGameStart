import java.util.*;
public class TxtAdventGameMainFloor {
	String roomName[] = {"MainHall", "North Corridor", "East Corridor", "West Corridor", "Basement Main", "Eastern Room"
			,"North-Eastern Room", "North-West Hall", "North-West Northern Room", "North-West Western Room", "North-West Southern Room"
			, "West Northern Room", "West Southern Room", "Upstairs Main"};
	int whereToGo[][] = {{1, -1, 2, 3, -1, -1, 0}, {-1, 0, 6, 7, -1, -1, 1}, {-1, -1, 5, 0, -1, 4, 2}, {11, 12, 0, -1, 13, -1, 3}, {-1, -1, -1, -1, 2, -1, 4},
	{-1, -1, -1, -1, 2, -1, 5}, {-1, -1, -1, 1, -1, -1, 6}, {8, 10, 1, 9, -1, -1, 7}, {-1, 7, -1, -1, -1, -1, 8}, {-1, -1, 7, -1, -1, -1, 9},
	{7, -1, -1, -1, -1, -1, 10}, {-1, 3, -1, -1, -1, -1, 11}, {3, -1, -1, -1, -1, -1, 12}, {-1, -1, -1, -1, -1, 3, 13}};
	String[] directions = {"North", "South", "East", "West", "Up", "Down", "Remain"};
	
	
	
	int room = whereToGo[0][6];
	int myStats[] = {50, 7, 5, 7};
	int invo[] = {2, 0, 0 , 0, 0, 0, 0};
	int flags[] = {0, 0, 0, 0, 0, 0, 0, 0};
	
	
	
		public void StartGame(String input) {
			
			
			
			MainHall(room, roomName, whereToGo, directions, myStats, invo, flags);
			
		}
		public void MainHall(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
			
	
			room = whereToGo[0][6];
			Scanner newScan = new Scanner(System.in);
			String directChoice;
			
			System.out.println("You are in the " + roomName[0]);
			System.out.println(" ");
			System.out.println("You see: Nothing");
			System.out.println(" ");
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[0] + ", " + directions[1] + ", " + directions[2] + ", " + directions[3]);
			System.out.println(" ");
			System.out.println("Where do you want to go/what would you like to interact with?");
			System.out.println(" ");
			
			directChoice = newScan.next();
	
			directChoice = directChoice.substring(0, 1).toLowerCase();
			
		
			switch (directChoice) {
			
			case "i":
				room = whereToGo[0][6];
				invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "n":
				room = whereToGo[0][0];
				MainFloorNCorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			
			case "s":
				room = whereToGo[0][0];
				System.out.println("The door to the outside is locked.");
				System.out.println(" ");
				MainHall(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "e":
				room = whereToGo[0][2];
				MainFloorECorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "w":
				room = whereToGo[0][3];
				MainFloorWCorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "u":
				System.out.println("You can't go " + directions[4] + "!");
				System.out.println(" ");
				room = whereToGo[0][6];
				MainHall(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "d":
				System.out.println("You can't go " + directions[5] + "!");
				System.out.println(" ");
				room = whereToGo[0][6];
				MainHall(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				System.out.println("Unrecognized input.");	
				System.out.println(" ");
				room = whereToGo[0][6];
				MainHall(room, roomName, whereToGo, directions, myStats, invo, flags); 
				 
			}
	}			

		public void MainFloorNCorridor(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
			// DONE.
			room = whereToGo[1][6];
			Scanner newScan = new Scanner(System.in);
			String directChoice;
			
			System.out.println("You are in the " + roomName[1]);
			System.out.println(" ");
			System.out.println("You see: Nothing");
			System.out.println(" ");
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[1] + ", " + directions[2] + ", " + directions[3]);
			System.out.println(" ");
			System.out.println("Where do you want to go/what would you like to interact with?");
			System.out.println(" ");
			
			directChoice = newScan.next();
			
			directChoice = directChoice.substring(0, 1).toLowerCase();
			
			switch (directChoice) {
			case "i":
				room = whereToGo[1][6];
				invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "n":
				System.out.println("You can't go " + directions[0] + "!");
				System.out.println(" ");
				room = whereToGo[1][6];
				MainFloorNCorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			
			case "s":
				room = whereToGo[1][1];
				MainHall(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			
			case "e":
				room = whereToGo[1][2];
				MainNERoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "w":
				room = whereToGo[1][3];
				MainNWHall(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "u":
				System.out.println("You can't go " + directions[4] + "!");
				System.out.println(" ");
				room = whereToGo[1][6];
				MainFloorNCorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			
			case "d":
				System.out.println("You can't go " + directions[5] + "!");
				System.out.println(" ");
				room = whereToGo[1][6];
				MainFloorNCorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			
				default:
				System.out.println("Unrecognized input.");	
				System.out.println(" ");
				room = whereToGo[1][6];
				MainFloorNCorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				
			}
	   
   }
		public void MainFloorECorridor(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
			// DONE.
			room = whereToGo[2][6];
			Scanner newScan = new Scanner(System.in);
			String directChoice;
			
			System.out.println("You are in the " + roomName[2]);
			System.out.println(" ");
			System.out.println("You see: A trapdoor");
			System.out.println(" ");
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[2] + ", " + directions[3] + ", " + directions[5]);
			System.out.println(" ");
			System.out.println("Where do you want to go/what would you like to interact with?");
			System.out.println(" ");
			
			directChoice = newScan.next();
			
			directChoice = directChoice.substring(0, 1).toLowerCase();
			
			switch (directChoice) {
			case "i":
				room = whereToGo[2][6];
				invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "n":
				System.out.println("You can't go " + directions[0] + "!");
				System.out.println(" ");
				room = whereToGo[2][6];
				MainFloorECorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "s":
				System.out.println("You can't go " + directions[1] + "!");
				System.out.println(" ");
				room = whereToGo[2][6];
				MainFloorECorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "t":
				if(invo[4] == 1 && flags[2] == 0) {
				System.out.println("You open the trapdoor!");
				System.out.println(" ");
				flags[2] = 1;
				room = whereToGo[1][6];
				MainFloorECorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				}
				else if (flags[2] == 1) {
				System.out.println("You already opened the trapdoor! You can go down it now!");
				System.out.println(" ");
				room = whereToGo[1][6];
				MainFloorECorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
				else {
				System.out.println("You don't have the key to open this yet.");
				System.out.println(" ");
				room = whereToGo[1][6];
				MainFloorECorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
				break;
			case "d":
				if(flags[2] == 0) {
				System.out.println("You haven't opened this door yet.");
				System.out.println(" ");
				room = whereToGo[2][6];
				MainFloorECorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
				else {
					room = whereToGo[2][5];
				TxtAdventGameBasement baseFloor = new TxtAdventGameBasement();
				baseFloor.BasementMain(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
				break;
				
			
			case "e":
				room = whereToGo[2][2];
				MainERoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "w":
				room = whereToGo[2][3];
				MainHall(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "u":
				System.out.println("You can't go " + directions[4] + "!");
				System.out.println(" ");
				room = whereToGo[2][6];
				MainFloorECorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				System.out.println("Unrecognized input.");	
				System.out.println(" ");
				room = whereToGo[2][6];
				MainFloorECorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				
			}
	   
   }
		public void MainFloorWCorridor(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
			
			room = whereToGo[3][6];
			Scanner newScan = new Scanner(System.in);
			String directChoice;

			System.out.println("You are in the " + roomName[3]);
			System.out.println(" ");
			System.out.println("You see: A Locked Door");
			System.out.println(" ");
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[0] + ", " + directions[1] + ", " + directions[2] + ", " + directions[4]);
			System.out.println(" ");
			System.out.println("Where do you want to go/what would you like to interact with?");
			System.out.println(" ");
			
			directChoice = newScan.next();
			
			directChoice = directChoice.substring(0, 1).toLowerCase();
			
			switch (directChoice) {
			case "i":
				room = whereToGo[3][6];
				invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "n":
				room = whereToGo[3][0];
				MainWNRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "s":
				room = whereToGo[3][1];
				MainWSRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			
			case "e":
				room = whereToGo[3][2];
				MainHall(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "w":
				System.out.println("You can't go " + directions[3] + "!");
				System.out.println(" ");
				room = whereToGo[3][6];
				MainFloorWCorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "u":
				if (invo[5] == 1) {
					System.out.println("You opened the door to the upstairs!");
					System.out.println(" ");
					flags[3] = 1;
					room = whereToGo[3][6];
					MainFloorWCorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
				else if (flags[3] == 1) {
				room = whereToGo[3][4];
				TxtAdventGameUpstairsMain upFloor = new TxtAdventGameUpstairsMain();
				upFloor.UpstairsMain(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
				else {
					System.out.println("You haven't unlocked this yet!");
					System.out.println(" ");
					room = whereToGo[3][6];
					MainFloorWCorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
				break;
			case "d":
				System.out.println("You can't go " + directions[5] + "!");
				System.out.println(" ");
				room = whereToGo[3][6];
				MainFloorWCorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				System.out.println("Unrecognized input.");	
				System.out.println(" ");
				room = whereToGo[3][6];
				MainFloorWCorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				
			}
	   
   }
		public void MainERoom(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
			// DONE.
			room = whereToGo[5][6];
			Scanner newScan = new Scanner(System.in);
			String directChoice;
			Random newRand = new Random();
			int encChance = newRand.nextInt(9) + 1;
			
			System.out.println("You are in the " + roomName[5]);
			System.out.println(" ");
			if (encChance < 3) {
				System.out.println("A Dark Knight appears!");
				System.out.println(" ");
				TxtAdventGameEasyEnc newEnc = new TxtAdventGameEasyEnc();
				newEnc.randEncounterEasy(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			else {
			System.out.println("You see: Nothing");
			System.out.println(" ");
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[3]);
			System.out.println(" ");
			System.out.println("Where do you want to go/what would you like to interact with?");
			System.out.println(" ");
			
			directChoice = newScan.next();
			
			directChoice = directChoice.substring(0, 1).toLowerCase();
			
			switch (directChoice) {
			case "i":
				room = whereToGo[5][6];
				invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "n":
				System.out.println("You can't go " + directions[0] + "!");
				System.out.println(" ");
				room = whereToGo[5][6];
				MainERoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "s":
				System.out.println("You can't go " + directions[1] + "!");
				System.out.println(" ");
				room = whereToGo[5][6];
				MainERoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "e":
				System.out.println("You can't go " + directions[2] + "!");
				System.out.println(" ");
				room = whereToGo[5][6];
				MainERoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "w":
				room = whereToGo[5][3];
				MainFloorECorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "u":
				System.out.println("You can't go " + directions[4] + "!");
				System.out.println(" ");
				room = whereToGo[5][6];
				MainERoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "d":
				System.out.println("You can't go " + directions[5] + "!");
				System.out.println(" ");
				room = whereToGo[5][6];
				MainERoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				System.out.println("Unrecognized input.");	
				System.out.println(" ");
				room = whereToGo[5][6];
				MainERoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				
			}
		}
   }
	public void MainNERoom(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
			// DONE.
			room = whereToGo[6][6];
			Scanner newScan = new Scanner(System.in);
			String directChoice;
			Random newRand = new Random();
			int encChance = newRand.nextInt(9) + 1;
			

			System.out.println("You are in the " + roomName[6]);
			System.out.println(" ");
			if (encChance < 3) {
				System.out.println("A Dark Knight appears!");
				System.out.println(" ");
				TxtAdventGameEasyEnc newEnc = new TxtAdventGameEasyEnc();
				newEnc.randEncounterEasy(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			else {
			System.out.println("You see: Nothing");
			System.out.println(" ");
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[3]);
			System.out.println(" ");
			System.out.println("Where do you want to go/what would you like to interact with?");
			System.out.println(" ");
			
			directChoice = newScan.next();
			
			directChoice = directChoice.substring(0, 1).toLowerCase();
			
			switch (directChoice) {
			case "i":
				room = whereToGo[6][6];
				invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "n":
				System.out.println("You can't go " + directions[0] + "!");
				System.out.println(" ");
				room = whereToGo[6][6];
				MainNERoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "s":
				System.out.println("You can't go " + directions[1] + "!");
				System.out.println(" ");
				room = whereToGo[6][6];
				MainNERoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "e":
				System.out.println("You can't go " + directions[2] + "!");
				System.out.println(" ");
				room = whereToGo[6][6];
				MainNERoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "w":
				room = whereToGo[6][3];
				MainFloorNCorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "u":
				System.out.println("You can't go " + directions[4] + "!");
				System.out.println(" ");
				room = whereToGo[6][6];
				MainERoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "d":
				System.out.println("You can't go " + directions[5] + "!");
				System.out.println(" ");
				room = whereToGo[6][6];
				MainERoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				System.out.println("Unrecognized input.");	
				System.out.println(" ");
				room = whereToGo[6][6];
				MainNERoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				
			}
		}
   }
		public void MainNWHall(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
			// DONE.
			room = whereToGo[7][6];
			Scanner newScan = new Scanner(System.in);
			String directChoice;
			Random newRand = new Random();
			int encChance = newRand.nextInt(9) + 1;

			
	
			System.out.println("You are in the " + roomName[7]);
			System.out.println(" ");
			if (encChance < 3) {
				System.out.println("A Dark Knight appears!");
				System.out.println(" ");
				TxtAdventGameEasyEnc newEnc = new TxtAdventGameEasyEnc();
				newEnc.randEncounterEasy(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			else {
			System.out.println("You see: Nothing");
			System.out.println(" ");
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[0] + ", " +directions[1] + ", " + directions[2] + ", " + directions[3]);
			System.out.println(" ");
			System.out.println("Where do you want to go/what would you like to interact with?");
			System.out.println(" ");
			
			directChoice = newScan.next();
			
			directChoice = directChoice.substring(0, 1).toLowerCase();
			
			switch (directChoice) {
			case "i":
				room = whereToGo[7][6];
				invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			
			case "n":
				room = whereToGo[7][0];
				MainNWNRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			
			case "s":
				room = whereToGo[7][1];
				MainNWSRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "e":
				room = whereToGo[7][2];
				MainFloorNCorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "w":
				room = whereToGo[7][3];
				MainNWWRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "u":
				System.out.println("You can't go " + directions[4] + "!");
				System.out.println(" ");
				room = whereToGo[7][6];
				MainNWHall(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "d":
				System.out.println("You can't go " + directions[5] + "!");
				System.out.println(" ");
				room = whereToGo[7][6];
				MainNWHall(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				System.out.println("Unrecognized input.");	
				System.out.println(" ");
				room = whereToGo[7][6];
				MainNWHall(room, roomName, whereToGo, directions, myStats, invo, flags);
				
			}
		}
   }
		public void MainNWNRoom(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
			// DONE.
			room = whereToGo[8][6];
			Scanner newScan = new Scanner(System.in);
			String directChoice;
			Random newRand = new Random();
			int encChance = newRand.nextInt(9) + 1;
			

			System.out.println("You are in the " + roomName[8]);
			System.out.println(" ");
			if (encChance < 3) {
				System.out.println("A Dark Knight appears!");
				System.out.println(" ");
				TxtAdventGameEasyEnc newEnc = new TxtAdventGameEasyEnc();
				newEnc.randEncounterEasy(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			else {
			System.out.println("You see: Nothing");
			System.out.println(" ");
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[1]);
			System.out.println(" ");
			System.out.println("Where do you want to go/what would you like to interact with?");
			System.out.println(" ");
			
			directChoice = newScan.next();
			
			directChoice = directChoice.substring(0, 1).toLowerCase();
			
			switch (directChoice) {
			case "i":
				room = whereToGo[8][6];
				invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "n":
				System.out.println("You can't go " + directions[0] + "!");
				System.out.println(" ");
				room = whereToGo[8][6];
				MainNWNRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "s":
				room = whereToGo[8][1];
				MainNWHall(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "e":
				System.out.println("You can't go " + directions[2] + "!");
				System.out.println(" ");
				room = whereToGo[8][6];
				MainNWNRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "w":
				System.out.println("You can't go " + directions[3] + "!");
				System.out.println(" ");
				room = whereToGo[8][6];
				MainNWNRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "u":
				System.out.println("You can't go " + directions[4] + "!");
				System.out.println(" ");
				room = whereToGo[8][6];
				MainNWNRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "d":
				System.out.println("You can't go " + directions[5] + "!");
				System.out.println(" ");
				room = whereToGo[8][6];
				MainNWNRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				System.out.println("Unrecognized input.");	
				System.out.println(" ");
				room = whereToGo[8][6];
				MainNWNRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				
			}
		}
   }
		public void MainNWWRoom(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
			// DONE.
			room = whereToGo[9][6];
			Scanner newScan = new Scanner(System.in);
			String directChoice;
			Random newRand = new Random();
			int encChance = newRand.nextInt(9) + 1;
			

			System.out.println("You are in the " + roomName[9]);
			System.out.println(" ");
			if (flags[0] == 0) {
			if (encChance >= 1) {
				System.out.println("A Dark Knight appears!");
				System.out.println(" ");
				flags[0] = 1;
				TxtAdventGameEasyEnc newEnc = new TxtAdventGameEasyEnc();
				newEnc.randEncounterEasy(room, roomName, whereToGo, directions, myStats, invo, flags);
				
			}
			}
			else {
			System.out.println("You see: Nothing");
			System.out.println(" ");
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[2]);
			System.out.println(" ");
			System.out.println("You can interact with the following: Chest");
			System.out.println(" ");
			System.out.println("Where do you want to go/what would you like to interact with?");
			System.out.println(" ");
			
			directChoice = newScan.next();
			
			directChoice = directChoice.substring(0, 1).toLowerCase();
			
			switch (directChoice) {
			case "i":
				room = whereToGo[9][6];
				invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "n":
				System.out.println("You can't go " + directions[0] + "!");
				System.out.println(" ");
				room = whereToGo[9][6];
				MainNWWRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "s":
				System.out.println("You can't go " + directions[1] + "!");
				System.out.println(" ");
				room = whereToGo[9][6];
				MainNWWRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "e":
				room = whereToGo[9][2];
				MainNWHall(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "w":
				System.out.println("You can't go " + directions[3] + "!");
				System.out.println(" ");
				room = whereToGo[9][6];
				MainNWWRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "u":
				System.out.println("You can't go " + directions[4] + "!");
				System.out.println(" ");
				room = whereToGo[9][6];
				MainNWWRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "d":
				System.out.println("You can't go " + directions[5] + "!");
				System.out.println(" ");
				room = whereToGo[9][6];
				MainNWWRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "c":
				if (flags[1] == 1) {
					System.out.println("You already opened this chest.");
					System.out.println(" ");
					System.out.println("You exit the room.");
					System.out.println(" ");
					room = whereToGo[9][2];
					MainNWHall(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
				else 
				
				System.out.println("You open the chest and receive a key! I wonder what it goes to..");
				System.out.println(" ");
				System.out.println("You exit the room.");
				System.out.println(" ");
				flags[1] = 1;
				invo[4] = invo[4] + 1;
				room = whereToGo[9][2];
				MainNWHall(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				System.out.println("Unrecognized input.");	
				System.out.println(" ");
				room = whereToGo[9][6];
				MainNWWRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				
			}
		}
   }
		public void MainNWSRoom(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
			// DONE.
			room = whereToGo[10][6];
			Scanner newScan = new Scanner(System.in);
			String directChoice;
			Random newRand = new Random();
			int encChance = newRand.nextInt(9) + 1;
			

			System.out.println("You are in the " + roomName[10]);
			System.out.println(" ");
			if (encChance < 3) {
				System.out.println("A Dark Knight appears!");
				System.out.println(" ");
				TxtAdventGameEasyEnc newEnc = new TxtAdventGameEasyEnc();
				newEnc.randEncounterEasy(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			else {
			System.out.println("You see: Nothing");
			System.out.println(" ");
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[0]);
			System.out.println(" ");
			System.out.println("Where do you want to go/what would you like to interact with?");
			System.out.println(" ");
			
			directChoice = newScan.next();
			
			directChoice = directChoice.substring(0, 1).toLowerCase();
			
			switch (directChoice) {
			
			case "i":
				room = whereToGo[10][6];
				invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "n":
				room = whereToGo[10][0];
				MainNWHall(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "s":
				System.out.println("You can't go " + directions[1] + "!");
				System.out.println(" ");
				room = whereToGo[10][6];
				MainNWSRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "e":
				System.out.println("You can't go " + directions[2] + "!");
				System.out.println(" ");
				room = whereToGo[10][6];
				MainNWSRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "w":
				System.out.println("You can't go " + directions[3] + "!");
				System.out.println(" ");
				room = whereToGo[10][6];
				MainNWSRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "u":
				System.out.println("You can't go " + directions[4] + "!");
				System.out.println(" ");
				room = whereToGo[10][6];
				MainNWSRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "d":
				System.out.println("You can't go " + directions[5] + "!");
				System.out.println(" ");
				room = whereToGo[10][6];
				MainNWSRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				System.out.println("Unrecognized input.");	
				System.out.println(" ");
				room = whereToGo[10][6];
				MainNWSRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				
			}
		}
   }
		public void MainWNRoom(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
			// DONE.
			room = whereToGo[11][6];
			Scanner newScan = new Scanner(System.in);
			String directChoice;
			Random newRand = new Random();
			int encChance = newRand.nextInt(9) + 1;
			

			System.out.println("You are in the " + roomName[11]);
			System.out.println(" ");
			if (encChance < 3) {
				System.out.println("A Dark Knight appears!");
				System.out.println(" ");
				TxtAdventGameEasyEnc newEnc = new TxtAdventGameEasyEnc();
				newEnc.randEncounterEasy(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			else {
			System.out.println("You see: Nothing");
			System.out.println(" ");
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[1]);
			System.out.println(" ");
			System.out.println("Where do you want to go/what would you like to interact with?");
			System.out.println(" ");
			
			directChoice = newScan.next();
			
			directChoice = directChoice.substring(0, 1).toLowerCase();
			
			switch (directChoice) {
			
			case "i":
				room = whereToGo[11][6];
				invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "n":
				System.out.println("You can't go " + directions[0] + "!");
				System.out.println(" ");
				room = whereToGo[11][6];
				MainWNRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "s":
				room = whereToGo[11][1];
				MainFloorWCorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "e":
				System.out.println("You can't go " + directions[2] + "!");
				System.out.println(" ");
				room = whereToGo[11][6];
				MainWNRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "w":
				System.out.println("You can't go " + directions[3] + "!");
				System.out.println(" ");
				room = whereToGo[11][6];
				MainWNRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "u":
				System.out.println("You can't go " + directions[4] + "!");
				System.out.println(" ");
				room = whereToGo[11][6];
				MainWNRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "d":
				System.out.println("You can't go " + directions[5] + "!");
				System.out.println(" ");
				room = whereToGo[11][6];
				MainWNRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				System.out.println("Unrecognized input.");	
				System.out.println(" ");
				room = whereToGo[11][6];
				MainWNRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				
			}
		}
   }
		public void MainWSRoom(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
			// DONE.
			room = whereToGo[12][6];
			Scanner newScan = new Scanner(System.in);
			String directChoice;
			Random newRand = new Random();
			int encChance = newRand.nextInt(9) + 1;
			

			System.out.println("You are in the " + roomName[12]);
			System.out.println(" ");
			if (encChance < 3) {
				System.out.println("A Dark Knight appears!");
				System.out.println(" ");
				TxtAdventGameEasyEnc newEnc = new TxtAdventGameEasyEnc();
				newEnc.randEncounterEasy(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			else {
			System.out.println("You see: Nothing");
			System.out.println(" ");
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[0]);
			System.out.println(" ");
			System.out.println("Where do you want to go/what would you like to interact with?");
			System.out.println(" ");
			
			directChoice = newScan.next();
			
			directChoice = directChoice.substring(0, 1).toLowerCase();
			
			switch (directChoice) {
			
			case "i":
				room = whereToGo[12][6];
				invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "n":
				room = whereToGo[12][0];
				MainFloorWCorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "s":
				System.out.println("You can't go " + directions[1] + "!");
				System.out.println(" ");
				room = whereToGo[12][6];
				MainWSRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "e":
				System.out.println("You can't go " + directions[2] + "!");
				System.out.println(" ");
				room = whereToGo[12][6];
				MainWSRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "w":
				System.out.println("You can't go " + directions[3] + "!");
				System.out.println(" ");
				room = whereToGo[12][6];
				MainWSRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "u":
				System.out.println("You can't go " + directions[4] + "!");
				System.out.println(" ");
				room = whereToGo[12][6];
				MainWSRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			case "d":
				System.out.println("You can't go " + directions[5] + "!");
				System.out.println(" ");
				room = whereToGo[12][6];
				MainWSRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				System.out.println("Unrecognized input.");	
				System.out.println(" ");
				room = whereToGo[12][6];
				MainWSRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				
			}
		}
   }
	

		public void invoCheck(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
			
			 final int RETRY = 0;
			 int choice;
			 System.out.println("Your Inventory:\n Health Potion: " + invo[0] + "\n Attack Boost: " + invo[1] + "\n Speed Boost: " + invo[2] + "\n Defence Boost: " + invo[3] + "\n Downstairs Key: " + invo[4] + "\n Upstairs Key: " + invo[5] + "\n Final Key: " + invo[6]);
			 System.out.println(" ");
			
			 while (RETRY >= 0) {
				 System.out.println("Return to the game?");
				 System.out.println(" ");
					System.out.println("1) Yes\n2) Not yet");
					Scanner newScan = new Scanner(System.in);
					try {
						choice = newScan.nextInt();
						if (choice == 1) {
							System.out.println("And we continue!");
							System.out.println(" ");
							TxtAdventGameRoomIndex roomFind = new TxtAdventGameRoomIndex();
							roomFind.room(room, roomName, whereToGo, directions, myStats, invo, flags);
							
						}
						else if (choice == 2) {
							System.out.println("You should consider returning! Enemys lurk about!");
							System.out.println(" ");
						}
						
						else {
							System.out.println("Not a valid option");
							System.out.println(" ");
							
					
						}
						
					}
					catch (InputMismatchException error) {
							System.out.println("Can't use letters/symbols/other nonsense here!");
					}
					break;
				}
			 
		}
		public void endGame() {
			
			System.out.println("More to come; game still in construction!");
			System.exit(0);
		}
		
  }



