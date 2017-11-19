import java.util.InputMismatchException;
import javax.swing.JOptionPane;
public class TxtAdventEncounters {
	TxtAdventNullCheck nullCheck = new TxtAdventNullCheck();
	TxtAdventRandNum newRand = new TxtAdventRandNum();
	TxtAdventUpperFloor upperRoom = new TxtAdventUpperFloor();
	TxtAdventMainFloor mainRoom = new TxtAdventMainFloor();
	TxtAdventDungeon dunRoom = new TxtAdventDungeon();
	TxtAdventPrompts newPrompt = new TxtAdventPrompts();
	public void randStart(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		if (room >=0 && room < 13 && room != 4) {

			int enemyStats[] = {15, 7, 3, newRand.randEasyEnemySpd()};
			randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
			}
			else if (room > 13 && room < 29 || room == 4) {
				 int enemyStats[] = {25, 8, 6, newRand.randMedEnemySpd()};
				randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
			}
			else if (room >= 29 || room == 13) {
				int enemyStats[] = {40, 15, 10, newRand.randHardEnemySpd()};
				randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
				
			}
		  
	  }
	  public void randEncounter(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] enemyStats, int[] invo, int[] flags) {
			
		  

		  
		while (myStats[0] > 0 || enemyStats[0] > 0) {
		int battleChoice = 0;
		  if (myStats[0] <= 0 || enemyStats[0] <= 0) {
			  if (myStats[0] <= 0) {
				  JOptionPane.showMessageDialog(null, "You lost..Good luck next time!");
				  System.exit(0);
			  }
			  if (enemyStats[0] <= 0) {
				  String win = "You Won! \n";
				  if (room >=0 && room < 13 && room != 4) {
						if (newRand.randBattleReward() <= 4) {
							  JOptionPane.showMessageDialog(null, win + "You received an Attack boost potion!");
							  invo[1] += 1;
							  mainRoom.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							  break;
							 
						  }
						  else if (newRand.randBattleReward() > 4 && newRand.randBattleReward() <= 8) {
							  JOptionPane.showMessageDialog(null, win + "You received a Defense boost potion!");
							  invo[2] += 1;
			
							  mainRoom.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							  break;
							 
						  }
						  else if (newRand.randBattleReward() > 8 && newRand.randBattleReward()<= 12) {
							  JOptionPane.showMessageDialog(null, win + "You received a Speed boost potion!");
							  invo[3] += 1;

							  mainRoom.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							  break;
							 
						  }
						  else if (newRand.randBattleReward() > 12 && newRand.randBattleReward() <= 18) {
							  JOptionPane.showMessageDialog(null, win + "You received a Health boost potion!"); 
							  invo[0] += 1;

							  mainRoom.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							  break;
							 
						  }
						  else {
						  JOptionPane.showMessageDialog(null, win + "You didn't receive anything this time.");
						  mainRoom.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
						  break;
						  }
						}
						else if (room > 13 && room < 29 || room == 4) {
							 if (newRand.randBattleReward() <= 2) {
								  JOptionPane.showMessageDialog(null, win + "You received an Attack boost potion!");
								  invo[1] += 1;

								  dunRoom.DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
								  break;
								 
							  }
							  else if (newRand.randBattleReward() > 2 && newRand.randBattleReward() <= 4) {
								  JOptionPane.showMessageDialog(null, win + "You received a Defense boost potion!");
								  invo[2] += 1;
				
								  dunRoom.DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
								  break;
								 
							  }
							  else if (newRand.randBattleReward() > 4 && newRand.randBattleReward()<= 6) {
								  JOptionPane.showMessageDialog(null, win + "You received a Speed boost potion!"); 
								  invo[3] += 1;

								  dunRoom.DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
								  break;
								 
							  }
							  else if (newRand.randBattleReward() > 6 && newRand.randBattleReward() <= 16) {
								  JOptionPane.showMessageDialog(null, win + "You received a Health boost potion!");  
								  invo[0] += 1;

								  dunRoom.DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
								  break;
								 
							  }
							  else {
							  JOptionPane.showMessageDialog(null, win + "You didn't receive anything this time.");
							  dunRoom.DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							  break;
							  }
						}
						else if (room >= 29 || room == 13) {
							 if (newRand.randBattleReward() <= 1) {
								  JOptionPane.showMessageDialog(null, win + "You received an Attack boost potion!");
								  invo[1] += 1;

								  upperRoom.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
								  break;
								 
							  }
							  else if (newRand.randBattleReward() > 1 && newRand.randBattleReward() <= 3) {
								  JOptionPane.showMessageDialog(null, win + "You received an Defense boost potion!");
								  invo[2] += 1;
				
								  upperRoom.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
								  break;
								 
							  }
							  else if (newRand.randBattleReward() > 3 && newRand.randBattleReward()<= 6) {
								  JOptionPane.showMessageDialog(null, win + "You received an Speed boost potion!");
								  invo[3] += 1;

								  upperRoom.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
								  break;
								 
							  }
							  else if (newRand.randBattleReward() > 6 && newRand.randBattleReward() <= 18) {
								  JOptionPane.showMessageDialog(null, win + "You received an Health boost potion!");
								  invo[0] += 1;

								  upperRoom.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
								  break;
								 
							  }
							  else {
							  JOptionPane.showMessageDialog(null, win + "You didn't receive anything this time.");
							  upperRoom.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							  break;
							  }
							
						}
			  }
		  }
		  else if(myStats[3] < enemyStats[3]) {
			  enemyCombat(room, enemyStats, myStats);
			 
			  while(battleChoice == 0) {
					if (room >=0 && room < 13 && room != 4) {
					 String battleInfo = nullCheck.nullCheck(JOptionPane.showInputDialog(null, "Your Stats:\n HP: " + myStats[0] + "\n Attack: " + myStats[1] + "\n Defense: " + myStats[2] + "\n Speed: " + myStats[3] + "\n\n\n"
					  + "Dark Knight Stats:\n HP: " + enemyStats[0] + "\n Attack: " + enemyStats[1] + "\n Defense: " + enemyStats[2] + "\n Speed: " + enemyStats[3] + 
					  "\n\n\n What do you want to do? \n\n\n1) Attack\n2) Inventory\n3) Run"));
					 emptyField(battleInfo, room, roomName, whereToGo, directions, myStats, invo, flags);
					  switch(battleInfo) {
						 case "1":
							 battleChoice = Integer.parseInt(battleInfo);
							 break;
						 case "2":
							 battleChoice = Integer.parseInt(battleInfo);
							 break;
						 case "3":
							 battleChoice = Integer.parseInt(battleInfo);
							 break;
						 default:
							 JOptionPane.showMessageDialog(null, "Not a valid option");
							 break;
						 }
				  }
					else if (room > 13 && room < 29 || room == 4) {
						String battleInfo = nullCheck.nullCheck(JOptionPane.showInputDialog(null, "Your Stats:\n HP: " + myStats[0] + "\n Attack: " + myStats[1] + "\n Defense: " + myStats[2] + "\n Speed: " + myStats[3] + "\n\n\n"
								  + "Hellhound Stats:\n HP: " + enemyStats[0] + "\n Attack: " + enemyStats[1] + "\n Defense: " + enemyStats[2] + "\n Speed: " + enemyStats[3] + 
								  "\n\n\n What do you want to do? \n\n\n1) Attack\n2) Inventory\n3) Run"));
						emptyField(battleInfo, room, roomName, whereToGo, directions, myStats, invo, flags);
						  switch(battleInfo) {
							 case "1":
								 battleChoice = Integer.parseInt(battleInfo);
								 break;
							 case "2":
								 battleChoice = Integer.parseInt(battleInfo);
								 break;
							 case "3":
								 battleChoice = Integer.parseInt(battleInfo);
								 break;
							 default:
								 JOptionPane.showMessageDialog(null, "Not a valid option");
								 break;
							 }
					  }
					else if (room >= 29 || room == 13) {
						String battleInfo = nullCheck.nullCheck(JOptionPane.showInputDialog(null, "Your Stats:\n HP: " + myStats[0] + "\n Attack: " + myStats[1] + "\n Defense: " + myStats[2] + "\n Speed: " + myStats[3] + "\n\n\n"
								  + "Drake Stats:\n HP: " + enemyStats[0] + "\n Attack: " + enemyStats[1] + "\n Defense: " + enemyStats[2] + "\n Speed: " + enemyStats[3] + 
								  "\n\n\n What do you want to do? \n\n\n1) Attack\n2) Inventory\n3) Run")); 
						emptyField(battleInfo, room, roomName, whereToGo, directions, myStats, invo, flags);
						  switch(battleInfo) {
							 case "1":
								 battleChoice = Integer.parseInt(battleInfo);
								 break;
							 case "2":
								 battleChoice = Integer.parseInt(battleInfo);
								 break;
							 case "3":
								 battleChoice = Integer.parseInt(battleInfo);
								 break;
							 default:
								 JOptionPane.showMessageDialog(null, "Not a valid option");
								 break;
							 }
					  }
					
					}
			  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags, battleChoice);
			  }

		  else if (myStats[3] >= enemyStats[3]){
			  while(battleChoice == 0) {
					if (room >=0 && room < 13 && room != 4) {
					 String battleInfo = nullCheck.nullCheck(JOptionPane.showInputDialog(null, "Your Stats:\n HP: " + myStats[0] + "\n Attack: " + myStats[1] + "\n Defense: " + myStats[2] + "\n Speed: " + myStats[3] + "\n\n\n"
					  + "Dark Knight Stats:\n HP: " + enemyStats[0] + "\n Attack: " + enemyStats[1] + "\n Defense: " + enemyStats[2] + "\n Speed: " + enemyStats[3] + 
					  "\n\n\n What do you want to do? \n\n\n1) Attack\n2) Inventory\n3) Run"));
					 emptyField(battleInfo, room, roomName, whereToGo, directions, myStats, invo, flags);
					  switch(battleInfo) {
						 case "1":
							 battleChoice = Integer.parseInt(battleInfo);
							 break;
						 case "2":
							 battleChoice = Integer.parseInt(battleInfo);
							 break;
						 case "3":
							 battleChoice = Integer.parseInt(battleInfo);
							 break;
						 default:
							 JOptionPane.showMessageDialog(null, "Not a valid option");
							 break;
						 }
				  }
					else if (room > 13 && room < 29 || room == 4) {
						String battleInfo = nullCheck.nullCheck(JOptionPane.showInputDialog(null, "Your Stats:\n HP: " + myStats[0] + "\n Attack: " + myStats[1] + "\n Defense: " + myStats[2] + "\n Speed: " + myStats[3] + "\n\n\n"
								  + "Hellhound Stats:\n HP: " + enemyStats[0] + "\n Attack: " + enemyStats[1] + "\n Defense: " + enemyStats[2] + "\n Speed: " + enemyStats[3] + 
								  "\n\n\n What do you want to do? \n\n\n1) Attack\n2) Inventory\n3) Run"));
						emptyField(battleInfo, room, roomName, whereToGo, directions, myStats, invo, flags);
						  switch(battleInfo) {
							 case "1":
								 battleChoice = Integer.parseInt(battleInfo);
								 break;
							 case "2":
								 battleChoice = Integer.parseInt(battleInfo);
								 break;
							 case "3":
								 battleChoice = Integer.parseInt(battleInfo);
								 break;
							 default:
								 JOptionPane.showMessageDialog(null, "Not a valid option");
								 break;
							 }
					  }
					else if (room >= 29 || room == 13) {
						String battleInfo = nullCheck.nullCheck(JOptionPane.showInputDialog(null, "Your Stats:\n HP: " + myStats[0] + "\n Attack: " + myStats[1] + "\n Defense: " + myStats[2] + "\n Speed: " + myStats[3] + "\n\n\n"
								  + "Drake Stats:\n HP: " + enemyStats[0] + "\n Attack: " + enemyStats[1] + "\n Defense: " + enemyStats[2] + "\n Speed: " + enemyStats[3] + 
								  "\n\n\n What do you want to do? \n\n\n1) Attack\n2) Inventory\n3) Run")); 
						emptyField(battleInfo, room, roomName, whereToGo, directions, myStats, invo, flags);
						  switch(battleInfo) {
							 case "1":
								 battleChoice = Integer.parseInt(battleInfo);
								 break;
							 case "2":
								 battleChoice = Integer.parseInt(battleInfo);
								 break;
							 case "3":
								 battleChoice = Integer.parseInt(battleInfo);
								 break;
							 default:
								 JOptionPane.showMessageDialog(null, "Not a valid option");
								 break;
							 }
					  }
					
					}
			  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags, battleChoice);
			  enemyCombat(room, enemyStats, myStats);
		  }

	 
		 
			  }
		  }
	
	  public int combatVerify(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] enemyStats, int[] invo, int[] flags, int battleChoice) {
			final int RETRY = 0;
			
			while (RETRY >= 0) {


				try {
					if (battleChoice == 1) {
						return battleChoice;
						
					}
					else if (battleChoice == 2) {
						return battleChoice;
					}
					else if (battleChoice == 3) {
						if (myStats[3] > enemyStats[3]) {
							if (room >=0 && room < 13 && room != 4) {
								newPrompt.PromptSafely();
								mainRoom.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
								break;
								}
								else if (room > 13 && room < 29 || room == 4) {
								newPrompt.PromptSafely(); 
								dunRoom.DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
								break;
								}
								else if (room >= 29 || room == 13) {
								newPrompt.PromptSafely();
								upperRoom.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
								break;
									
								}
			
							  }
							  else {
								  JOptionPane.showMessageDialog(null, "Can't escape!"); 
							  }
						
						break;
					}
					else {
						JOptionPane.showMessageDialog(null, "Not a valid option"); 
					}
					
				}
				catch (InputMismatchException error) {
					JOptionPane.showMessageDialog(null, "Can't use letters/symbols/other nonsense here!"); 

				}
			}
			return battleChoice;



		}
	  
	  public void myCombat(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] enemyStats, int[] invo, int[] flags, int battleChoice) {
		  int hpChangeAttk = 0;
		  int hpUsed = invo[0];
		  int attk = myStats[1] - enemyStats[2];
		  int combatChoice = combatVerify(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags, battleChoice);

		  
		  if (combatChoice == 1) {
			  if (myStats[1] < enemyStats[2]) {
				  JOptionPane.showMessageDialog(null, "Your Attack isn't high enough to do damage to the enemy!"); 
				  
			  }
		  else {
			  if (room >=0 && room < 13 && room != 4) {
				  if (newRand.randAttkSuccess() > 1) {
					  hpChangeAttk = enemyStats[0] - attk;
					  if (hpChangeAttk > 0) {
							 enemyStats[0] = hpChangeAttk;
							 }
							 else {
							enemyStats[0] = 0;
							 }
					  JOptionPane.showMessageDialog(null, "The attack is successful! You deal " + attk + " damage!");  
					  
				  }
				  else {
					  hpChangeAttk = enemyStats[0];
					  JOptionPane.showMessageDialog(null, "You attack isn't successful."); 
				  
				  }
					}
					else if (room > 13 && room < 29 || room == 4) {
						if (newRand.randAttkSuccess() > 1) {
							  hpChangeAttk = enemyStats[0] - attk;
							 if (hpChangeAttk > 0) {
							 enemyStats[0] = hpChangeAttk;
							 }
							 else {
							enemyStats[0] = 0;
							 }
							 JOptionPane.showMessageDialog(null, "The attack is successful! You deal " + attk + " damage!");
						  
							  
						  }
						  else {
							  hpChangeAttk = enemyStats[0];
							  JOptionPane.showMessageDialog(null, "You attack isn't successful.");
							  
						  }
					}
					else if (room >= 29 || room == 13) {
						 if (newRand.randAttkSuccess() > 2) {
							  hpChangeAttk = enemyStats[0] - attk;
							 if (hpChangeAttk > 0) {
							 enemyStats[0] = hpChangeAttk;
							 }
							 else {
							enemyStats[0] = 0;
							 }
							 JOptionPane.showMessageDialog(null, "The attack is successful! You deal " + attk + " damage!");
							  
							  
						  }
						  else {
							  hpChangeAttk = enemyStats[0];
							  JOptionPane.showMessageDialog(null, "You attack isn't successful.");
							  
						  }
						
					}
		  		}
		  
		  } 
		  else if (combatChoice == 2) {
				 final int RETRY = 0;
				 String choice;
				 while (RETRY >= 0) {
					 choice = JOptionPane.showInputDialog("Your Inventory:\n Health Potion: " + invo[0] + "\n Attack Boost: " + invo[1] + "\n Defence Boost: " + invo[2] +
								"\n Speed Boost: " + invo[3] + "\n Downstairs Key: " + invo[4] + "\n Upstairs Key: " + invo[5] + "\n Final Key: " + invo[6] +
								"\nSelect item to use or return to battle? \n1) Use Health Potion\n2) Use Attack Potion\n3) Use Defence Potion\n4) Use Speed Potion"
								+ "\n5) Return to battle!");
					 emptyField(choice, room, roomName, whereToGo, directions, myStats, invo, flags);
						try {
							int number = 0;
							try {
								number = Integer.parseInt(choice);
								}
								catch (NumberFormatException error) {
									JOptionPane.showMessageDialog(null, "Not a valid option");
								}
							if (number == 1) {
								  int hpHeal = myStats[0] + 10;
								  if (invo[0] > 0) {
								  hpUsed = invo[0] - 1;
								  JOptionPane.showMessageDialog(null, "You use a health potion! It increases your health to " + hpHeal);
								  myStats[0] = hpHeal;
								  invo[0] = hpUsed;
								  }
								  else {
									  JOptionPane.showMessageDialog(null, "You don't have any health potions.");
								  }
								
							}
							else if (number == 2) {
								  int attkBoost = myStats[1] + 5;
								  if (invo[1] > 0) {
								  int attkUsed = invo[1] - 1;
								  JOptionPane.showMessageDialog(null, "You use an attack potion! It increases your attack to " + attkBoost);
								  myStats[1] = attkBoost;
								  invo[1] = attkUsed;
								  }
								  else {
									  JOptionPane.showMessageDialog(null, "You don't have any attack potions.");
								  }
								
							}
							else if (number == 3) {
								  int defBoost = myStats[2] + 5;
								  if (invo[2] > 0) {
								  int defUsed = invo[2] - 1;
								  JOptionPane.showMessageDialog(null, "You use a potion! It increases your defence to " + defBoost);
								  myStats[2] = defBoost;
								  invo[2] = defUsed;
								  }
								  else {
									  JOptionPane.showMessageDialog(null, "You don't have any defense potions.");
								  }
								
							}
							else if (number == 4) {
								  int spdBoost = myStats[3] + 1;
								  if (invo[3] > 0) {
								  int spdUsed = invo[3] - 1;
								  JOptionPane.showMessageDialog(null, "You use a potion! It increases your speed to " + spdBoost);
								  myStats[3] = spdBoost;
								  invo[3] = spdUsed;
								  }
								  else {
									  JOptionPane.showMessageDialog(null, "You don't have any speed potions.");
								  }
								
							}
							else if (number == 5) {
								JOptionPane.showMessageDialog(null, "Back to the battle! Good luck!");
								randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
							}
							
							else {
								JOptionPane.showMessageDialog(null, "Not a valid option");
								
						
							}
							break;
						}
						catch (InputMismatchException error) {
							
							JOptionPane.showMessageDialog(null, "Can't use letters/symbols/other nonsense here!");
						}
						break;
					}
				 
				  
			  }
	  }

	  
	  public void enemyCombat(int room, int[] enemyStats, int[] myStats) {
		  int hpChange = 0;
		  int attk = enemyStats[1] - myStats[2];
			if (room >=0 && room < 13 && room != 4) {
				  if (newRand.randEnemySuccess() > 4) {
					  if(enemyStats[1] < myStats[2]) {
						  hpChange = myStats[0];
						  JOptionPane.showMessageDialog(null, "The enemy's attack is unsuccessful!");
					
					  }
					  else {
						  if(newRand.randEnemyUsePotion() > 16) {
							  int enAttkIncrease = 2;
							  enemyStats[1] += enAttkIncrease;
							  JOptionPane.showMessageDialog(null, "The enemy used an attack potion! Their attack was increased by " + enAttkIncrease);
						  
						  }
						  else {
							  hpChange = myStats[0] - attk;
							  myStats[0] = hpChange;
							  JOptionPane.showMessageDialog(null, "The enemy's attack is successful! They deal " + attk + " damage!");

						  }
					  }
					  
					  
				  }		
				  else {
					  
					  JOptionPane.showMessageDialog(null, "The enemy's attack is unsuccessful!");
				  }
			}
			else if (room > 13 && room < 29 || room == 4) {
				 if (newRand.randEnemySuccess() > 6) {
					  if(enemyStats[1] < myStats[2]) {
						  hpChange = myStats[0];
						  JOptionPane.showMessageDialog(null, "The enemy's attack is unsuccessful!");
					
					  }
					  else {
						  if(newRand.randEnemyUsePotion() > 13) {
							  int enAttkIncrease = 3;
							  enemyStats[1] += enAttkIncrease;
							  JOptionPane.showMessageDialog(null, "The enemy used an attack potion! Their attack was increased by " + enAttkIncrease);
						  
						  }
						  else {
							  hpChange = myStats[0] - attk;
							  myStats[0] = hpChange;
							  JOptionPane.showMessageDialog(null, "The enemy's attack is successful! They deal " + attk + " damage!");
						  }
					  }
					  
					  
				  }
				  else {
					  
					  JOptionPane.showMessageDialog(null, "The enemy's attack is unsuccessful!"); 
				  }	
			}
			else if (room >= 29 || room == 13) {
				if (newRand.randEnemySuccess() > 8) {
					  if(enemyStats[1] < myStats[2]) {
						  hpChange = myStats[0];
						  JOptionPane.showMessageDialog(null, "The enemy's attack is unsuccessful!");
					
					  }
					  else {
						  if(newRand.randEnemyUsePotion() > 7) {
							  int enAttkIncrease = 4;
							  enemyStats[1] += enAttkIncrease;
							  JOptionPane.showMessageDialog(null, "The enemy used an attack potion! Their attack was increased by " + enAttkIncrease);
						  
						  }
						  else {
							  hpChange = myStats[0] - attk;
							  myStats[0] = hpChange;
							  JOptionPane.showMessageDialog(null, "The enemy's attack is successful! They deal " + attk + " damage!");
						  }
					  }
					  
					  
				  }
				  else {
					  
					  JOptionPane.showMessageDialog(null, "The enemy's attack is unsuccessful!");
				  }
				
			}
		  
		  
	  }
	  public void emptyField (String field, int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
			
			if(field.isEmpty()) {
					JOptionPane.showMessageDialog(null, "You need to type something.");
				
							
					}
					
			}
	
}