
import javax.swing.JOptionPane;

public class TxtAdventUpperFloor {
	
	/********************************
	 * This class controls all movement between rooms in the upstairs, as well as moving to a room on the main floor and dungeon
	 * The code is very similar to that of both the main floor and the dungeon. 
	 * While I could've put everything in one class, management was easier this way.
	 * 
	 ********************************/

	
	TxtAdventNullCheck nullCheck = new TxtAdventNullCheck();
	TxtAdventRandNum newRand = new TxtAdventRandNum();
	TxtAdventDungeon newDunFlr = new TxtAdventDungeon();
	TxtAdventDragon drgnFt = new TxtAdventDragon();


	
	public void UpperRooms(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		TxtAdventHelp help = new TxtAdventHelp();
		TxtAdventPrompts newPrompt = new TxtAdventPrompts();
		TxtAdventInvoCheck playerChooses = new TxtAdventInvoCheck();
		TxtAdventMainFloor mainRoom = new TxtAdventMainFloor();
		TxtAdventSave save = new TxtAdventSave();
		TxtAdventDragonKeep drgnKp = new TxtAdventDragonKeep();
		
		String directChoice;
		
		directChoice = Script(room, roomName, whereToGo, directions, myStats, invo, flags);
		
		directChoice = directChoice.substring(0, 1).toLowerCase();
		
		
	
		switch (directChoice) {

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
			switch (room) {
			
			case 31:
				if (flags[10] == 0) {
					newPrompt.PromptKey();
					invo[6] += 1;
					flags[10] += 1;
					room = whereToGo[31][1];	
					UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
					else {
					newPrompt.PromptAlreadyOpen();
					room = whereToGo[31][1];	
					UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					
					}
			break;
			
			case 32:
				if (flags[11] == 0) {
					JOptionPane.showMessageDialog(null, "You receive an Attack, a Defense, and Two Health Potions! \nYou exit the room.");
					invo[0] += 2;
					invo[1] += 1;
					invo[2] += 1;
					flags[11] += 1;
					room = whereToGo[32][0];	
					UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
					else {
					newPrompt.PromptAlreadyOpen();
					room = whereToGo[32][0];	
					UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					
					}
			break;
			
			case 34:
				if (flags[12] == 0) {
					JOptionPane.showMessageDialog(null, "You receive a Health, a Defense, and Two Attack potions! \nYou exit the room.");
					invo[0] += 1;
					invo[1] += 2;
					invo[2] += 1;
					flags[12] += 1;
					room = whereToGo[34][1];	
					UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
					else {
					newPrompt.PromptAlreadyOpen();
					room = whereToGo[34][1];	
					UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					
					}
			break;
			
			case 35:
				if (flags[13] == 0) {
					JOptionPane.showMessageDialog(null, "You receive a Health, an Attack, and two Defense potions! \nYou exit the room.");
					invo[0] += 1;
					invo[1] += 1;
					invo[2] += 2;
					flags[13] += 1;
					room = whereToGo[35][0];	
					UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
					else {
					newPrompt.PromptAlreadyOpen();
					room = whereToGo[35][0];	
					UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					
					}
			break;
			
			default:
			newPrompt.PromptNoChest();
			UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
			break;
			}
			
		case "k":
			if (room == 29) {
				
			if (flags[14] == 0) {
				
				if (invo[6] == 1) {
					
				JOptionPane.showMessageDialog(null, "You unlocked the Final door! Good luck proceeding; you're going to need it!");
				flags[14] += 1;
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				
				}
				else {
					
				JOptionPane.showMessageDialog(null, "You don't have the correct key for this door yet!");
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				
				}
			}
				else {
					
				JOptionPane.showMessageDialog(null, "You've already unlocked the Final Door!");
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				
				}
			}
			else {
				
				newPrompt.PromptCantUseKey();
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
					if (flags[14] == 0) {
						JOptionPane.showMessageDialog(null, "You haven't unlocked this door yet!");
						UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
						
					}
					else {
				room = whereToGo[29][0];	
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					}
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
				if (flags[15] == 2) {
					String choiceInfo = null;
					int choice = 0;
					choiceInfo = nullCheck.nullCheck(JOptionPane.showInputDialog(null, "Are you sure you want to proceed? There's no turning back.\n1) Yes \n2) Not just yet."));
					if(choiceInfo.isEmpty()) {
						
						JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
						UpperRooms(room, directions, whereToGo, directions, flags, flags, flags);
					}
					else {
					 switch(choiceInfo) {
					 case "1":
						 choice = Integer.parseInt(choiceInfo);
						 break;
					 case "2":
						 choice = Integer.parseInt(choiceInfo);
						 break;
					 default:
						 JOptionPane.showMessageDialog(null, "Not a valid option");
						 UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
						 break;
						 
					 }
					
					switch(choice) {
					
					case 1:
						
						room = whereToGo[36][0];
						drgnFt.DragonFightStart(room, roomName, whereToGo, directions, myStats, invo, flags);
						break;
					
					case 2:

						JOptionPane.showMessageDialog(null, "Wise choice. The Dragon is much too powerful.");
						UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
						break;
						
					default:
						JOptionPane.showMessageDialog(null, "Invalid input.");
						UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
						break;
	
					}
					}
				}
				else if (flags[15] == 0) {
					newPrompt.PromptDragonKeepFirstSee();
					drgnKp.DragonKeepStart(room, roomName, whereToGo, directions, myStats, invo, flags);
					break;
					
				}
				else if (flags[15] == 1) {
					newPrompt.PromptDragonKeepSecondSee();
					drgnKp.DragonKeepStart(room, roomName, whereToGo, directions, myStats, invo, flags);
					break;
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid input.");
					UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
				break;
				
				default:
					
				newPrompt.PromptIncorrect();
				
				break;
					
				}
			}
			else {
				
				newPrompt.PromptCantGoDirection(0);
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
				newPrompt.PromptIncorrect();
				break;
				}
			}
			else {
				newPrompt.PromptCantGoDirection(1);
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
				newPrompt.PromptIncorrect();
				break;
				}
			}
			else {
				
				newPrompt.PromptCantGoDirection(2);
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
				newPrompt.PromptIncorrect();
				break;
				
				}
			}
			else {
				
				newPrompt.PromptCantGoDirection(3);
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				
			}
			break;

		case "u":
			
			newPrompt.PromptCantGoDirection(4);
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
				newPrompt.PromptIncorrect();
				break;
				
				}
			}
			else {
				
				newPrompt.PromptCantGoDirection(5);
				UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				
			}
			break;
			
			default:
				
			JOptionPane.showMessageDialog(null, "Unrecognized input.");			
			UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags); 
			
		}
	}			
	public String Script(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {

		TxtAdventPrompts newPrompt = new TxtAdventPrompts();
		String retString = null;
		String roomIn = "You are in the " + roomName[room];
			switch (room) {
			
				case 31:
				try {
					enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
				} catch (Exception e) {
					e.printStackTrace();
				}
				int flagCheck = flags[10];
					switch(flagCheck) {
					case 0:
						retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptChestTxt(0) + newPrompt.PromptBasicScript(1)
						+  newPrompt.PromptChestTxt(2)));
						try {
							if(retString.isEmpty()) {
								
								JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
								UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							}
							else {
								return retString;
							}
							return retString;
						} catch (Exception e) {
						
							e.printStackTrace();
						}
						return retString;
					case 1:
						retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptChestTxt(1) + newPrompt.PromptBasicScript(1)));
						try {
							if(retString.isEmpty()) {
								
								JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
								UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							}
							else {
								return retString;
							}
							return retString;
						} catch (Exception e) {
		
							e.printStackTrace();
						}
						return retString;
					}
				break;
				
				case 32:
				try {
					enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
				} catch (Exception e) {
					e.printStackTrace();
				}
				flagCheck = flags[11];
					switch(flagCheck) {
					case 0:
						retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + "\nYou see a chest! Wonder what's inside.." + newPrompt.PromptBasicScript(0)
						+  newPrompt.PromptChestTxt(2)));
						try {
							if(retString.isEmpty()) {
								
								JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
								UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							}
							else {
								return retString;
							}
							return retString;
						} catch (Exception e) {
							e.printStackTrace();
						}
						return retString;
					case 1:
						retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptChestTxt(1) + newPrompt.PromptBasicScript(0)));
						try {
							if(retString.isEmpty()) {
								
								JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
								UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							}
							else {
								return retString;
							}
							return retString;
						} catch (Exception e) {
							e.printStackTrace();
						}
						return retString;
					}
				break;
				
				case 34:
				try {
					enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
				} catch (Exception e) {

					e.printStackTrace();
				}
				flagCheck = flags[12];
					switch(flagCheck) {
					case 0:
						retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptChestTxt(0) + newPrompt.PromptBasicScript(1)
						+  newPrompt.PromptChestTxt(2)));
						try {
							if(retString.isEmpty()) {
								
								JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
								UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							}
							else {
								return retString;
							}
							return retString;
						} catch (Exception e) {
							e.printStackTrace();
						}
						return retString;
					case 1:
						retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptChestTxt(1) + newPrompt.PromptBasicScript(1)));
						try {
							if(retString.isEmpty()) {
								
								JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
								UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							}
							else {
								return retString;
							}
							return retString;
						} catch (Exception e) {
							e.printStackTrace();
						}
						return retString;
					}
				break;
				
				case 35:
				try {
					enemyEnc(room, roomName, whereToGo, directions, myStats, invo, flags);
				} catch (Exception e) {
					e.printStackTrace();
				}
				flagCheck = flags[13];
					switch(flagCheck) {
					case 0:
						retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptChestTxt(0) + newPrompt.PromptBasicScript(0)
						+  newPrompt.PromptChestTxt(2)));
						try {
							if(retString.isEmpty()) {
								
								JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
								UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							}
							else {
								return retString;
							}
							return retString;
						} catch (Exception e) {
							e.printStackTrace();
						}
						return retString;
					case 1:
						retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptChestTxt(1) + newPrompt.PromptBasicScript(0)));
						try {
							if(retString.isEmpty()) {
								
								JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
								UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							}
							else {
								return retString;
							}
							return retString;
						} catch (Exception e) {
							e.printStackTrace();
						}
						return retString;
					}
				break;
				
				case 36:
					flagCheck = flags[15];
					switch(flagCheck) {
					case 0:
					retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(99)));
						try {
							if(retString.isEmpty()) {
								
								JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
								UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							}
							else {
								return retString;
							}
							return retString;
						} catch (Exception e) {
							e.printStackTrace();
						}
					return retString;
				
					case 1:
					retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(99)));
						try {
							if(retString.isEmpty()) {
								
								JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
								UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							}
							else {
								return retString;
							}
							return retString;
						} catch (Exception e) {
							e.printStackTrace();
						}
					return retString;
					case 2:
					retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(100)));
						try {
							if(retString.isEmpty()) {
								
								JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
								UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							}
							else {
								return retString;
							}
							return retString;
						} catch (Exception e) {
							e.printStackTrace();
						}
					return retString;
					
					}
					
				break;
				case 13:
					retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(19)));
				try {
					if(retString.isEmpty()) {
						
						JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
						UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					}
					else {
						return retString;
					}
					return retString;
				} catch (Exception e) {
					e.printStackTrace();
				}
					return retString;
				
				case 29:
					retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + "\nYou see a Door. " + newPrompt.PromptBasicScript(10)));
				try {
					if(retString.isEmpty()) {
						
						JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
						UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					}
					else {
						return retString;
					}
					return retString;
				} catch (Exception e) {
					e.printStackTrace();
				}
					return retString;
				
				case 30:
					retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(11)));
				try {
					if(retString.isEmpty()) {
						
						JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
						UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					}
					else {
						return retString;
					}
					return retString;
				} catch (Exception e) {
				
					e.printStackTrace();
				}
					return retString;
				
				case 33:
					retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(12)));
				try {
					if(retString.isEmpty()) {
						
						JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
						UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					}
					else {
						return retString;
					}
					return retString;
				} catch (Exception e) {
					e.printStackTrace();
				}
					return retString;
				
				
				default:
					newPrompt.PromptIncorrect();
					System.exit(0);
				break;
				
		}
			return retString;
	}
	public void enemyEnc(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		TxtAdventPrompts newPrompt = new TxtAdventPrompts();
		if (room == 31) {
			if (flags[6] == 0) {
			newPrompt.PromptDrake();
			flags[6] += 1;
			TxtAdventEncounters newEnc = new TxtAdventEncounters();
			try {
				newEnc.randStart(room, roomName, whereToGo, directions, myStats, invo, flags);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			else {
				newPrompt.PromptDrakeSafe();	
		
			}
		}
		else if (room == 32) {
			if (flags[7] == 0) {
			newPrompt.PromptDrake();
			flags[7] += 1;
			TxtAdventEncounters newEnc = new TxtAdventEncounters();
			try {
				newEnc.randStart(room, roomName, whereToGo, directions, myStats, invo, flags);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			else {
				newPrompt.PromptDrakeSafe();	
		
			}
		}
		else if (room == 34) {
			if (flags[8] == 0) {
				newPrompt.PromptDrake();
			flags[8] += 1;
			TxtAdventEncounters newEnc = new TxtAdventEncounters();
			try {
				newEnc.randStart(room, roomName, whereToGo, directions, myStats, invo, flags);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			else {
				newPrompt.PromptDrakeSafe();	
		
			}
		}
		else if (room == 35) {
			if (flags[9] == 0) {
				newPrompt.PromptDrake();
			flags[9] += 1;
			TxtAdventEncounters newEnc = new TxtAdventEncounters();
			try {
				newEnc.randStart(room, roomName, whereToGo, directions, myStats, invo, flags);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			else {
				newPrompt.PromptDrakeSafe();	
		
			}
		}	
		
	}
	
	
}
