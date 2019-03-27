import javax.swing.JOptionPane;
/********************************************************************
 * This class handles all Encounters except for the Dragon Fight, which is in its own class.
 * The mechanics are very simple, but do work very well, at least in the eyes of this programmer.
 * All normal encounter for both the Main floor, Dungeon, and Upper floor are handled here.
 ********************************************************************/
public class TxtAdventEncounters {
	

	TxtAdventNullCheck nullCheck = new TxtAdventNullCheck();
	TxtAdventUpperFloor upperRoom = new TxtAdventUpperFloor();
	TxtAdventMainFloor mainRoom = new TxtAdventMainFloor();
	TxtAdventDungeon dunRoom = new TxtAdventDungeon();
	TxtAdventRandNum newRand = new TxtAdventRandNum();
	 
	public void randStart(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		
	
		/*
		 *  This method is called first. It checks which room the player is in based on the room ID,
		 *  and then it will pass in enemy values to the method based on whether the players speed is higher than the enemy's and vice versa.
		 */
		if (room >=0 && room < 13 && room != 4) {

			int enemyStats[] = {50, 50, 25, newRand.randEasyEnemySpd()};
			if (enemyStats[3] > myStats[3]) {
				enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
				
			}
			else {
				myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
				
			}
			}
			else if (room > 13 && room < 29 || room == 4) {
				 int enemyStats[] = {70, 55, 40, newRand.randMedEnemySpd()};
					if (enemyStats[3] > myStats[3]) {
						enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
						
					}
					else {
						myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
						
					}
			}
			else if (room >= 29 || room == 13) {
				int enemyStats[] = {100, 65, 50, newRand.randHardEnemySpd()};
				if (enemyStats[3] > myStats[3]) {
					enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
					
				}
				else {
					myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
					
				}

				
			}
		  
	  }
	
	
	  public void myCombat(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] enemyStats, int[] invo, int[] flags) {
		  // Very similar to the Dragon Fight method, except this one handles logic based on the room ID, along with speed.
			TxtAdventPrompts newPrompt = new TxtAdventPrompts();
			int breakLoop = 0;
			String battleInfo = null;
			// The options are the same as that of the Dragon Fight, but this code works much more efficiently, and no longer causes errors.
			while (breakLoop <= 0) {
				
			
			
			if (room >=0 && room < 13 && room != 4) {
				battleInfo = nullCheck.nullCheck(JOptionPane.showInputDialog(null, "Your Stats:\n HP: " + myStats[0] + "\n Attack: " + myStats[1] + "\n Defense: " + myStats[2] + "\n Speed: " + myStats[3] + "\n\n\n"
				  + "Dark Knight Stats:\n HP: " + enemyStats[0] + "\n Attack: " + enemyStats[1] + "\n Defense: " + enemyStats[2] + "\n Speed: " + enemyStats[3] + 
				  "\n\n\n What do you want to do? \n\n\n1) Attack\n2) Inventory\n3) Run"));
				breakLoop += 1;
			  }
				else if (room > 13 && room < 29 || room == 4) {
					battleInfo = nullCheck.nullCheck(JOptionPane.showInputDialog(null, "Your Stats:\n HP: " + myStats[0] + "\n Attack: " + myStats[1] + "\n Defense: " + myStats[2] + "\n Speed: " + myStats[3] + "\n\n\n"
							  + "Hellhound Stats:\n HP: " + enemyStats[0] + "\n Attack: " + enemyStats[1] + "\n Defense: " + enemyStats[2] + "\n Speed: " + enemyStats[3] + 
							  "\n\n\n What do you want to do? \n\n\n1) Attack\n2) Inventory\n3) Run"));
					breakLoop += 1;
				}

				else if (room >= 29 || room == 13) {
					battleInfo = nullCheck.nullCheck(JOptionPane.showInputDialog(null, "Your Stats:\n HP: " + myStats[0] + "\n Attack: " + myStats[1] + "\n Defense: " + myStats[2] + "\n Speed: " + myStats[3] + "\n\n\n"
							  + "Drake Stats:\n HP: " + enemyStats[0] + "\n Attack: " + enemyStats[1] + "\n Defense: " + enemyStats[2] + "\n Speed: " + enemyStats[3] + 
							  "\n\n\n What do you want to do? \n\n\n1) Attack\n2) Inventory\n3) Run")); 
					breakLoop += 1;
				
				}
			}
			if (battleInfo.equals("1")) {
				 int hpChangeAttk = 0;
				  int myAttk = myStats[1] - enemyStats[2];
			
					 if (myStats[1] <= enemyStats[2]) {
						  JOptionPane.showMessageDialog(null, "Your Attack isn't high enough to do damage to the enemy!"); 
						  enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
						  
					  }
				  else {
					  if (room >=0 && room < 13 && room != 4) {
						  if (newRand.randAttkSuccess() > 1) {
							  hpChangeAttk = enemyStats[0] - myAttk;
							 enemyStats[0] = hpChangeAttk;
									 
							  JOptionPane.showMessageDialog(null, "The attack is successful! You deal " + myAttk + " damage!");  
							  if (enemyStats[0] <= 0) {
								  String win = "You Won! \n";
										if (newRand.randBattleReward() <= 4) {
											  JOptionPane.showMessageDialog(null, win + "You received an Attack boost potion!");
											  invo[1] += 1;
											  flags[18] = 1;
											  mainRoom.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
											  
											 
										  }
										  else if (newRand.randBattleReward() > 4 && newRand.randBattleReward() <= 8) {
											  JOptionPane.showMessageDialog(null, win + "You received a Defense boost potion!");
											  invo[2] += 1;
											  flags[18] = 1;
											  mainRoom.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
											
											 
										  }
										  else if (newRand.randBattleReward() > 8 && newRand.randBattleReward()<= 12) {
											  JOptionPane.showMessageDialog(null, win + "You received a Speed boost potion!");
											  invo[3] += 1;
											  flags[18] = 1;
											  mainRoom.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
											
											 
										  }
										  else if (newRand.randBattleReward() > 12 && newRand.randBattleReward() <= 18) {
											  JOptionPane.showMessageDialog(null, win + "You received a Health boost potion!"); 
											  invo[0] += 1;
											  flags[18] = 1;
											  mainRoom.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
											
											 
										  }
										  else {
										  JOptionPane.showMessageDialog(null, win + "You didn't receive anything this time.");
										  flags[18] = 1;
										  mainRoom.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
										
										  }
							  			}
						
							  	else {
									enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
								  
							  	}
						  }
						  
						  else {
							  hpChangeAttk = enemyStats[0];
							  JOptionPane.showMessageDialog(null, "You attack isn't successful."); 
							  enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
						  
						  }
						}
							else if (room > 13 && room < 29 || room == 4) {
								if (newRand.randAttkSuccess() > 1) {
									 hpChangeAttk = enemyStats[0] - myAttk;
									 enemyStats[0] = hpChangeAttk;
											 
									  JOptionPane.showMessageDialog(null, "The attack is successful! You deal " + myAttk + " damage!");  
									  if (enemyStats[0] <= 0) {
										  String win = "You Won! \n";
										  if (newRand.randBattleReward() <= 2) {
											  JOptionPane.showMessageDialog(null, win + "You received an Attack boost potion!");
											  invo[1] += 1;
											  flags[18] = 1;
											  dunRoom.DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
											
											 
										  }
										  else if (newRand.randBattleReward() > 2 && newRand.randBattleReward() <= 4) {
											  JOptionPane.showMessageDialog(null, win + "You received a Defense boost potion!");
											  invo[2] += 1;
											  flags[18] = 1;
											  dunRoom.DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
											
											 
										  }
										  else if (newRand.randBattleReward() > 4 && newRand.randBattleReward()<= 6) {
											  JOptionPane.showMessageDialog(null, win + "You received a Speed boost potion!"); 
											  invo[3] += 1;
											  flags[18] = 1;
											  dunRoom.DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
											
											 
										  }
										  else if (newRand.randBattleReward() > 6 && newRand.randBattleReward() <= 16) {
											  JOptionPane.showMessageDialog(null, win + "You received a Health boost potion!");  
											  invo[0] += 1;
											  flags[18] = 1;
											  dunRoom.DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
											
											 
										  }
										  else {
										  JOptionPane.showMessageDialog(null, win + "You didn't receive anything this time.");
										  flags[18] = 1;
										  dunRoom.DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
									
										  }
										  
									  }
										else {
											enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
										  
									  	}
									  
								  }
								  else {
									  hpChangeAttk = enemyStats[0];
									  JOptionPane.showMessageDialog(null, "You attack isn't successful.");
									  enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
									  
								  }
							}
							else if (room >= 29 || room == 13) {
								 if (newRand.randAttkSuccess() > 2) {
									 hpChangeAttk = enemyStats[0] - myAttk;
									 enemyStats[0] = hpChangeAttk;
											 
									  JOptionPane.showMessageDialog(null, "The attack is successful! You deal " + myAttk + " damage!");  
									  if (enemyStats[0] <= 0) {
										  String win = "You Won! \n";
										  if (newRand.randBattleReward() <= 1) {
											  
											  JOptionPane.showMessageDialog(null, win + "You received an Attack boost potion!");
											  invo[1] += 1;
											  flags[18] = 1;
											  upperRoom.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
											
											 
										  }
										  else if (newRand.randBattleReward() > 1 && newRand.randBattleReward() <= 3) {
											  JOptionPane.showMessageDialog(null, win + "You received an Defense boost potion!");
											  invo[2] += 1;
											  flags[18] = 1;
											  upperRoom.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
											
											 
										  }
										  else if (newRand.randBattleReward() > 3 && newRand.randBattleReward()<= 6) {
											  JOptionPane.showMessageDialog(null, win + "You received an Speed boost potion!");
											  invo[3] += 1;
											  flags[18] = 1;
											  upperRoom.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
											
											 
										  }
										  else if (newRand.randBattleReward() > 6 && newRand.randBattleReward() <= 18) {
											  JOptionPane.showMessageDialog(null, win + "You received an Health boost potion!");
											  invo[0] += 1;
											  flags[18] = 1;
											  upperRoom.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
											 
											 
										  }
										  else {
										  JOptionPane.showMessageDialog(null, win + "You didn't receive anything this time.");
										  flags[18] = 1;
										  upperRoom.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
									
										  } 
										  
									  }
										else {
											enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
										  
									  	}
								 }
								  else {
									  hpChangeAttk = enemyStats[0];
									  JOptionPane.showMessageDialog(null, "You attack isn't successful.");
									  enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
									  
								  }
								
							}
				  		
					
				  
				  }
			}
				 
			// Same potion usage as in the Dragon Class.
			else if (battleInfo.equals("2")) {
				
				 String choice = nullCheck.nullCheck(JOptionPane.showInputDialog("Your Inventory:\n\n Health Potion: " + invo[0] + "\n Attack Potion: " + invo[1] + "\n Defence Potion: " + invo[2] +
							"\n Speed Potion: " + invo[3] + "\n Downstairs Key: " + invo[4] + "\n Upstairs Key: " + invo[5] + "\n Final Key: " + invo[6] +
							"\n\nSelect item to use or return to battle? \n\n1) Use Health Potion\n2) Use Attack Potion\n3) Use Defence Potion\n4) Use Speed Potion"
							+ "\n5) Return to battle!"));
				

							
						if (choice.equals("1")) {
							  int hpHeal = myStats[0] + 10;
							  if (invo[0] > 0) {
							  int hpUsed = invo[0] - 1;
							  JOptionPane.showMessageDialog(null, "You use a Health potion! It increases your Health to " + hpHeal);
							  myStats[0] = hpHeal;
							  invo[0] = hpUsed;
							  enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
							  }
							  else {
								  JOptionPane.showMessageDialog(null, "You don't have any Health potions.");
								  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
							  }
							
						}
						else if (choice.equals("2")) {
							  int attkBoost = myStats[1] + 5;
							  if (invo[1] > 0) {
							  int attkUsed = invo[1] - 1;
							  JOptionPane.showMessageDialog(null, "You use an Attack potion! It increases your Attack to " + attkBoost);
							  myStats[1] = attkBoost;
							  invo[1] = attkUsed;
							  enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
							  }
							  else {
								  JOptionPane.showMessageDialog(null, "You don't have any Attack potions.");
								  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
							  }
							
						}
						else if (choice.equals("3")) {
							  int defBoost = myStats[2] + 5;
							  if (invo[2] > 0) {
							  int defUsed = invo[2] - 1;
							  JOptionPane.showMessageDialog(null, "You use a Defense potion! It increases your Defence to " + defBoost);
							  myStats[2] = defBoost;
							  invo[2] = defUsed;
							  enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
							  }
							  else {
								  JOptionPane.showMessageDialog(null, "You don't have any Defense potions.");
								  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
							  }
							
						}
						else if (choice.equals("4")) {
							  int spdBoost = myStats[3] + 5;
							  if (invo[3] > 0) {
							  int spdUsed = invo[3] - 1;
							  JOptionPane.showMessageDialog(null, "You use a Speed potion! It increases your Speed to " + spdBoost);
							  myStats[3] = spdBoost;
							  invo[3] = spdUsed;
							  enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
							  }
							  else {
								  JOptionPane.showMessageDialog(null, "You don't have any Speed potions.");
								  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
							  }
							
						}
						else if (choice.equals("5")) {
							JOptionPane.showMessageDialog(null, "Back to the battle! Good luck!");
							myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);

							
						}
						
						else {
							JOptionPane.showMessageDialog(null, "Not a valid option");
							myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
							
					
						}
			}
			/*
			 *  Once run is chosen, if the player has higher speed, they will return to the room they had the encounter. If the players speed is
			 *  less than that of the enemy, they can't escape and must finish the fight.
			 */
			else if (battleInfo.equals("3")) {
	
				  if (myStats[3] > enemyStats[3]) {
						if (room >=0 && room < 13 && room != 4) {
							newPrompt.PromptSafely();
							flags[18] = 1;
							mainRoom.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
						
							}
							else if (room > 13 && room < 29 || room == 4) {
							newPrompt.PromptSafely(); 
							flags[18] = 1;
							dunRoom.DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							}
							else if (room >= 29 || room == 13) {
							newPrompt.PromptSafely();
							flags[18] = 1;
							upperRoom.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
								
							}
						 
					
			}
				  else {
					  JOptionPane.showMessageDialog(null, "Can't escape!"); 
					  enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
				  }
			}
			else {
				if(battleInfo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "You need to type something.");
					
					myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
			
					}
				else {
					
					JOptionPane.showMessageDialog(null, "Invalid input");
					myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
				}
			   
			}

	 
		 
			  }
		
	  
				
				
				 
			  
	  /*
	   * The enemy combat is very similar to the Dragon Fight, except that enemys will only randomly increase their attack; This means that if
	   * the enemy has less attack then the players defense, there is a strong chance the enemy won't be able to attack at all during the fight!
	   * This works heavily in the players favor when trying to farm for potions for the Dragon Fight.
	   */
	  public void enemyCombat(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] enemyStats, int[] invo, int[] flags) {
		  TxtAdventRandNum newRand = new TxtAdventRandNum();
		  int hpChange = 0;
		  int enAttk = enemyStats[1] - myStats[2];
			if (room >=0 && room < 13 && room != 4) {
				  if (newRand.randEnemySuccess() >= 3) {
						  if(newRand.randEnemyUsePotion() > 14) {
							  int enAttkIncrease = 2;
							  enemyStats[1] += enAttkIncrease;
							  JOptionPane.showMessageDialog(null, "The enemy used an attack potion! Their attack was increased by " + enAttkIncrease);
							  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
						  
						  }
						  else {
							  if (myStats[2] >= enemyStats[1]) {
								  JOptionPane.showMessageDialog(null, "The enemy is unable to attack due to it's Attack being lower than/equal to your Defense!");
								  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
								  
							  }
							  else {
							  hpChange = myStats[0] - enAttk;
							  myStats[0] = hpChange;
							  JOptionPane.showMessageDialog(null, "The enemy's attack is successful! They deal " + enAttk + " damage!");
							  if (myStats[0] <= 0) {
								  JOptionPane.showMessageDialog(null, "You lost..Better luck next time.");  
								  System.exit(0);
								  
							  }
							  else {
								  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
							  }

						  }
						 }
					  }
					  
					  
				  	
				  else {
					  
					  JOptionPane.showMessageDialog(null, "The enemy's attack is unsuccessful!");
					  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
				  }
			}
			else if (room > 13 && room < 29 || room == 4) {
				 if (newRand.randEnemySuccess() >= 3) {

						  if(newRand.randEnemyUsePotion() > 13) {
							  int enAttkIncrease = 3;
							  enemyStats[1] += enAttkIncrease;
							  JOptionPane.showMessageDialog(null, "The enemy used an attack potion! Their attack was increased by " + enAttkIncrease);
							  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
						  
						  }
						  else {
							  if (myStats[2] >= enemyStats[1]) {
								  JOptionPane.showMessageDialog(null, "The enemy is unable to attack due to it's Attack being lower than/equal to your Defense!");
								  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
							  }
							  else {
							  hpChange = myStats[0] - enAttk;
							  myStats[0] = hpChange;
							  JOptionPane.showMessageDialog(null, "The enemy's attack is successful! They deal " + enAttk + " damage!");
							  if (myStats[0] <= 0) {
								  JOptionPane.showMessageDialog(null, "You lost..Better luck next time.");  
								  System.exit(0);
								  
							  }
							  else {
								  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
							  }

						  }
					  }
					}
				 
				  else {
					  
					  JOptionPane.showMessageDialog(null, "The enemy's attack is unsuccessful!"); 
					  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
				  }	
			}
			else if (room >= 29 || room == 13) {
				if (newRand.randEnemySuccess() >= 4) {
					 
						  if(newRand.randEnemyUsePotion() > 7) {
							  int enAttkIncrease = 4;
							  enemyStats[1] += enAttkIncrease;
							  JOptionPane.showMessageDialog(null, "The enemy used an attack potion! Their attack was increased by " + enAttkIncrease);
							  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
						  
						  }
						  else {
							  if (myStats[2] >= enemyStats[1]) {
								  JOptionPane.showMessageDialog(null, "The enemy is unable to attack due to it's Attack being lower than/equal to your Defense!");
								  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
							  }
							  else {
							  hpChange = myStats[0] - enAttk;
							  myStats[0] = hpChange;
							  JOptionPane.showMessageDialog(null, "The enemy's attack is successful! They deal " + enAttk + " damage!");
							  if (myStats[0] <= 0) {
								  JOptionPane.showMessageDialog(null, "You lost..Better luck next time.");  
								  System.exit(0);
								  
							  }
							  else {
								  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
							  }

						  }
					    }
					  }
					  
					  
				  else {
					  
					  JOptionPane.showMessageDialog(null, "The enemy's attack is unsuccessful!");
					  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
				  }
			}
		  
		  
	  }
	
	
}