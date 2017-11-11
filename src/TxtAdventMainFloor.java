
public class TxtAdventMainFloor {



	
	public void Rooms(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		TxtAdventInvoCheck playerChooses = new TxtAdventInvoCheck();
		TxtAdventUserInput newScan = new TxtAdventUserInput();
		TxtAdventDungeon dunRoom = new TxtAdventDungeon();

		
		String directChoice;
		
		Script(room, roomName, whereToGo, directions, myStats, invo, flags);
		
		directChoice = newScan.Scanner();
		
		directChoice = directChoice.substring(0, 1).toLowerCase();
		
		
	
		switch (directChoice) {

		case "i":
			playerChooses.invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
			break;
		case "c":
			if (room == 9) {
			if (flags[0] == 0) {
				System.out.println("You receive a key! Keep exploring to find out what it goes to!");
				System.out.println(" ");
				System.out.println("You exit the room.");
				System.out.println(" ");
				invo[4] += 1;
				flags[0] += 1;
				room = whereToGo[9][2];	
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
				else {
				System.out.println("You've already opened this chest.");
				System.out.println(" ");
				System.out.println("You exit the room.");
				System.out.println(" ");
				room = whereToGo[9][2];	
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				
				}
			}
			else {
				
				System.out.println("There isn't a chest here!");
				System.out.println(" ");
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;
		case "k":
			if (room == 2) {
			if (flags[2] == 0) {
				if (invo[4] == 1) {
				System.out.println("You unlocked the Trapdoor! This will take you to the dungeon!");
				System.out.println(" ");
				flags[2] += 1;
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
				else {
				System.out.println("You don't have the correct key for this trapdoor yet!");
				System.out.println(" ");
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
			}
				else {
				System.out.println("You've already unlocked the trapdoor!");
				System.out.println(" ");
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				
				}
			}
			else if (room == 3) {
				if (flags[5] == 0) {
					if (invo[5] == 1) {
						System.out.println("You unlocked the door to the Upstairs! Head through when you're ready.");
						System.out.println(" ");
						flags[5] += 1;
						Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					}
				else {
					System.out.println("You don't have the correct key for this door yet!");
					System.out.println(" ");
					Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					
				}
					
				}
				else {
					System.out.println("You've already unlocked the Upstairs door.");
					System.out.println(" ");
					Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					
				}
				
			}
			else {
				
				System.out.println("You can't use a key here!");
				System.out.println(" ");
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;
		case "n":
			int checkIfValid = whereToGo[room][0];
			if(checkIfValid != -1) {
				switch(room) {
				case 0:
				room = whereToGo[0][0];	
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 3:
				room = whereToGo[3][0];	
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 7:
				room = whereToGo[7][0];
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 10:
				room = whereToGo[10][0];
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 12:
				room = whereToGo[12][0];
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				System.out.println("If this message if shown, I coded something incorrectly.");
				}
			}
			else {
				System.out.println("You can't go " + directions[0]);
				System.out.println(" ");
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;
		
		case "s":
			checkIfValid = whereToGo[room][1];
			if (checkIfValid != -1) {
				switch(room) {
					case 1:
					room = whereToGo[1][1];	
					Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					break;
					case 3:
					room = whereToGo[3][1];	
					Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					break;
					case 7:
					room = whereToGo[7][1];
					Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					break;
					case 8:
					room = whereToGo[8][1];
					Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					break;
					case 11:
					room = whereToGo[11][1];
					Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					break;
					default:
					System.out.println("If this message if shown, I coded something incorrectly.");
				
				}
			}
			else {
				System.out.println("You can't go " + directions[1]);
				System.out.println(" ");
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;
		

		case "e":
			checkIfValid = whereToGo[room][2];
			if (checkIfValid != -1) {
				switch(room) {
				case 0:
				room = whereToGo[0][2];	
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 1:
				room = whereToGo[1][2];	
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 2:
				room = whereToGo[2][2];
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 3:
				room = whereToGo[3][2];
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 7:
				room = whereToGo[7][2];
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 9:
				room = whereToGo[9][2];
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				System.out.println("If this message if shown, I coded something incorrectly.");
				}
			}
			else {
				System.out.println("You can't go " + directions[2]);
				System.out.println(" ");
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;
		

		case "w":
			checkIfValid = whereToGo[room][3];
			if (checkIfValid != -1) {
				switch(room) {
				case 0:
				room = whereToGo[0][3];	
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 1:
				room = whereToGo[1][3];
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 2:
				room = whereToGo[2][3];
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 5:
				room = whereToGo[5][3];
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 6:
				room = whereToGo[6][3];
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 7:
				room = whereToGo[7][3];
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				System.out.println("If this message if shown, I coded something incorrectly.");
				}
			}
			else {
				System.out.println("You can't go " + directions[3]);
				System.out.println(" ");
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;

		case "u":
			checkIfValid = whereToGo[room][4];
			if (checkIfValid != -1) {
				switch(room) {
				case 3:
					int flagCheck = flags[5];
					if (flagCheck == 0) {
					System.out.println("You can't go " + directions[4] + " yet! The Door needs unlocked!");
					System.out.println(" ");
					Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					}
					else {
					room = whereToGo[3][4];
					Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					}
					break;
				case 4:
				room = whereToGo[4][4];
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				System.out.println("If this message if shown, I coded something incorrectly.");
				break;
				}
			}
			else {
				System.out.println("You can't go " + directions[4]);
				System.out.println(" ");
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;

		case "d":
			checkIfValid = whereToGo[room][5];
			if (checkIfValid != -1) {
				switch(room) {
				case 2:
				int flagCheck = flags[2];
				if (flagCheck == 0) {
				System.out.println("You can't go " + directions[5] + " yet! The trapdoor needs unlocked!");
				System.out.println(" ");
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
				else {
				room = whereToGo[2][5];
				dunRoom.DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
				break;
				case 13:
				room = whereToGo[13][4];
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				System.out.println("If this message if shown, I coded something incorrectly.");
				break;
				}
			}
			else {
				System.out.println("You can't go " + directions[5]);
				System.out.println(" ");
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;
		
			default:
			System.out.println("Unrecognized input.");	
			System.out.println(" ");
			Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			 
		}
	}			
	public void Script(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		
		System.out.println("You are in the " + roomName[room]);
		System.out.println(" ");
		 if(room == 12 || room == 10) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[0]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
		}
		 else if (room == 8 || room == 11) {
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
		else if(room == 5 || room == 6) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[3]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
		}
		else if(room == 13) {
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[5]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
		}
		else if(room == 4) {
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[4]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
		}
		else if(room == 0) {
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[0] + ", " + directions[2] + ", " + directions[3]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
		}
		else if(room == 1) {
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[1] + ", " + directions[2] + ", " + directions[3]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
		}
		else if(room == 2) {
			int flagCheck = flags[2];
			switch(flagCheck) {
			case 0:
			System.out.println("You see a locked trapdoor");
			System.out.println(" ");
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[2] + ", " + directions[3] + ", " + directions[5]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
			break;
			case 1:
			System.out.println("You see an unlocked trapdoor");
			System.out.println(" ");
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[2] + ", " + directions[3] + ", " + directions[5]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
			default:
			break;
			
			}
			
		}
		else if(room == 3) {
			int flagCheck = flags[5];
			switch(flagCheck) {
			case 0:
			System.out.println("You see a locked Door");
			System.out.println(" ");
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[0] + ", " + directions[1] + ", " + directions[2] + ", " + directions[4]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
			break;
			case 1:
			System.out.println("You see an unlocked Door");
			System.out.println(" ");
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[0] + ", " + directions[1] + ", " + directions[2] + ", " + directions[4]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
			default:
			break;
			
			}
			
		}
		else if(room == 7) {
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
		if (room == 9) {
			if (flags[1] == 0) {
			System.out.println("A Dark Knight appears!");
			System.out.println(" ");
			flags[1] += 1;
			TxtAdventGameEasyEnc newEnc = new TxtAdventGameEasyEnc();
			newEnc.randEncounterEasy(room, roomName, whereToGo, directions, myStats, invo, flags);
		}
			else {
				System.out.println("You hear noises in nearby rooms, but the room is safe.");
				System.out.println(" ");	
		
			}
		}
		else if (newRand.randEnemyEnc() < 3) {
			System.out.println("A Dark Knight appears!");
			System.out.println(" ");
			TxtAdventGameEasyEnc newEnc = new TxtAdventGameEasyEnc();
			newEnc.randEncounterEasy(room, roomName, whereToGo, directions, myStats, invo, flags);
		}	
		
	}
	
	
}
