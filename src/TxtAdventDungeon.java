
public class TxtAdventDungeon {


	TxtAdventMainFloor mainFlr = new TxtAdventMainFloor();
	
	public void DunRooms(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		TxtAdventInvoCheck playerChooses = new TxtAdventInvoCheck();
		TxtAdventUserInput newScan = new TxtAdventUserInput();

		
		String directChoice;
		
		Script(room, roomName, whereToGo, directions, myStats, invo, flags);
		
		directChoice = newScan.Scanner();
		
		directChoice = directChoice.substring(0, 1).toLowerCase();
		
		
	
		switch (directChoice) {

		case "i":
			playerChooses.invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
			break;
		case "c":
			if (room == 28) {
			if (flags[3] == 0) {
				System.out.println("You receive a key! Keep exploring to find out what it goes to!");
				System.out.println(" ");
				System.out.println("You exit the room.");
				System.out.println(" ");
				invo[5] += 1;
				flags[3] += 1;
				room = whereToGo[28][1];	
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
				else {
				System.out.println("You've already opened this chest.");
				System.out.println(" ");
				System.out.println("You exit the room.");
				System.out.println(" ");
				room = whereToGo[28][1];	
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				
				}
			}
			else {
				
				System.out.println("There isn't a chest here!");
				System.out.println(" ");
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;
		case "k":
			System.out.println("You can't use a key here!");
			System.out.println(" ");
			DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			break;
		case "n":
			int checkIfValid = whereToGo[room][0];
			if(checkIfValid != -1) {
				switch(room) {
				case 15:
				room = whereToGo[15][0];	
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 16:
				room = whereToGo[16][0];	
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 17:
				room = whereToGo[17][0];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 20:
				room = whereToGo[20][0];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 21:
				room = whereToGo[21][0];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 22:
				room = whereToGo[22][0];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 24:
				room = whereToGo[24][0];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 26:
				room = whereToGo[26][0];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 27:
				room = whereToGo[27][0];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				System.out.println("If this message if shown, I coded something incorrectly.");
				}
			}
			else {
				System.out.println("You can't go " + directions[0]);
				System.out.println(" ");
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;
		
		case "s":
			checkIfValid = whereToGo[room][1];
			if (checkIfValid != -1) {
				switch(room) {
				case 14:
				room = whereToGo[14][1];	
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 15:
				room = whereToGo[15][1];	
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 18:
				room = whereToGo[18][1];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 19:
				room = whereToGo[19][1];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 21:
				room = whereToGo[21][1];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 24:
				room = whereToGo[24][1];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 25:
				room = whereToGo[25][1];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 27:
				room = whereToGo[27][1];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 28:
				room = whereToGo[28][1];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				System.out.println("If this message if shown, I coded something incorrectly.");
				}
			}
			else {
				System.out.println("You can't go " + directions[1]);
				System.out.println(" ");
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;
		

		case "e":
			checkIfValid = whereToGo[room][2];
			if (checkIfValid != -1) {
				switch(room) {
				case 4:
				room = whereToGo[4][2];	
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 17:
				room = whereToGo[17][2];	
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);break;
				case 18:
				room = whereToGo[18][2];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);break;
				case 19:
				room = whereToGo[19][2];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);break;
				case 22:
				room = whereToGo[22][2];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);break;
				case 23:
				room = whereToGo[23][2];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);break;
				default:
				System.out.println("If this message if shown, I coded something incorrectly.");
				}
			}
			else {
				System.out.println("You can't go " + directions[2]);
				System.out.println(" ");
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;
		

		case "w":
			checkIfValid = whereToGo[room][3];
			if (checkIfValid != -1) {
				switch(room) {
				case 4:
				room = whereToGo[4][3];	
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);break;
				case 14:
				room = whereToGo[14][3];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);break;
				case 18:
				room = whereToGo[18][3];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);break;
				case 21:
				room = whereToGo[21][3];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);break;
				case 23:
				room = whereToGo[23][3];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);break;
				case 24:
				room = whereToGo[24][3];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);break;
				default:
				System.out.println("If this message if shown, I coded something incorrectly.");
				}
			}
			else {
				System.out.println("You can't go " + directions[3]);
				System.out.println(" ");
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;

		case "u":
			checkIfValid = whereToGo[room][4];
			if (checkIfValid != -1) {
				switch(room) {
				case 4:
				room = whereToGo[4][4];
				mainFlr.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				System.out.println("If this message if shown, I coded something incorrectly.");
				break;
				}
			}
			else {
				System.out.println("You can't go " + directions[4]);
				System.out.println(" ");
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;

		case "d":
			System.out.println("You can't go " + directions[5]);
			System.out.println(" ");
			DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			break;
			default:
			System.out.println("Unrecognized input.");	
			System.out.println(" ");
			DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags); 
		}
	}
	public void Script(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		
		System.out.println("You are in the " + roomName[room]);
		System.out.println(" ");
		 if(room == 16 || room == 20 || room == 26) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[0]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
		}
		 else if (room == 25) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[1]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
		}
		else if(room == 28) {
			int flagCheck = flags[3];
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			switch(flagCheck) {
			case 0:
			System.out.println("You see a chest! Wonder what's inside..");
			System.out.println(" ");
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[1]);
			System.out.println(" ");
			System.out.println("Where do you want to go? or would you like to open the chest? (Type 'Chest' or 'c' to do so!)");
			System.out.println(" ");
			break;
			case 1:
			System.out.println("You see an already opened chest!");
			System.out.println(" ");
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[1]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
			default:
			break;
			
			}
		}
		else if(room == 15 || room == 27) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[0] + ", " + directions[1]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
		}
		else if(room == 23) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[2] + ", " + directions[3]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
		}
		else if(room == 4) {
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[2] + ", " + directions[3] + ", " + directions[4]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
		}
			
		else if(room == 21 || room == 24) {
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[0] + ", " + directions[1] + ", " + directions[3]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
			
		}
		else if(room == 14) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[1] + ", " + directions[3]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
			
		}
		else if(room == 18) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[1] + ", " + directions[2] + ", " + directions[3]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
			
		}
		else if(room == 17 || room == 22) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[0] + ", " + directions[2]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
		}
		else if(room == 19) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			System.out.println("You can go the following directions: ");
			System.out.println(" ");
			System.out.println(directions[1] + ", " + directions[2]);
			System.out.println(" ");
			System.out.println("Where do you want to go?");
			System.out.println(" ");
		}
	
	}
	public void enemyEnc(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {

		TxtAdventRandNum newRand = new TxtAdventRandNum();
		if (room == 28) {
			if (flags[4] == 0) {
			System.out.println("A Hellhound appears!");
			System.out.println(" ");
			flags[4] += 1;
			TxtAdventGameMedEnc newEnc = new TxtAdventGameMedEnc();
			newEnc.randEncounterMedium(room, roomName, whereToGo, directions, myStats, invo, flags);
		}
			else {
				System.out.println("You hear the howl of the Hellhounds nearby, but the room is safe.");
				System.out.println(" ");	
		
			}
		}
		else if (newRand.randEnemyEnc() < 6) {
			System.out.println("A Hellhound appears!");
			System.out.println(" ");
			TxtAdventGameMedEnc newEnc = new TxtAdventGameMedEnc();
			newEnc.randEncounterMedium(room, roomName, whereToGo, directions, myStats, invo, flags);
		}	
		
	}
}
