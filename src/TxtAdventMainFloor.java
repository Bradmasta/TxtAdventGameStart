import javax.swing.*;
public class TxtAdventMainFloor {



	
	public void Rooms(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
	
		TxtAdventInvoCheck playerChooses = new TxtAdventInvoCheck();
		TxtAdventDungeon dunRoom = new TxtAdventDungeon();

		
		String directChoice;
		
		directChoice = Script(room, roomName, whereToGo, directions, myStats, invo, flags);
		
		directChoice = directChoice.substring(0, 1).toLowerCase();
		
		
	
		switch (directChoice) {

		case "i":
			playerChooses.invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
			break;
		case "c":
			if (room == 9) {
			if (flags[0] == 0) {
				JOptionPane.showMessageDialog(null, "You receive a key! Keep exploring to find out what it goes to! \nYou exit the room. \n");
				invo[4] += 1;
				flags[0] += 1;
				room = whereToGo[9][2];	
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
				else {
				JOptionPane.showMessageDialog(null, "You've already opened this chest. \nYou exit the room. \n");
				room = whereToGo[9][2];	
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "There isn't a chest here! \n");
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;
		case "k":
			if (room == 2) {
			if (flags[2] == 0) {
				if (invo[4] == 1) {
				JOptionPane.showMessageDialog(null, "You unlocked the Trapdoor! This will take you to the dungeon! \n");
				flags[2] += 1;
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
				else {
				JOptionPane.showMessageDialog(null, "You don't have the correct key for this trapdoor yet! \n");
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
			}
				else {
				JOptionPane.showMessageDialog(null, "You've already unlocked the trapdoor! \n");	
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				
				}
			}
			else if (room == 3) {
				if (flags[5] == 0) {
					if (invo[5] == 1) {
						JOptionPane.showMessageDialog(null, "You unlocked the door to the Upstairs! Head through when you're ready. \n");
						flags[5] += 1;
						Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					}
				else {
					JOptionPane.showMessageDialog(null, "You don't have the correct key for this door yet! \n");		
					Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					
				}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "You've already unlocked the Upstairs door. \n");		
					Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "You can't use a key here! \n");			
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
				JOptionPane.showMessageDialog(null, "If this message if shown, I coded something incorrectly. \n");	
				break;
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "You can't go " + directions[0] + "\n");
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
					JOptionPane.showMessageDialog(null, "If this message if shown, I coded something incorrectly. \n");	
					break;
				
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "You can't go " + directions[1] + "\n");
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
				JOptionPane.showMessageDialog(null, "If this message if shown, I coded something incorrectly. \n");	
				break;
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "You can't go " + directions[2] + "\n");
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
				JOptionPane.showMessageDialog(null, "If this message if shown, I coded something incorrectly. \n");	
				break;
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "You can't go " + directions[3] + "\n");
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
					JOptionPane.showMessageDialog(null, "You can't go " + directions[4] + " yet! The Door needs unlocked! \n");
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
				JOptionPane.showMessageDialog(null, "If this message if shown, I coded something incorrectly. \n");	
				break;
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "You can't go " + directions[4] + "\n");
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
				JOptionPane.showMessageDialog(null, "You can't go " + directions[5] + " yet! The trapdoor needs unlocked! \n");
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
				JOptionPane.showMessageDialog(null, "If this message if shown, I coded something incorrectly. \n");	
				break;
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "You can't go " + directions[5] + "\n");
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;
		
			default:
			JOptionPane.showMessageDialog(null, "Unrecognized input. \n");	
			Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			 
		}
	}			
	public String Script(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		TxtAdventNullCheck nullCheck = new TxtAdventNullCheck();
		String retString = null;
		String roomIn = "You are in the " + roomName[room];
		System.out.println(" ");
		 if(room == 12 || room == 10) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + "\nYou can go the following directions: \n" + directions[0] + "\nWhere do you want to go? \n"));
			emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
		}
		 else if (room == 8 || room == 11) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn +  "\nYou can go the following directions: \n" + directions[1] + "\nWhere do you want to go? \n"));
			emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
		}
		else if(room == 9) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			int flagCheck = flags[0];
			switch(flagCheck) {
			case 0:
				retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + "\nYou see a chest! Wonder what's inside..\nYou can go the following directions: \n" + directions[2] + "\nWhere do you want to go? \n"
					+ "Where do you want to go? or would you like to open the chest? (Type 'Chest' or 'c' to do so!) \n"));
				emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
				return retString;

			case 1:
				retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + "\nYou see an already opened chest!\nYou can go the following directions: \n" + directions[2] + "\nWhere do you want to go? \n"
			+ "Where do you want to go? or would you like to open the chest? (Type 'Chest' or 'c' to do so!) \n"));
				emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
				return retString;
			default:
	    	emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
		    return retString;
			}

		}
		else if(room == 5 || room == 6) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn +  "\nYou can go the following directions: \n" + directions[3] + "\nWhere do you want to go? \n"));
			emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
		}
		else if(room == 13) {
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn +  "\nYou can go the following directions: \n" + directions[5] + "\nWhere do you want to go? \n"));
			emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
		}
		else if(room == 4) {
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn +  "\nYou can go the following directions: \n" + directions[4] + "\nWhere do you want to go? \n"));
			emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
		}
		else if(room == 0) {
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn +  "\nYou can go the following directions: \n" + directions[0] + ", " + directions[2] + ", " + directions[3]
			+ "\nWhere do you want to go? \n"));
			emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
		}
		else if(room == 1) {
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn +  "\nYou can go the following directions: \n" + directions[1] + ", " + directions[2] + ", " + directions[3]
					+ "\nWhere do you want to go? \n"));
			emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
		}
		else if(room == 2) {
			int flagCheck = flags[2];
			switch(flagCheck) {
			case 0:
				retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn +  "\nYou see a locked trapdoor \nYou can go the following directions: \n" 
				+ directions[2] + ", " + directions[3] + ", " + directions[5]
			    + "\nWhere do you want to go? \n"));
			    emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			    return retString;
			case 1:
				retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn +  "\nYou see an unlocked trapdoor \nYou can go the following directions: \n" 
						+ directions[2] + ", " + directions[3] + ", " + directions[5]
						+ "\nWhere do you want to go? \n"));
			    emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			    return retString;
			default:
			    emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			    return retString;
			
			}
			
		}
		else if(room == 3) {
			int flagCheck = flags[5];
			switch(flagCheck) {
			case 0:
				retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn +  "\nYou see a locked Door \nYou can go the following directions: \n" 
			    + directions[0] + ", " + directions[1] + ", " + directions[2] + ", " + directions[4]
			    + "\nWhere do you want to go? \n"));
				emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
				return retString;
			case 1:
				retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn +  "\nYou see an unlocked Door \nYou can go the following directions: \n" 
			    + directions[0] + ", " + directions[1] + ", " + directions[2] + ", " + directions[4]
			    + "\nWhere do you want to go? \n"));
				emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
				return retString;
			default:
				emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			    return retString;
			
			}
			
		}
		else if(room == 7) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn +  "\nYou can go the following directions: \n" 
					+ directions[0] + ", " + directions[1] + ", " + directions[2] + ", " + directions[3]
					+ "\nWhere do you want to go? \n"));
			emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
		}
		 return retString;
	}
	public void enemyEnc(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {

		TxtAdventRandNum newRand = new TxtAdventRandNum();
		if (room == 9) {
			if (flags[1] == 0) {
			JOptionPane.showMessageDialog(null, "A Dark Knight appears! \n");
			flags[1] += 1;
			TxtAdventGameEasyEnc newEnc = new TxtAdventGameEasyEnc();
			newEnc.randEasyStart(room, roomName, whereToGo, directions, myStats, invo, flags);
		}
			else {
			JOptionPane.showMessageDialog(null, "You hear noises in nearby rooms, but the room is safe. \n");
		
			}
		}
		else if (newRand.randEnemyEnc() < 3) {
			JOptionPane.showMessageDialog(null, "A Dark Knight appears! \n");
			TxtAdventGameEasyEnc newEnc = new TxtAdventGameEasyEnc();
			newEnc.randEasyStart(room, roomName, whereToGo, directions, myStats, invo, flags);
		}	
		
	}
	public void emptyField (String field, int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		
		if(field.isEmpty()) {
			JOptionPane.showMessageDialog(null, "You need to type something.");
			Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			
		}
		
	}
	
	
}
