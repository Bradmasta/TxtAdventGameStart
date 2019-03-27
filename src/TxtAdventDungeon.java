
import javax.swing.JOptionPane;
/********************************
 * This class controls all movement between rooms on the dungeon, as well as moving to a room on the main floor
 * The code is very similar to that of both the main floor and the upstairs area. 
 * While I could've put everything in one class, management was easier this way.
 ********************************/

public class TxtAdventDungeon {



	TxtAdventMainFloor mainFlr = new TxtAdventMainFloor();
	TxtAdventPrompts newPrompt = new TxtAdventPrompts();
	
	public void DunRooms(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		TxtAdventInvoCheck playerChooses = new TxtAdventInvoCheck();
		TxtAdventHelp help = new TxtAdventHelp();
		TxtAdventSave save = new TxtAdventSave();
		try {
			/*
			 * Based on the room you're in, the script will prompt certain text. You then choose which of the follow you want to do. A switch
			 * statement handles all responses.
			 */
		String directChoice = Script(room, roomName, whereToGo, directions, myStats, invo, flags).substring(0, 1).toLowerCase();
		
		switch (directChoice) {

		case "i":
			// Will pull up the players inventory.
			playerChooses.invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
			break;
		case "h":
			// Will pull up the help text.
			help.Help(room, roomName, whereToGo, directions, myStats, invo, flags);
			break;
		case "q":
			// Will save the game.
			save.Save(room, roomName, whereToGo, directions, myStats, invo, flags);
			break;
		case "c":
			// Will open a chest if the player is in rooms 28 or 26.
			if (room == 28) {
			if (flags[3] == 0) {
				newPrompt.PromptKey();
				invo[5] += 1;
				flags[3] += 1;
				room = whereToGo[28][1];	
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			}
				else {
				newPrompt.PromptAlreadyOpen();
				room = whereToGo[28][1];	
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				}
			}
			else if (room == 26) {
				if (flags[16] == 0) {
					// This chest will open is the player has less than half health left, otherwise it remains shut (also won't tell the player why)
					if(myStats[0] >= 130) {
						JOptionPane.showMessageDialog(null, newPrompt.PromptRoom26(0));	
						DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
						break;
						
					}
					else {	
						JOptionPane.showMessageDialog(null, newPrompt.PromptRoom26(1));	
					invo[0] += 3;
					invo[1] += 3;
					invo[2] += 3;
					flags[16] += 1;
					room = whereToGo[26][0];	
					DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					break;
					}
				}
					else {
					newPrompt.PromptAlreadyOpen();
					room = whereToGo[25][1];	
					DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					break;
					}
				}
			else {
				newPrompt.PromptNoChest();	
				flags[18] = 1;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			}
			
		case "k":
			// Opens any Doors or Trapdoors that require keys.
			JOptionPane.showMessageDialog(null, newPrompt.PromptUseKey(0));
			flags[18] = 1;
			DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			break;
		case "n":
			/*
			 *  Will move the player to the room to the north, assuming north is a viable option. 
			 *  The Int below checks the 2-D array for the value [room ID][Value of North]. Example could be [16][0].
			 *  If the check passes, the switch will automatically go to the room where the number matches, and the method is called again.
			 */
			int checkIfValid = whereToGo[room][0];
			if(checkIfValid != -1) {
				switch(room) {
				case 15:
				room = whereToGo[15][0];	
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 16:
				room = whereToGo[16][0];	
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 17:
				room = whereToGo[17][0];
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 20:
				room = whereToGo[20][0];
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 21:
				room = whereToGo[21][0];
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 22:
				room = whereToGo[22][0];
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 24:
				room = whereToGo[24][0];
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 26:
				room = whereToGo[26][0];
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 27:
				room = whereToGo[27][0];
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				default:
				newPrompt.PromptIncorrect();	
				break;
				}
			}
			else {
				// Will prompt if the player can't move that direction.
				newPrompt.PromptCantGoDirection(0);
				flags[18] = 1;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			}
			break;
		
		case "s":
			// refer to case "n" if unsure what this code does.
			checkIfValid = whereToGo[room][1];
			if (checkIfValid != -1) {
				switch(room) {
				case 14:
				room = whereToGo[14][1];	
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 15:
				room = whereToGo[15][1];	
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 18:
				room = whereToGo[18][1];
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 19:
				room = whereToGo[19][1];
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 21:
				room = whereToGo[21][1];
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 24:
				room = whereToGo[24][1];
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 25:
				room = whereToGo[25][1];
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 27:
				room = whereToGo[27][1];
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 28:
				room = whereToGo[28][1];
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				newPrompt.PromptIncorrect();
				break;
				}
			}
			else {
				// refer to case "n" if unsure what this code does.
				newPrompt.PromptCantGoDirection(1);
				flags[18] = 1;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			}
			break;
		

		case "e":
			// refer to case "n" if unsure what this code does.
			checkIfValid = whereToGo[room][2];
			if (checkIfValid != -1) {
				switch(room) {
				case 4:
				room = whereToGo[4][2];	
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				case 17:
				room = whereToGo[17][2];	
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 18:
				room = whereToGo[18][2];
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 19:
				room = whereToGo[19][2];
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 22:
				room = whereToGo[22][2];
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 23:
				room = whereToGo[23][2];
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				default:
				newPrompt.PromptIncorrect();
				break;
				
				}
			}
			else {
				// refer to case "n" if unsure what this code does.
				flags[18] = 1;
				newPrompt.PromptCantGoDirection(2);
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			}
			break;
		

		case "w":
			// refer to case "n" if unsure what this code does.
			checkIfValid = whereToGo[room][3];
			if (checkIfValid != -1) {
				switch(room) {
				case 4:
				room = whereToGo[4][3];	
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 14:
				room = whereToGo[14][3];
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 18:
				room = whereToGo[18][3];
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 21:
				room = whereToGo[21][3];
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 23:
				room = whereToGo[23][3];
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				case 24:
				room = whereToGo[24][3];
				flags[18] = 0;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
				default:
				newPrompt.PromptIncorrect();
				}
			}
			else {
				// refer to case "n" if unsure what this code does.
				newPrompt.PromptCantGoDirection(3);
				flags[18] = 1;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			}
			break;

		case "u":
			// refer to case "n" if unsure what this code does.
			checkIfValid = whereToGo[room][4];
			if (checkIfValid != -1) {
				switch(room) {
				case 4:
				room = whereToGo[4][4];
				flags[18] = 0;
				mainFlr.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				default:
				newPrompt.PromptIncorrect();
				break;
				}
			}
			else {
				// refer to case "n" if unsure what this code does.
				newPrompt.PromptCantGoDirection(4);
				flags[18] = 1;
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			}
			break;

		case "d":
			// refer to case "n" if unsure what this code does.
			newPrompt.PromptCantGoDirection(5);
			flags[18] = 1;
			DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			break;
			default:
			JOptionPane.showMessageDialog(null, "Unrecognized input.");
			DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags); 
			break;
		}
		}
		catch (NullPointerException | StringIndexOutOfBoundsException e) {
			System.out.println(" ");
			
		}
		
	
	}
	public String Script(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		/*
		 * This method is comprised of specific prompting as well as potential encounters. Some rooms are similar and have the same exact prompts,
		 * which is why you'll see such code as if (room == 16 || room == 20). A prompt class was created to keep the code manageable and clean.
		 * As far as encounters go, there is a 30% chance of an encounter happening, and depending on the flag value of flags[18], the player might
		 * be temporarily spared from an encounter. This was done so that that player is not bombarded with encounters.
		 */
		TxtAdventNullCheck nullCheck = new TxtAdventNullCheck();
		TxtAdventEncounters newEnc = new TxtAdventEncounters();
		TxtAdventRandNum newRand = new TxtAdventRandNum();
		String retString = null;
		String roomIn = "You are in the " + roomName[room];
		 if(room == 16 || room == 20) {
			 if (newRand.randEnemyEnc() <= 3) {
				 if (flags[18] == 0) {
					 newPrompt.PromptHellHound();
						
						newEnc.randStart(room, roomName, whereToGo, directions, myStats, invo, flags);
					}
			 else {
				 flags[18] = 0;
			newPrompt.PromptHellHoundSafe();
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(0)));
			if(retString.isEmpty()) {
				
				JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			else {
				return retString;
			}
			 }
		}
			 else {
					flags[18] = 0;
					retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(0)));
					if(retString.isEmpty()) {
						
						JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
						flags[18] = 1;
						DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					}
					else {
						
						return retString;
					}
			 	}
		 }
		 else if (room == 26) {

			 if (flags[17] == 0) {
					newPrompt.PromptHellHound();
					flags[17] += 1;
					
					newEnc.randStart(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
					else {
						newPrompt.PromptHellHoundSafe();
						 int flagCheck = flags[16];
				switch(flagCheck) {
				case 0:
				retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptChestTxt(0)
				+ newPrompt.PromptBasicScript(0) + newPrompt.PromptChestTxt(2)));
				if(retString.isEmpty()) {
					
					JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
					DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
				else {
					return retString;
				}
				return retString;
				
				case 1:
				retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptChestTxt(1)
				+ newPrompt.PromptBasicScript(0)));
				if(retString.isEmpty()) {
					
					JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
					DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
				else {
					return retString;
				}
				return retString;
				default:
			
						JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
						DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					return retString;
	       }
					}
		 }
		 else if (room == 25) {
			 retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(1)));
			 if(retString.isEmpty()) {
					
					JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
					DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
				else {
					return retString;
				}
				return retString;
	    }
		else if(room == 28) {
		
				if (flags[4] == 0) {
				newPrompt.PromptHellHound();
				flags[4] += 1;
			
				newEnc.randStart(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
				else {
					newPrompt.PromptHellHoundSafe();
			int flagCheck = flags[3];
			switch(flagCheck) {
			case 0:
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptChestTxt(0)
			+ newPrompt.PromptBasicScript(1) + newPrompt.PromptChestTxt(2)));
			if(retString.isEmpty()) {
				
				JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			else {
				return retString;
			}
			return retString;
			
			case 1:
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptChestTxt(1)
			+ newPrompt.PromptBasicScript(1)));
			if(retString.isEmpty()) {
				
				JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			else {
				return retString;
			}
			return retString;
			default:
					
					JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());

				return retString;
			
			}
		}
		}
		else if(room == 15 || room == 27) {
			if (newRand.randEnemyEnc() <= 3) {
				 if (flags[18] == 0) {
					 newPrompt.PromptHellHound();
						
						newEnc.randStart(room, roomName, whereToGo, directions, myStats, invo, flags);
					}
			 else {
				 flags[18] = 0;
			newPrompt.PromptHellHoundSafe();
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(13)));
			if(retString.isEmpty()) {
				
				JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			else {
				return retString;
			}
			 }
			}
			else {
				flags[18] = 0;
				retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(13)));
				if(retString.isEmpty()) {
					
					JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
					flags[18] = 1;
					DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
				else {
					
					return retString;
				}
		 	}

		}
		else if(room == 23) {
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(14)));
			if(retString.isEmpty()) {
				
				JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			else {
				return retString;
			}
			
		}
		else if(room == 4) {
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(15)));
			if(retString.isEmpty()) {
				
				JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			else {
				return retString;
			}
			
		}
			
		else if(room == 21 || room == 24) {
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(12)));
			if(retString.isEmpty()) {
				
				JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			else {
				return retString;
			}
			
		}
		else if(room == 14) {
			if (newRand.randEnemyEnc() <= 3) {
				 if (flags[18] == 0) {
					 newPrompt.PromptHellHound();
						
						newEnc.randStart(room, roomName, whereToGo, directions, myStats, invo, flags);
					}
			 else {
				 flags[18] = 0;
			newPrompt.PromptHellHoundSafe();
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(16)));
			if(retString.isEmpty()) {
				
				JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			else {
				return retString;
			}
			 }
			}
			else {
				flags[18] = 0;
				retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(16)));
				if(retString.isEmpty()) {
					
					JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
					flags[18] = 1;
					DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
				else {
					
					return retString;
				}
		 	}
			
		}
		else if(room == 18) {
			if (newRand.randEnemyEnc() <= 3) {
				 if (flags[18] == 0) {
					 newPrompt.PromptHellHound();
						
						newEnc.randStart(room, roomName, whereToGo, directions, myStats, invo, flags);
					}
			 else {
				 flags[18] = 0;
			newPrompt.PromptHellHoundSafe();
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(7)));
			if(retString.isEmpty()) {
				
				JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			else {
				return retString;
			}
			 }
			}
			else {
				flags[18] = 0;
				retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(7)));
				if(retString.isEmpty()) {
					
					JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
					flags[18] = 1;
					DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
				else {
					
					return retString;
				}
		 	}
			
		}
		else if(room == 17 || room == 22) {
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(17)));
			if(retString.isEmpty()) {
				
				JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			else {
				return retString;
			}
			return retString;
		}
		else if(room == 19) {
			if (newRand.randEnemyEnc() <= 3) {
				 if (flags[18] == 0) {
					 newPrompt.PromptHellHound();
						
						newEnc.randStart(room, roomName, whereToGo, directions, myStats, invo, flags);
					}
			 else {
				 flags[18] = 0;
			newPrompt.PromptHellHoundSafe();
			retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(18)));
			if(retString.isEmpty()) {
				
				JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
				DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			}
			else {
				return retString;
			}
			 }
			}
			else {
				flags[18] = 0;
				retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(18)));
				if(retString.isEmpty()) {
					
					JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
					flags[18] = 1;
					DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
				else {
					
					return retString;
				}
		 	}
		}
		 return retString;
	}
	

}
