import javax.swing.JOptionPane;
/*****************************************************************
 * The Dragon fight. The mechanics here are slightly different from the Encounter class; due to code management, I decided to 
 * give the Dragon fight its own class.
 *****************************************************************/
public class TxtAdventDragon {
	

	
	TxtAdventNullCheck nullCheck = new TxtAdventNullCheck();
	TxtAdventRandNum newRand = new TxtAdventRandNum();
	
	public void DragonFightStart(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		
		 int enemyStats[] = {500, 50, 50, 2147483647};
		 enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
		  
	  }
	 public void myCombat(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] enemyStats, int[] invo, int[] flags) {
		  // Very similar to the Dragon Fight method, except this one handles logic based on the room ID, along with speed.
			int breakLoop = 0;
			String battleInfo = null;
			// The options are the same as that of the Dragon Fight, but this code works much more efficiently, and no longer causes errors.
			while (breakLoop <= 0) {
				
		
				battleInfo = nullCheck.nullCheck(JOptionPane.showInputDialog(null, "Your Stats:\n HP: " + myStats[0] + "\n Attack: " + myStats[1] + "\n Defense: " + myStats[2] + "\n Speed: " + myStats[3] + "\n\n\n"
				  + "Dragon Stats:\n HP: " + enemyStats[0] + "\n Attack: " + enemyStats[1] + "\n Defense: " + enemyStats[2] + "\n Speed: " + enemyStats[3] + 
				  "\n\n\n What do you want to do? \n\n\n1) Attack\n2) Inventory\n3) Run"));
				breakLoop += 1;
			  }
		
			if (battleInfo.equals("1")) {
				 int hpChangeAttk = 0;
				  int myAttk = myStats[1] - enemyStats[2];
			
					 if (myStats[1] <= enemyStats[2]) {
						  JOptionPane.showMessageDialog(null, "Your Attack isn't high enough to damage the Dragon!"); 
						  enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
						  
					  }
				  else {
						  if (newRand.randAttkSuccess() > 2) {
							  hpChangeAttk = enemyStats[0] - myAttk;
							 enemyStats[0] = hpChangeAttk;
									 
							  JOptionPane.showMessageDialog(null, "The attack is successful! You deal " + myAttk + " damage!");  
							  if (enemyStats[0] <= 0) {
								  JOptionPane.showMessageDialog(null, "YOU WON!! Somehow...someway, you have slain the Dragon!\n"
								  		+ "Thanks for playing my game! I do hope you enjoyed it :)\n"
								  		+ "More improvements will come later on!");
								  		System.exit(0);
										
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
	
				JOptionPane.showMessageDialog(null, "There is no escaping this fight!");
				myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
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

	  /*  The Dragons method is a little different than the normal combat method from the Encounter class:
	   *  The Dragon will always raise its attack every turn by 10 until it's able to actually attack you.
	   *  The Dragons success rate is 50%, and has a 20% chance on top of that to increase its attack by a further 10 points
	   *  As with the Encounter class, if you lose all your health you lose the game; if you beat the Dragon you win!
	   */
	  public void enemyCombat(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] enemyStats, int[] invo, int[] flags) {
		  int hpChange = 0;
		  int enAttkIncrease = 10;
		  int attk = enemyStats[1] - myStats[2];
		  if (myStats[2] >= enemyStats[1]) {
			  enemyStats[1] += enAttkIncrease;
			  JOptionPane.showMessageDialog(null, "The Dragon can't attack because its Attack is too low! But not for long.. The Dragon "
			  		+ "increases its Attack by " + enAttkIncrease + "!");
			  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
			  
		  }
		  else if (newRand.randEnemySuccess() >= 5) {
				  if (newRand.randDragonAttkInc() >= 8) {
					  hpChange = myStats[0] - attk;
					  myStats[0] = hpChange;
					  enemyStats[1] += enAttkIncrease;
					  JOptionPane.showMessageDialog(null, "The Dragon's attack is successful! They deal " + attk + " damage!\n"
					  		+ "The Dragon's attack also went up by " + enAttkIncrease + "!");
					  if (myStats[0] <= 0) {
						  JOptionPane.showMessageDialog(null, "You lost..Better luck next time.");  
						  System.exit(0);
						  
					  }
					  else {
						  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
					  }
					  
				  }
				  else {

					  hpChange = myStats[0] - attk;
					  myStats[0] = hpChange;
					  JOptionPane.showMessageDialog(null, "The Dragon's attack is successful! They deal " + attk + " damage!");
					  if (myStats[0] <= 0) {
						  JOptionPane.showMessageDialog(null, "You lost..Better luck next time.");  
						  System.exit(0);
						  
					  }
					  else {
						  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
					  }
				  }
			  }
		  
		  else {
			  
			  JOptionPane.showMessageDialog(null, "The Dragon's attack is unsuccessful!");
			  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
		  }
		  
	  }
	
	
}