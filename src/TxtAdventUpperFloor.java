
public class TxtAdventUpperFloor {



	
	public void UpperRooms(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		TxtAdventInvoCheck playerChooses = new TxtAdventInvoCheck();
		TxtAdventUserInput newScan = new TxtAdventUserInput();
		TxtAdventMainFloor mainRoom = new TxtAdventMainFloor();

		
		String directChoice;
		
		Script(room, roomName, whereToGo, directions, myStats, invo, flags);
		
		directChoice = newScan.Scanner();
		
		directChoice = directChoice.substring(0, 1).toLowerCase();
		
		
	
		switch (directChoice) {

		case "i":
			playerChooses.invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
			break;
		case "c":
			if (room == 34) {
			if (flags[6] == 0) {
				System.out.println("You receive a key! Keep exploring to find out what it goes to!");
				System.out.println(" ");
				System.out.println("You exit the room.");
				System.out.println(" ");
				invo[6] += 1;
				flags[6] += 1;
				room = whereToGo[34][1];	
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
				else {
				System.out.println("You've already opened this chest.");
				System.out.println(" ");
				System.out.println("You exit the room.");
				System.out.println(" ");
				room = whereToGo[34][1];	
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				
				}
			}
			else {
				
				System.out.println("There isn't a chest here!");
				System.out.println(" ");
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;
		case "k":
			if (room == 29) {
			if (flags[7] == 0) {
				if (invo[6] == 1) {
				System.out.println("You unlocked the Final door! Good luck proceeding; you're going to need it!");
				System.out.println(" ");
				flags[7] += 1;
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
				else {
				System.out.println("You don't have the correct key for this door yet!");
				System.out.println(" ");
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
			}
				else {
				System.out.println("You've already unlocked the Final Door!");
				System.out.println(" ");
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				
				}
			}
			else {
				
				System.out.println("You can't use a key here!");
				System.out.println(" ");
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;
		case "n":
			int checkIfValid = whereToGo[room][0];
			if(checkIfValid != -1) {
				switch(room) {
				case 13:
				room = whereToGo[13][0];	
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 29:
				room = whereToGo[29][0];	
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 30:
				room = whereToGo[30][0];
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 32:
				room = whereToGo[32][0];
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 33:
				room = whereToGo[33][0];
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 35:
				room = whereToGo[35][0];
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 36:
				room = whereToGo[36][0];
				// needs Dragon Method
				break;
				default:
				System.out.println("If this message if shown, I coded something incorrectly.");
				}
			}
			else {
				System.out.println("You can't go " + directions[0]);
				System.out.println(" ");
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;
		
		case "s":
			checkIfValid = whereToGo[room][1];
			if (checkIfValid != -1) {
				switch(room) {
				case 29:
				room = whereToGo[29][1];	
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 30:
				room = whereToGo[30][1];	
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 31:
				room = whereToGo[31][1];
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 33:
				room = whereToGo[33][1];
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 34:
				room = whereToGo[34][1];
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 36:
				room = whereToGo[36][1];
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				System.out.println("If this message if shown, I coded something incorrectly.");
				}
			}
			else {
				System.out.println("You can't go " + directions[1]);
				System.out.println(" ");
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
			break;
		

		case "e":
			checkIfValid = whereToGo[room][2];
			if (checkIfValid != -1) {
				switch(room) {
				case 29:
				room = whereToGo[29][2];	
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 30:
				room = whereToGo[30][2];	
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				System.out.println("If this message if shown, I coded something incorrectly.");
				}
			}
			else {
				System.out.println("You can't go " + directions[2]);
				System.out.println(" ");
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;
		

		case "w":
			checkIfValid = whereToGo[room][3];
			if (checkIfValid != -1) {
				switch(room) {
				case 29:
				room = whereToGo[29][3];	
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 33:
				room = whereToGo[33][3];	
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				System.out.println("If this message if shown, I coded something incorrectly.");
				}
			}
			else {
				System.out.println("You can't go " + directions[3]);
				System.out.println(" ");
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;

		case "u":
			System.out.println("You can't go " + directions[4]);
			System.out.println(" ");
			UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			break;
			
		case "d":
			checkIfValid = whereToGo[room][5];
			if (checkIfValid != -1) {
				switch(room) {
				case 13:
				room = whereToGo[13][5];
				mainRoom.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				System.out.println("If this message if shown, I coded something incorrectly.");
				break;
				}
			}
			else {
				System.out.println("You can't go " + directions[4]);
				System.out.println(" ");
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;
			default:
			System.out.println("Unrecognized input.");	
			System.out.println(" ");
			UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags); 
		}
	}			
	public void Script(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		
		System.out.println("You are in the " + roomName[room]);
		System.out.println(" ");
		switch (room) {
		case 32:
		break;
		
		default:
		break;
		
		
		}
		 if(room == 32 || room == 35) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[0]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
		}
		 else if(room == 13) {
				System.out.println("You can go the following directions: ");
				System.out.println(" ");
				System.out.println(directions[0]);
				System.out.println(" ");
				System.out.println("Where do you want to go?");
				System.out.println(" ");
			}
		 else if (room == 31 || room == 34) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[1]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
		}
		else if(room == 9) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			int flagCheck = flags[0];
			switch(flagCheck) {
			case 0:
			System.out.println("You see a chest! Wonder what's inside..");
			System.out.println(" ");
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[2]);
			System.out.println(" ");
			System.out.println("Where do you want to go? or would you like to open the chest? (Type 'Chest' or 'c' to do so!)");
			System.out.println(" ");
			break;
			case 1:
			System.out.println("You see an already opened chest!");
			System.out.println(" ");
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[2]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
			default:
			break;
			
			}
		}
		else if(room == 36) {
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[0] + ", " + directions[1]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
		}
		else if(room == 30) {
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[0] + ", " + directions[1] + ", " + directions[2]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
		}
		else if(room == 33) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[0] + ", " + directions[1] + ", " + directions[3]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
			
		}
		else if(room == 29) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[0] + ", " + directions[1] + ", " + directions[2] + ", " + directions[3]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
			
		}
	
	}
	public void enemyEnc(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {

		TxtAdventRandNum newRand = new TxtAdventRandNum();
		if (room == 31) {
			if (flags[6] == 0) {
			System.out.println("A Drake appears!");
			System.out.println(" ");
			flags[6] += 1;
			TxtAdventGameHardEnc newEnc = new TxtAdventGameHardEnc();
			newEnc.randEncounterHard(room, roomName, whereToGo, directions, myStats, invo, flags);
		}
			else {
				System.out.println("You hear the sounds of small dragons pacing about, but the room is safe.");
				System.out.println(" ");	
		
			}
		}
		else if (room == 32) {
			if (flags[7] == 0) {
			System.out.println("A Drake appears!");
			System.out.println(" ");
			flags[7] += 1;
			TxtAdventGameHardEnc newEnc = new TxtAdventGameHardEnc();
			newEnc.randEncounterHard(room, roomName, whereToGo, directions, myStats, invo, flags);
		}
			else {
				System.out.println("You hear the sounds of small dragons pacing about, but the room is safe.");
				System.out.println(" ");	
		
			}
		}
		else if (room == 34) {
			if (flags[8] == 0) {
			System.out.println("A Drake appears!");
			System.out.println(" ");
			flags[8] += 1;
			TxtAdventGameHardEnc newEnc = new TxtAdventGameHardEnc();
			newEnc.randEncounterHard(room, roomName, whereToGo, directions, myStats, invo, flags);
		}
			else {
				System.out.println("You hear the sounds of small dragons pacing about, but the room is safe.");
				System.out.println(" ");	
		
			}
		}
		else if (room == 35) {
			if (flags[9] == 0) {
			System.out.println("A Drake appears!");
			System.out.println(" ");
			flags[9] += 1;
			TxtAdventGameHardEnc newEnc = new TxtAdventGameHardEnc();
			newEnc.randEncounterHard(room, roomName, whereToGo, directions, myStats, invo, flags);
		}
			else {
				System.out.println("You hear the sounds of small dragons pacing about, but the room is safe.");
				System.out.println(" ");	
		
			}
		}
		else if (newRand.randEnemyEnc() < 4) {
			System.out.println("A Drake appears!");
			System.out.println(" ");
			TxtAdventGameHardEnc newEnc = new TxtAdventGameHardEnc();
			newEnc.randEncounterHard(room, roomName, whereToGo, directions, myStats, invo, flags);
		}	
		
	}
	
	
}
