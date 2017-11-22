import javax.swing.*;
public class TxtAdventMainFloor {
/********************************
 * This class controls all movement between rooms on the middle floor, as well as moving to a room in the Dungeon and a room in the upstairs
 * 
 * 
 ********************************/

	
	
	public void Rooms(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) throws Exception {
		TxtAdventHelp help = new TxtAdventHelp();
		TxtAdventPrompts newPrompt = new TxtAdventPrompts();
		TxtAdventInvoCheck playerChooses = new TxtAdventInvoCheck();
		TxtAdventDungeon dunRoom = new TxtAdventDungeon();
		TxtAdventUpperFloor upFlr = new TxtAdventUpperFloor();
		TxtAdventSave save = new TxtAdventSave();
		//Uses methods from the classes listed above
		
		String directChoice;
		// Input is done in the Script method, and that input is then turned into a lowercase and passed into the switch
		directChoice = Script(room, roomName, whereToGo, directions, myStats, invo, flags);
		
		directChoice = directChoice.substring(0, 1).toLowerCase();
		
		
	
		switch (directChoice) {
		/* Takes in certain inputs, and based on them, does various things such as calling the inventory method, or passing in a new room ID
		 * based on the direction the player wants to go and calling the "Rooms" method again.
		*/
		case "i":
			playerChooses.invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
			break;
		case "h":
			help.Help(room, roomName, whereToGo, directions, myStats, invo, flags);
			break;
		case "q":
			save.Save(room, roomName, whereToGo, directions, myStats, invo, flags);
			break;
		case "c":
			if (room == 9) {
			if (flags[0] == 0) {
				
				newPrompt.PromptKey();
				invo[4] += 1;
				flags[0] += 1;
				room = whereToGo[9][2];	
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
				else {
					
				newPrompt.PromptAlreadyOpen();
				room = whereToGo[9][2];	
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				
				}
			}
			else {
				
				newPrompt.PromptNoChest();
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				
			}
			break;
		case "k":
			// Checks if the room is 2, and then it checks if a flag has gone off.
			if (room == 2) {
			if (flags[2] == 0) {
				if (invo[4] == 1) {
				JOptionPane.showMessageDialog(null, "You unlocked the Trapdoor! This will take you to the dungeon!");
				flags[2] += 1;
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
				else {
				JOptionPane.showMessageDialog(null, "You don't have the correct key for this trapdoor yet!");
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
			}
				else {
				JOptionPane.showMessageDialog(null, "You've already unlocked the trapdoor!");	
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				
				}
			}
			else if (room == 3) {
				if (flags[5] == 0) {
					if (invo[5] == 1) {
						JOptionPane.showMessageDialog(null, "You unlocked the door to the Upstairs! Head through when you're ready.");
						flags[5] += 1;
						Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					}
				else {
					JOptionPane.showMessageDialog(null, "You don't have the correct key for this door yet!");		
					Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					
				}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "You've already unlocked the Upstairs door.");		
					Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					
				}
				
			}
			else {
				// Prompt class used to take care of prompts that are used in multiple classes. This one will say you can't use a key here.
				newPrompt.PromptCantUseKey();			
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			break;
		case "n":
			// Will check if the data from the 2D array doesn't contain -1; if it doesn't, it'll pass in the correct room ID and "move" the player to that room
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
				newPrompt.PromptIncorrect();	
				break;
				}
			}
			else {
				// if the array data based on the room ID returns a -1, this shows.
				newPrompt.PromptCantGoDirection(0);
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
					newPrompt.PromptIncorrect();	
					break;
				
				}
			}
			else {
				newPrompt.PromptCantGoDirection(1);
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
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
				newPrompt.PromptIncorrect();	
				break;
				}
			}
			else {
				newPrompt.PromptCantGoDirection(2);
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
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
				newPrompt.PromptIncorrect();	
				break;
				}
			}
			else {
				newPrompt.PromptCantGoDirection(3);
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			}
			break;

		case "u":
			checkIfValid = whereToGo[room][4];
			if (checkIfValid != -1) {
					int flagCheck = flags[5];
					if (flagCheck == 0) {
					JOptionPane.showMessageDialog(null, "You can't go " + directions[4] + " yet! The Door needs unlocked!");
					Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					}
					else {
					room = whereToGo[3][4];
					upFlr.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					}


				
			}
			else {
				newPrompt.PromptCantGoDirection(4);
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			}
			break;

		case "d":
			checkIfValid = whereToGo[room][5];
			if (checkIfValid != -1) {
				switch(room) {
				case 2:
				int flagCheck = flags[2];
				if (flagCheck == 0) {
				JOptionPane.showMessageDialog(null, "You can't go " + directions[5] + " yet! The trapdoor needs unlocked!");
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
				newPrompt.PromptIncorrect();	
				break;
				}
			}
			else {
				newPrompt.PromptCantGoDirection(5);
				Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			}
			break;
		
			default:
			JOptionPane.showMessageDialog(null, "Unrecognized input.");	
			Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			break;
			 
		}
	}			
	public String Script(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) throws Exception {
		//Here is where all the text is called based on the room ID. These will call a method inside the Prompt class.
		TxtAdventNullCheck nullCheck = new TxtAdventNullCheck();
		TxtAdventPrompts newPrompt = new TxtAdventPrompts();
		String retString = null;
		String roomIn = "You are in the " + roomName[room];
		 if(room == 12 || room == 10) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(0)));
			nullCheck.emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
		}
		 else if (room == 8 || room == 11) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn +  newPrompt.PromptBasicScript(1)));
			nullCheck.emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
		}
		else if(room == 9) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			int flagCheck = flags[0];
			switch(flagCheck) {
			case 0:
				retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + "\nYou see a chest! Wonder what's inside.." + newPrompt.PromptBasicScript(2)
				+  " or would you like to open the chest? (Type 'Chest' or 'c' to do so!)"));
				nullCheck.emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
				return retString;

			case 1:
				retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + "\nYou see an already opened chest!" + newPrompt.PromptBasicScript(2)
				+  " or would you like to open the chest? (Type 'Chest' or 'c' to do so!)"));
				nullCheck.emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
				return retString;
			default:
				nullCheck.emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
		    return retString;
			}

		}
		else if(room == 5 || room == 6) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn +  newPrompt.PromptBasicScript(3)));
			nullCheck.emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
		}
		else if(room == 13) {
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn +  newPrompt.PromptBasicScript(3)));
			nullCheck.emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
		}
		else if(room == 0) {
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn +  newPrompt.PromptBasicScript(6)));
			nullCheck.emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
		}
		else if(room == 1) {
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn +  newPrompt.PromptBasicScript(7)));
			nullCheck.emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
		}
		else if(room == 2) {
			int flagCheck = flags[2];
			switch(flagCheck) {
			case 0:
				retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn +  "\nYou see a locked trapdoor." + newPrompt.PromptBasicScript(8)));
				nullCheck.emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			    return retString;
			case 1:
				retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn +  "\nYou see an unlocked trapdoor." + newPrompt.PromptBasicScript(8)));
				nullCheck.emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			    return retString;
			default:
				nullCheck.emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			    return retString;
			
			}
			
		}
		else if(room == 3) {
			int flagCheck = flags[5];
			switch(flagCheck) {
			case 0:
				retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn +  "\nYou see a locked Door."  + newPrompt.PromptBasicScript(9)));
				nullCheck.emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
				return retString;
			case 1:
				retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn +  "\nYou see an unlocked Door."  + newPrompt.PromptBasicScript(9)));
				nullCheck.emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
				return retString;
			default:
				nullCheck.emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			    return retString;
			
			}
			
		}
		else if(room == 7) {
			enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn +  newPrompt.PromptBasicScript(10)));
			nullCheck.emptyField(retString, room, roomName, whereToGo, directions, myStats, invo, flags);
			return retString;
		}
		 return retString;
	}
	public void enemyEnc(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) throws Exception {
		// This method is used in a few rooms to dictate potential encounters. On this floor, a player can encounter a Dark Knight and there's a 30% chance of that happening.
		TxtAdventPrompts newPrompt = new TxtAdventPrompts();
		TxtAdventRandNum newRand = new TxtAdventRandNum();
		if (room == 9) {
			if (flags[1] == 0) {
			newPrompt.PromptDarkKnight();
			flags[1] += 1;
			TxtAdventEncounters newEnc = new TxtAdventEncounters();
			newEnc.randStart(room, roomName, whereToGo, directions, myStats, invo, flags);
		}
			else {
			JOptionPane.showMessageDialog(null, "You hear noises in nearby rooms, but this room is safe.");
		
			}
		}
		else if (newRand.randEnemyEnc() < 3) {
			newPrompt.PromptDarkKnight();
			TxtAdventEncounters newEnc = new TxtAdventEncounters();
			newEnc.randStart(room, roomName, whereToGo, directions, myStats, invo, flags);
		}	
		
	}
	
	
}
