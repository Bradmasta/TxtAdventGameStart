import javax.swing.JOptionPane;

public class TxtAdventInvoCheck {
	TxtAdventMainFloor newRoom = new TxtAdventMainFloor();
	TxtAdventDungeon newDungeon = new TxtAdventDungeon();
	TxtAdventUpperFloor newUpper = new TxtAdventUpperFloor();
	TxtAdventNullCheck nullCheck = new TxtAdventNullCheck();
	TxtAdventEncounters newEnc = new TxtAdventEncounters();
	TxtAdventPrompts newPrompt = new TxtAdventPrompts();
	int randEnc = 3;
	
		public void invoCheck(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
			

				String invoInfo = nullCheck.nullCheck(JOptionPane.showInputDialog(null, "Your Stats: \nHealth: " + myStats[0] + "\nAttack: " + myStats[1] + "\nDefense: " + myStats[2] + "\nSpeed: " + myStats[3] + 
				"\n\nYour Inventory:\n Health Potion: " + invo[0] + "\n Attack Potion: " + invo[1] + "\n Defense Potion: " + invo[2] + "\n Speed Potion: " 
				+ invo[3] + "\n Downstairs Key: " 
				+ invo[4] + "\n Upstairs Key: " + invo[5] + "\n Final Key: " + invo[6] + "\n\nUse a potion, or return to the game? \n\n1) Return to the game\n2) Use a potion\n3) Not ready to go back just yet.."));
				if (invoInfo.equals("1")) {
					JOptionPane.showMessageDialog(null, "And we continue!");
					if (room >=0 && room < 13 && room != 4) {
					flags[18] = 1;
					newRoom.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				
		
					}
					else if (room > 13 && room < 29 || room == 4) {
					flags[18] = 1;
					newDungeon.DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);	
	
					}
					else if (room >= 29 || room == 13) {
					flags[18] = 1;
					newUpper.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);

					}
					
				}
				else if (invoInfo.equals("2")) {
					 String choice;
						
					 choice = nullCheck.nullCheck(JOptionPane.showInputDialog("Which potion do you want to use?\n\n1) Health Potion: " + invo[0] + "\n2) Attack Potion: " + invo[1] + "\n3) Defense Potion: " + invo[2] +
								"\n4) Speed Potion: " + invo[3] + "\n5) Go back"));
					
					 switch (choice) {
					 
					 case "1":
						 int hpHeal = myStats[0] + 10;
						  if (invo[0] > 0) {
						  int hpUsed = invo[0] - 1;
						  JOptionPane.showMessageDialog(null, "You use a Health potion! It increases your Health to " + hpHeal);
						  myStats[0] = hpHeal;
						  invo[0] = hpUsed;
						  invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
						  break;
						  }
						  else {
							  JOptionPane.showMessageDialog(null, "You don't have any health potions.");
							  invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
						
						  }
						 break;
					 case "2":
						 int attkBoost = myStats[1] + 5;
						  if (invo[1] > 0) {
						  int attkUsed = invo[1] - 1;
						  JOptionPane.showMessageDialog(null, "You use an Attack potion! It increases your Attack to " + attkBoost);
						  myStats[1] = attkBoost;
						  invo[1] = attkUsed;
						  invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
						  break;
						  }
						  else {
							  JOptionPane.showMessageDialog(null, "You don't have any attack potions.");
							  invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
						  }
						 break;
					 case "3":
						 int defBoost = myStats[2] + 5;
						  if (invo[2] > 0) {
						  int defUsed = invo[2] - 1;
						  JOptionPane.showMessageDialog(null, "You use a Defense potion! It increases your Defence to " + defBoost);
						  myStats[2] = defBoost;
						  invo[2] = defUsed;
						  invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
						  break;
						  }
						  else {
							  JOptionPane.showMessageDialog(null, "You don't have any defense potions.");
							  invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
					
						  }
						 break;
					 case "4":
						 int spdBoost = myStats[3] + 5;
						  if (invo[3] > 0) {
						  int spdUsed = invo[3] - 1;
						  JOptionPane.showMessageDialog(null, "You use a Speed Potion! It increases your Speed to " + spdBoost);
						  myStats[3] = spdBoost;
						  invo[3] = spdUsed;
						  invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
						  break;
						  }
						  else {
							  JOptionPane.showMessageDialog(null, "You don't have any speed potions.");
							  invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
				
						  }
						 break;
					 case "5":
						 invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
						 break;
					 default:
						 if(choice.isEmpty()) {
								JOptionPane.showMessageDialog(null, "You need to type something.");
								invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
								break;
										}
						 else {
						 JOptionPane.showMessageDialog(null, "Not a valid Input.");
						invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
						break;
						 }

					 }
		
							
							
					
				}
				else if (invoInfo.equals("3")) {
					if (randEnc == 3) {
						JOptionPane.showMessageDialog(null, "You should consider returning! Enemys lurk about!");
						randEnc -= 1;
						invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);	
			
						
					}
					else if (randEnc == 2) {
						JOptionPane.showMessageDialog(null, "You really should consider returning...");
						randEnc -= 1;
						invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);	
					
						
					}
					else if (randEnc == 1) {
						JOptionPane.showMessageDialog(null, "Don't say you weren't warned! I did warn you!");
						randEnc -= 1;
						invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);	
					
						
					}
					else {
						if (room >=0 && room < 13 && room != 4) {
							newPrompt.PromptDarkKnight();
							newEnc.randStart(room, roomName, whereToGo, directions, myStats, invo, flags);
						
							}
							else if (room > 13 && room < 29 || room == 4) {
								newPrompt.PromptHellHound();
							newEnc.randStart(room, roomName, whereToGo, directions, myStats, invo, flags);	
						
							}
							else if (room >= 29 || room == 13) {
							newPrompt.PromptDrake();
							newEnc.randStart(room, roomName, whereToGo, directions, myStats, invo, flags);
						
								
							}
						
					}
	
				}
				else {
					if(invoInfo.isEmpty()) {
						JOptionPane.showMessageDialog(null, "You need to type something.");
						
						invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
				
						}
					else {
						
						JOptionPane.showMessageDialog(null, "Invalid input");
						invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
					}
				}
				
				
					
						
					
				}
			 
		
		
		
		public void endGame() {
			 JOptionPane.showMessageDialog(null, "More to come; Game still in construction!");
			System.exit(0);
		}
		
}
		
  



