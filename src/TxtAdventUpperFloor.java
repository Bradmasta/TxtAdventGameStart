
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TxtAdventUpperFloor implements WindowListener  {
	JFrame myWindow = new JFrame("Question");
	JPanel temp = new JPanel();
	
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
		
		

		try {
		String directChoice = Script(room, roomName, whereToGo, directions, myStats, invo, flags);
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
					DragonKeepStart(room, roomName, whereToGo, directions, myStats, invo, flags);
					
					
				}
				else if (flags[15] == 1) {
					newPrompt.PromptDragonKeepSecondSee();
					DragonKeepStart(room, roomName, whereToGo, directions, myStats, invo, flags);
					
					
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
		catch (NullPointerException | StringIndexOutOfBoundsException e) {
			System.out.println(" ");
			
		}

		
		
	
		
		
	}			
	public String Script(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		TxtAdventEncounters newEnc = new TxtAdventEncounters();
		TxtAdventPrompts newPrompt = new TxtAdventPrompts();
		String roomIn = "You are in the " + roomName[room];
		String retString = null;
			switch (room) {
			
				case 31:
					if (flags[6] == 0) {
						newPrompt.PromptDrake();
						flags[6] += 1;
						
						
							newEnc.randStart(room, roomName, whereToGo, directions, myStats, invo, flags);
						break;
						
					}
					else {
							newPrompt.PromptDrakeSafe();	
							int flagCheck = flags[10];
							switch(flagCheck) {
							case 0:
								retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptChestTxt(0) + newPrompt.PromptBasicScript(1)
								+  newPrompt.PromptChestTxt(2)));
									if(retString.isEmpty()) {
										
										JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
										UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
									}
									else {
										return retString;
									}
									return retString;
							case 1:
								retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptChestTxt(1) + newPrompt.PromptBasicScript(1)));
								
									if(retString.isEmpty()) {
										
										JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
										UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
									}
									else {
										return retString;
									}
									return retString;
								} 
					
							}
					
					
					
				
				case 32:
			
					if (flags[7] == 0) {
						newPrompt.PromptDrake();
						flags[7] += 1;
					
						
							newEnc.randStart(room, roomName, whereToGo, directions, myStats, invo, flags);
						break;
						
					}
					else {
						newPrompt.PromptDrakeSafe();
				int flagCheck = flags[11];
					switch(flagCheck) {
					case 0:
						retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + "\nYou see a chest! Wonder what's inside.." + newPrompt.PromptBasicScript(0)
						+  newPrompt.PromptChestTxt(2)));
						
							if(retString.isEmpty()) {
								
								JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
								UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							}
							else {
								return retString;
							}
							return retString;
					
					case 1:
						retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptChestTxt(1) + newPrompt.PromptBasicScript(0)));
						
							if(retString.isEmpty()) {
								
								JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
								UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							}
							else {
								return retString;
							}
							return retString;
						
					
					}
					}
				break;
				
				case 34:
					if (flags[8] == 0) {
						newPrompt.PromptDrake();
					flags[8] += 1;
					
					
						newEnc.randStart(room, roomName, whereToGo, directions, myStats, invo, flags);
					break;
				}
					else {
						newPrompt.PromptDrakeSafe();
			
				int flagCheck = flags[12];
					switch(flagCheck) {
					case 0:
						retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptChestTxt(0) + newPrompt.PromptBasicScript(1)
						+  newPrompt.PromptChestTxt(2)));
						
							if(retString.isEmpty()) {
								
								JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
								UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							}
							else {
								return retString;
							}
							return retString;
						
					
					case 1:
						retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptChestTxt(1) + newPrompt.PromptBasicScript(1)));
						
							if(retString.isEmpty()) {
								
								JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
								UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							}
							else {
								return retString;
							}
							return retString;
						
					}
					}
				break;
				
				case 35:
					if (flags[9] == 0) {
						newPrompt.PromptDrake();
					flags[9] += 1;
				
					
						newEnc.randStart(room, roomName, whereToGo, directions, myStats, invo, flags);
						break;
					}
					else {
						newPrompt.PromptDrakeSafe();
				int flagCheck = flags[13];
					switch(flagCheck) {
					case 0:
						retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptChestTxt(0) + newPrompt.PromptBasicScript(0)
						+  newPrompt.PromptChestTxt(2)));
						
							if(retString.isEmpty()) {
								
								JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
								UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							}
							else {
								return retString;
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
					}
				break;
				
				case 36:
					int flagCheck = flags[15];
					switch(flagCheck) {
					case 0:
					retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(99)));
						
							if(retString.isEmpty()) {
								
								JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
								UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							}
							else {
								return retString;
							}
							return retString;
						
				
					case 1:
					retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(99)));
						
							if(retString.isEmpty()) {
								
								JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
								UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							}
							else {
								return retString;
							}
							return retString;
						
					case 2:
					retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(100)));
						
							if(retString.isEmpty()) {
								
								JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
								UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							}
							else {
								return retString;
							}
							return retString;
						
					
					}
					
				break;
				case 13:
					retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(19)));
				
					if(retString.isEmpty()) {
						
						JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
						UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					}
					else {
						return retString;
					}
	
					break;
				
				case 29:
					flagCheck = flags[14];
					switch(flagCheck) {
					case 0:
						retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + "\nYou see a Door. " + newPrompt.PromptBasicScript(10)));
						
							if(retString.isEmpty()) {
								
								JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
								UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							}
							else {
								return retString;
							}
							return retString;
						
			
				
					case 1:
						retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + "\nYou see an unlocked door." + newPrompt.PromptBasicScript(10)));
						
							if(retString.isEmpty()) {
								
								JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
								UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							}
							else {
								return retString;
							}
							return retString;
						
					
					}
					break;
				case 30:
					retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(11)));
				
					if(retString.isEmpty()) {
						
						JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
						UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					}
					else {
						return retString;
					}
					break;
				
				
				case 33:
					retString = nullCheck.nullCheck(JOptionPane.showInputDialog(null, roomIn + newPrompt.PromptBasicScript(12)));
				
					if(retString.isEmpty()) {
						
						JOptionPane.showMessageDialog(null, newPrompt.PromptNeedType());
						UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					}
					else {
						return retString;
					}
					return retString;
				
			
				
				
				default:
					newPrompt.PromptIncorrect();
					System.exit(0);
				break;
		
		}
			return retString;		
	}
	public void DragonKeepStart(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
    	
    	TxtAdventPrompts newPrompt = new TxtAdventPrompts();

        Button a;
        Button b;
        Button c;
        Button d;
    	
    	TxtAdventRandNum newRand = new TxtAdventRandNum();
    	//int question = newRand.randDragonKeepQuestion();
    	int question = 1;
    	
        
        myWindow.setSize(500,300);
        myWindow.setLocationRelativeTo(null);
        myWindow.setContentPane(temp);
        
        myWindow.setLayout(new FlowLayout());
        myWindow.addWindowListener(this);
        myWindow.setLayout(new GridBagLayout());
        GridLayout layout = new GridLayout(0,1);
        layout.setHgap(10);
        layout.setVgap(10);
        myWindow.setLayout(layout);
        
		JOptionPane.showMessageDialog(null, "Here is your question: ");
			JLabel label = new JLabel("How many miles away is the sun from the earth (Approximately)?", SwingConstants.CENTER);
			a = new Button("90 Million");
            b = new Button("97 Million");
            c = new Button("93 Million");
            d = new Button("85 Million");
     
            
            myWindow.add(label);
            myWindow.add(a, layout);

            myWindow.add(b, layout);
            myWindow.add(c, layout);

            myWindow.add(d, layout);
            myWindow.setVisible(true);
            a.addActionListener(new ActionListener() {
            	public void actionPerformed (ActionEvent a) {
            		TxtAdventDungeon dgFlr = new TxtAdventDungeon();
        
            		 myWindow.dispose();
                   	 newPrompt.PromptQRightWrong(1);
               		 myStats[0] =  myStats[0] / 2;
            		 flags[15] = 1;
            		 int room = whereToGo[25][6];
            			
            		dgFlr.DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
            		
            		
            	}
            	
            	
            });
            b.addActionListener(new ActionListener() {
            	public void actionPerformed (ActionEvent a) {
            		TxtAdventDungeon dgFlr = new TxtAdventDungeon();
            		 myWindow.dispose();
                   	 newPrompt.PromptQRightWrong(1);
            				myStats[0] =  myStats[0] / 2;
            			flags[15] = 1;
            			int room = whereToGo[25][6];
            		
            				dgFlr.DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
            		
   
            		
            	}
            	
            	
            });
            c.addActionListener(new ActionListener() {
            	public void actionPerformed (ActionEvent a) {
            		TxtAdventUpperFloor upFlr = new TxtAdventUpperFloor();
            		myWindow.dispose();
                 	 newPrompt.PromptQRightWrong(0);
          			 flags[15] = 2;
          	
          			
          				upFlr.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
            		
            	}
            	
            	
            });
            d.addActionListener(new ActionListener() {
            	public void actionPerformed (ActionEvent a) {
            		TxtAdventDungeon dgFlr = new TxtAdventDungeon();
            		 myWindow.dispose();
                   	 newPrompt.PromptQRightWrong(1);
            				myStats[0] =  myStats[0] / 2;
            			flags[15] = 1;
            			int room = whereToGo[25][6];
            			
            				dgFlr.DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
            			
            	}
            	
            	
            });
			
	
	
		
		
    	/*case 2:

    		label = new JLabel("Which of these colors is not on the Rubik's Cube?", SwingConstants.CENTER);
    		a = new Button("Blue");
    		b = new Button("Purple");
    		c = new Button("Yellow");
    		d = new Button("Green");
 
        
    		myWindow.add(label);
    		myWindow.add(a, layout);

    		myWindow.add(b, layout);

    		myWindow.add(c, layout);

    		myWindow.add(d, layout);
    		myWindow.setVisible(true);
    		a.addActionListener(this);
    		b.addActionListener(this);
    		c.addActionListener(this);
    		d.addActionListener(this);
    		actionPerformed(null);
    		break;
        
    	case 3:

        	label = new JLabel("What does \"RAM\" stand for?", SwingConstants.CENTER);
        	a = new Button("Random Available Memory");
            b = new Button("Readily Available Memory");
            c = new Button("Run All Memory ");
            d = new Button("Random Access Memory");
     
            
            myWindow.add(label);
            myWindow.add(a, layout);

            myWindow.add(b, layout);

            myWindow.add(c, layout);

            myWindow.add(d, layout);
            myWindow.setVisible(true);
            a.addActionListener(this);
            b.addActionListener(this);
            c.addActionListener(this);
            d.addActionListener(this);
            break;
            
    	case 4:
        	label = new JLabel("Which of these Intel Cores types doesn't exist? ", SwingConstants.CENTER);
        	a = new Button("I-1");
            b = new Button("I-3");
            c = new Button("I-5");
            d = new Button("I-7");
     
            
            myWindow.add(label);
            myWindow.add(a, layout);

            myWindow.add(b, layout);

            myWindow.add(c, layout);

            myWindow.add(d, layout);
            myWindow.setVisible(true);
            a.addActionListener(this);
            b.addActionListener(this);
            c.addActionListener(this);
            d.addActionListener(this);
            break;
            
    	case 5:
        	label = new JLabel("Which month(s) have(has) 28 days?", SwingConstants.CENTER);
        	a = new Button("6 months");
            b = new Button("7 months");
            c = new Button("1 month");
            d = new Button("All of them");
     
            
            myWindow.add(label);
            myWindow.add(a, layout);

            myWindow.add(b, layout);

            myWindow.add(c, layout);

            myWindow.add(d, layout);
            myWindow.setVisible(true);
            a.addActionListener(this);
            b.addActionListener(this);
            c.addActionListener(this);
            d.addActionListener(this);
            break;
            
    	case 6:
        	label = new JLabel("How many NFL teams are there?", SwingConstants.CENTER);
        	a = new Button("29");
            b = new Button("30");
            c = new Button("32");
            d = new Button("42");
     
            
            myWindow.add(label);
            myWindow.add(a, layout);

            myWindow.add(b, layout);

            myWindow.add(c, layout);

            myWindow.add(d, layout);
            myWindow.setVisible(true);
            a.addActionListener(this);
            b.addActionListener(this);
            c.addActionListener(this);
            d.addActionListener(this);
            break;
            
    	case 7:
        	label = new JLabel("What type of programming language is \"Java\"?", SwingConstants.CENTER);
        	a = new Button("Object Creating");
            b = new Button("Object Oriented");
            c = new Button("Scripted");
            d = new Button("Low Level");
     
            
            myWindow.add(label);
            myWindow.add(a, layout);

            myWindow.add(b, layout);

            myWindow.add(c, layout);

            myWindow.add(d, layout);
            myWindow.setVisible(true);
            a.addActionListener(this);
            b.addActionListener(this);
            c.addActionListener(this);
            d.addActionListener(this);
            break;
            
    	case 8:
        	label = new JLabel("How many stomachs does a Cow have?", SwingConstants.CENTER);
        	a = new Button("2");
            b = new Button("6");
            c = new Button("1");
            d = new Button("4");
     
            
            myWindow.add(label);
            myWindow.add(a, layout);

            myWindow.add(b, layout);

            myWindow.add(c, layout);

            myWindow.add(d, layout);
            myWindow.setVisible(true);
            a.addActionListener(this);
            b.addActionListener(this);
            c.addActionListener(this);
            d.addActionListener(this);
            break;
            
    	case 9:
        	label = new JLabel("How many bones does a fully grown adult have?", SwingConstants.CENTER);
        	a = new Button("200");
            b = new Button("150");
            c = new Button("206");
            d = new Button("214");
     
            
            myWindow.add(label);
            myWindow.add(a, layout);

            myWindow.add(b, layout);

            myWindow.add(c, layout);

            myWindow.add(d, layout);
            myWindow.setVisible(true);
            a.addActionListener(this);
            b.addActionListener(this);
            c.addActionListener(this);
            d.addActionListener(this);
            break;
            
    	case 10:
        	label = new JLabel("How many buttons does a Guitar Hero controller have?", SwingConstants.CENTER);
        	a = new Button("3");
            b = new Button("4");
            c = new Button("5");
            d = new Button("6");
     
            
            myWindow.add(label);
            myWindow.add(a, layout);

            myWindow.add(b, layout);

            myWindow.add(c, layout);

            myWindow.add(d, layout);
            myWindow.setVisible(true);
            a.addActionListener(this);
            b.addActionListener(this);
            c.addActionListener(this);
            d.addActionListener(this);
            break;*/
           /* default:
            JOptionPane.showMessageDialog(null, "Test");
            break;*/

	
	}
	
    

	
	@Override
    public void windowClosing(WindowEvent e) {
    	
    	myWindow.dispose();
            System.exit(0);
    }
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
}
