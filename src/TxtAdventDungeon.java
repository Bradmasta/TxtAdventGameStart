import javax.swing.JOptionPane;

public class TxtAdventDungeon {


	TxtAdventMainFloor mainFlr = new TxtAdventMainFloor();
	
	public void DunRooms(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		TxtAdventInvoCheck playerChooses = new TxtAdventInvoCheck();

		
		String directChoice;
		
		directChoice = Script(room, roomName, whereToGo, directions, myStats, invo, flags);
		
		directChoice = directChoice.substring(0, 1).toLowerCase();
		
		
	
		switch (directChoice) {

		case "i":
			playerChooses.invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
			break;
		case "c":
			if (room == 28) {
			if (flags[3] == 0) {
				JOptionPane.showMessageDialog(null, "You receive a key! Keep exploring to find out what it goes to! \nYou exit the room.");
				invo[5] += 1;
				flags[3] += 1;
				room = whereToGo[28][1];	
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
				else {
				JOptionPane.showMessageDialog(null, "You've already opened this chest. \nYou exit the room.");
				room = whereToGo[28][1];	
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "There isn't a chest here!");		
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;
		case "k":
			JOptionPane.showMessageDialog(null, "You can't use a key here!");
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
				JOptionPane.showMessageDialog(null, "If this message if shown, I coded something incorrectly.");	
				break;
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "You can't go " + directions[0]);
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
				JOptionPane.showMessageDialog(null, "If this message if shown, I coded something incorrectly.");
				break;
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "You can't go " + directions[1]);
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
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 18:
				room = whereToGo[18][2];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 19:
				room = whereToGo[19][2];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 22:
				room = whereToGo[22][2];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 23:
				room = whereToGo[23][2];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				default:
				JOptionPane.showMessageDialog(null, "If this message if shown, I coded something incorrectly.");
				break;
				
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "You can't go " + directions[2]);
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;
		

		case "w":
			checkIfValid = whereToGo[room][3];
			if (checkIfValid != -1) {
				switch(room) {
				case 4:
				room = whereToGo[4][3];	
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 14:
				room = whereToGo[14][3];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 18:
				room = whereToGo[18][3];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 21:
				room = whereToGo[21][3];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 23:
				room = whereToGo[23][3];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 24:
				room = whereToGo[24][3];
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				default:
				JOptionPane.showMessageDialog(null, "If this message if shown, I coded something incorrectly.");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "You can't go " + directions[3]);
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
				JOptionPane.showMessageDialog(null, "If this message if shown, I coded something incorrectly.");
				System.out.println("If this message if shown, I coded something incorrectly.");
				break;
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "You can't go " + directions[4]);
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;

		case "d":
			JOptionPane.showMessageDialog(null, "You can't go " + directions[5]);
			DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			break;
			default:
			JOptionPane.showMessageDialog(null, "Unrecognized input.");
			DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags); 
		}
	}
	public String Script(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		TxtAdventNullCheck nullCheck = new TxtAdventNullCheck();
		String retString = null;
		String roomIn = "You are in the " + roomName[room];
		 if(room == 16 || room == 20 || room == 26) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + "\nYou can go the following directions: \n" 
			+ directions[0] + "\nWhere do you want to go?"));
			emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;

		}
		 else if (room == 25) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + "\nYou can go the following directions: \n" 
			+ directions[1] + "\nWhere do you want to go?"));
			emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
		}
		else if(room == 28) {
			int flagCheck = flags[3];
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			
			switch(flagCheck) {
			case 0:
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + "\nYou see a chest! Wonder what's inside.."
			+ "\nYou can go the following directions: \n" + directions[1]
			+ "\nWhere do you want to go? or would you like to open the chest? (Type 'Chest' or 'c' to do so!)"));
			emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
			
			case 1:
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + "\nYou see an already opened chest!"
			+ "\nYou can go the following directions: \n" + directions[1]
			+ "\nWhere do you want to go?"));
			emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
			default:
		    emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
		    return retString;
			
			}
		}
		else if(room == 15 || room == 27) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + "\nYou can go the following directions: \n" 
			+ directions[0] + ", " + directions[1] + "\nWhere do you want to go?"));
			emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;

		}
		else if(room == 23) {
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + "\nYou can go the following directions: \n" 
			+ directions[2] + ", " + directions[3] + "\nWhere do you want to go?"));
			emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
		}
		else if(room == 4) {
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + "\nYou can go the following directions: \n" 
			+ directions[2] + ", " + directions[3] + ", " + directions[4] + "\nWhere do you want to go?"));
			emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
		}
			
		else if(room == 21 || room == 24) {
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + "\nYou can go the following directions: \n" 
			+ directions[0] + ", " + directions[1] + ", " + directions[3] + "\nWhere do you want to go?"));
			emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
			
		}
		else if(room == 14) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + "\nYou can go the following directions: \n" 
			+ directions[1] + ", " + directions[3] + "\nWhere do you want to go?"));
			emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
			
		}
		else if(room == 18) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + "\nYou can go the following directions: \n" 
			+ directions[1] + ", " + directions[2] + ", " + directions[3] +  "\nWhere do you want to go?"));
			emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
			
		}
		else if(room == 17 || room == 22) {
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + "\nYou can go the following directions: \n" 
			+ directions[0] + ", " + directions[2] + "\nWhere do you want to go?"));
			emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
		}
		else if(room == 19) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + "\nYou can go the following directions: \n" 
			+ directions[1] + ", " + directions[2] + "\nWhere do you want to go?"));
			emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
		}
		 return retString;
	}
	public void enemyEnc(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {

		TxtAdventRandNum newRand = new TxtAdventRandNum();
		if (room == 28) {
			if (flags[4] == 0) {
			JOptionPane.showMessageDialog(null, "A Hellhound appears!");
			flags[4] += 1;
			TxtAdventEncounters newEnc = new TxtAdventEncounters();
			newEnc.randStart(room, roomName, whereToGo, directions, myStats, invo, flags);
		}
			else {
				JOptionPane.showMessageDialog(null, "You hear the howl of the Hellhounds nearby, but the room is safe.");

			}
		}
		else if (newRand.randEnemyEnc() <= 4) {
			JOptionPane.showMessageDialog(null, "A Hellhound appears!");
			TxtAdventEncounters newEnc = new TxtAdventEncounters();
			newEnc.randStart(room, roomName, whereToGo, directions, myStats, invo, flags);
		}	
		
	}
	public void emptyField (String field, int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		
		if(field.isEmpty()) {
			JOptionPane.showMessageDialog(null, "You need to type something.");
			DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			
		}
	}
}
