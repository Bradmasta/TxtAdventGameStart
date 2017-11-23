
import javax.swing.JOptionPane;
public class TxtAdventEncounters {
	TxtAdventNullCheck nullCheck = new TxtAdventNullCheck();
	TxtAdventRandNum newRand = new TxtAdventRandNum();
	TxtAdventUpperFloor upperRoom = new TxtAdventUpperFloor();
	TxtAdventMainFloor mainRoom = new TxtAdventMainFloor();
	TxtAdventDungeon dunRoom = new TxtAdventDungeon();
	TxtAdventPrompts newPrompt = new TxtAdventPrompts();
	public void randStart(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		TxtAdventRandNum newRand = new TxtAdventRandNum();
		if (room >=0 && room < 13 && room != 4) {

			int enemyStats[] = {30, 30, 15, newRand.randEasyEnemySpd()};
			randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
			}
			else if (room > 13 && room < 29 || room == 4) {
				 int enemyStats[] = {40, 35, 20, newRand.randMedEnemySpd()};
				randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
			}
			else if (room >= 29 || room == 13) {
				int enemyStats[] = {100, 45, 30, newRand.randHardEnemySpd()};
				randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
				
			}
		  
	  }
	  public void randEncounter(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] enemyStats, int[] invo, int[] flags) {
		  
		  
		  if(myStats[0] > 0 && enemyStats[0] > 0) {

		 
		  if(myStats[3] < enemyStats[3]) {
			  enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);

			  }

		  else {
			 
			  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);

		  }
		 }
	 
		 
			  }

	
	  
	  public void myCombat(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] enemyStats, int[] invo, int[] flags) {
		  int hpChangeAttk = 0;
		  int hpUsed = invo[0];
		  int attk = myStats[1] - enemyStats[2];
		  String battleInfo = null;
				if (room >=0 && room < 13 && room != 4) {
				battleInfo = nullCheck.nullCheck(JOptionPane.showInputDialog(null, "Your Stats:\n HP: " + myStats[0] + "\n Attack: " + myStats[1] + "\n Defense: " + myStats[2] + "\n Speed: " + myStats[3] + "\n\n\n"
				  + "Dark Knight Stats:\n HP: " + enemyStats[0] + "\n Attack: " + enemyStats[1] + "\n Defense: " + enemyStats[2] + "\n Speed: " + enemyStats[3] + 
				  "\n\n\n What do you want to do? \n\n\n1) Attack\n2) Inventory\n3) Run"));
				 
			  }
				else if (room > 13 && room < 29 || room == 4) {
					battleInfo = nullCheck.nullCheck(JOptionPane.showInputDialog(null, "Your Stats:\n HP: " + myStats[0] + "\n Attack: " + myStats[1] + "\n Defense: " + myStats[2] + "\n Speed: " + myStats[3] + "\n\n\n"
							  + "Hellhound Stats:\n HP: " + enemyStats[0] + "\n Attack: " + enemyStats[1] + "\n Defense: " + enemyStats[2] + "\n Speed: " + enemyStats[3] + 
							  "\n\n\n What do you want to do? \n\n\n1) Attack\n2) Inventory\n3) Run"));

				  }
				else if (room >= 29 || room == 13) {
					battleInfo = nullCheck.nullCheck(JOptionPane.showInputDialog(null, "Your Stats:\n HP: " + myStats[0] + "\n Attack: " + myStats[1] + "\n Defense: " + myStats[2] + "\n Speed: " + myStats[3] + "\n\n\n"
							  + "Drake Stats:\n HP: " + enemyStats[0] + "\n Attack: " + enemyStats[1] + "\n Defense: " + enemyStats[2] + "\n Speed: " + enemyStats[3] + 
							  "\n\n\n What do you want to do? \n\n\n1) Attack\n2) Inventory\n3) Run")); 
					 
				}
		  
		  if (battleInfo.equals("1")) {
			  if (myStats[1] <= enemyStats[2]) {
				  JOptionPane.showMessageDialog(null, "Your Attack isn't high enough to do damage to the enemy!"); 
				  if (myStats[3] < enemyStats[3]) {
					  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
					  
				  }
				  else {
					  enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
					  
				  }
				  
			  }
		  else {
			  if (room >=0 && room < 13 && room != 4) {
				  if (newRand.randAttkSuccess() > 1) {
					  hpChangeAttk = enemyStats[0] - attk;
					 enemyStats[0] = hpChangeAttk;
							 
					  JOptionPane.showMessageDialog(null, "The attack is successful! You deal " + attk + " damage!");  
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
							  if (myStats[3] < enemyStats[3]) {
								  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
								
							  }
							  else {
								  enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
								  
							  }
						  }
				  }
									
					  
				  
		  
				  else {
					  hpChangeAttk = enemyStats[0];
					  JOptionPane.showMessageDialog(null, "You attack isn't successful."); 
					  if (myStats[3] < enemyStats[3]) {
						  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
						
					  }
					  else {
						  enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
						  
					  }
				  
				  }
				  }
		  
					else if (room > 13 && room < 29 || room == 4) {
						if (newRand.randAttkSuccess() > 1) {
							 hpChangeAttk = enemyStats[0] - attk;
							 enemyStats[0] = hpChangeAttk;
									 
							  JOptionPane.showMessageDialog(null, "The attack is successful! You deal " + attk + " damage!");  
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
								  if (myStats[3] < enemyStats[3]) {
									  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
									
								  }
								  else {
									  enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
									  
								  }
							  }
						}
						  else {
							  hpChangeAttk = enemyStats[0];
							  JOptionPane.showMessageDialog(null, "You attack isn't successful.");
							  if (myStats[3] < enemyStats[3]) {
								  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
								
							  }
							  else {
								  enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
								  
							  }
							  
						  
						  }
					
					}
					else if (room >= 29 || room == 13) {
						 if (newRand.randAttkSuccess() > 2) {
							 hpChangeAttk = enemyStats[0] - attk;
							 enemyStats[0] = hpChangeAttk;
									 
							  JOptionPane.showMessageDialog(null, "The attack is successful! You deal " + attk + " damage!");  
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
								  if (myStats[3] < enemyStats[3]) {
									  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
									
								  }
								  else {
									  enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
									  
								  }
							  }
						 }
						  else {
							  hpChangeAttk = enemyStats[0];
							  JOptionPane.showMessageDialog(null, "You attack isn't successful.");
							  if (myStats[3] < enemyStats[3]) {
								  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
								
							  }
							  else {
								  enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
								  
							  }
						  }
						
					
				}
		  }
		  }
		  else if (battleInfo.equals("2")) {

				
	
					 String choice = nullCheck.nullCheck(JOptionPane.showInputDialog("Your Inventory:\n\n Health Potion: " + invo[0] + "\n Attack Potion: " + invo[1] + "\n Defence Potion: " + invo[2] +
								"\n Speed Potion: " + invo[3] + "\n Downstairs Key: " + invo[4] + "\n Upstairs Key: " + invo[5] + "\n Final Key: " + invo[6] +
								"\n\nSelect item to use or return to battle? \n\n1) Use Health Potion\n2) Use Attack Potion\n3) Use Defence Potion\n4) Use Speed Potion"
								+ "\n5) Return to battle!"));
					
							
							if (choice.equals("1")) {
								  int hpHeal = myStats[0] + 10;
								  if (invo[0] > 0) {
								  hpUsed = invo[0] - 1;
								  JOptionPane.showMessageDialog(null, "You use a Health potion! It increases your Health to " + hpHeal);
								  myStats[0] = hpHeal;
								  invo[0] = hpUsed;
								  if (myStats[3] < enemyStats[3]) {
									  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
									
								  }
								  else {
									  enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
									  
								  }
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
								  if (myStats[3] < enemyStats[3]) {
									  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
									
								  }
								  else {
									  enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
									  
								  }
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
								  if (myStats[3] < enemyStats[3]) {
									  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
									
								  }
								  else {
									  enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
									  
								  }
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
								  if (myStats[3] < enemyStats[3]) {
									  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
									
								  }
								  else {
									  enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
									  
								  }
								  }
								  else {
									  JOptionPane.showMessageDialog(null, "You don't have any Speed potions.");
									  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
								  }
								
							}
							else if (choice.equals("5")) {
								JOptionPane.showMessageDialog(null, "Back to the battle! Good luck!");
								if (myStats[3] < enemyStats[3]) {
									  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
									
								  }
								  else {
									  enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
									  
								  }
							}
							
							else {

								 if(choice.isEmpty()) {
										JOptionPane.showMessageDialog(null, "You need to type something.");
										
										myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
								
										}
									else {
										
										 JOptionPane.showMessageDialog(null, "Not a valid option");
										 myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
									}
		
						
							}
						
						
					
					 
				  
			  }
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
						  if (myStats[3] < enemyStats[3]) {
							  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
						  }
						  else {
							  enemyCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
							  
						  }
					  }
		  }
			
		  else {
		  if(battleInfo.isEmpty()) {
				JOptionPane.showMessageDialog(null, "You need to type something.");
				
				myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
		
				}
			else {
				
				 JOptionPane.showMessageDialog(null, "Not a valid option");
				 myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
				}
		  	   }
		      }
		
	  
	  public void enemyCombat(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] enemyStats, int[] invo, int[] flags) {
		  int hpChange = 0;
		  int attk = enemyStats[1] - myStats[2];
			if (room >=0 && room < 13 && room != 4) {
				  if (newRand.randEnemySuccess() >= 3) {
						  if(newRand.randEnemyUsePotion() > 10) {
							  int enAttkIncrease = 2;
							  enemyStats[1] += enAttkIncrease;
							  JOptionPane.showMessageDialog(null, "The enemy used an attack potion! Their attack was increased by " + enAttkIncrease);
							  if (myStats[3] < enemyStats[3]) {
								  
								  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
							  }
							  else {
								  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
								  
							  }
						  
						  }
						  else {
							  if (myStats[2] >= enemyStats[1]) {
								  JOptionPane.showMessageDialog(null, "The enemy is unable to attack due to it's Attack being lower than/equal to your Defense!");
								  if (myStats[3] < enemyStats[3]) {
									  
									  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
								  }
								  else {
									  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
									  
								  }
							  }
							  else {
							  hpChange = myStats[0] - attk;
							  myStats[0] = hpChange;
							  JOptionPane.showMessageDialog(null, "The enemy's attack is successful! They deal " + attk + " damage!");
							  if (myStats[0] <= 0) {
								  JOptionPane.showMessageDialog(null, "You lost..Better luck next time.");  
								  System.exit(0);
								  
							  }
							  else {
							  if (myStats[3] < enemyStats[3]) {
								  
								  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
							  }
							  else {
								  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
								  
							  }
							  if (myStats[0] <= 0) {
								  JOptionPane.showMessageDialog(null, "You lost..Better luck next time.");  
								  System.exit(0);
								  
							  }
							  }
						  }
						 }
					  }
					  
					  
				  	
				  else {
					  
					  JOptionPane.showMessageDialog(null, "The enemy's attack is unsuccessful!");
					  if (myStats[3] < enemyStats[3]) {
						  
						  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
					  }
					  else {
						  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
						  
					  }
				  }
			}
			else if (room > 13 && room < 29 || room == 4) {
				 if (newRand.randEnemySuccess() >= 3) {

						  if(newRand.randEnemyUsePotion() > 8) {
							  int enAttkIncrease = 3;
							  enemyStats[1] += enAttkIncrease;
							  JOptionPane.showMessageDialog(null, "The enemy used an attack potion! Their attack was increased by " + enAttkIncrease);
							  if (myStats[3] < enemyStats[3]) {
								  
								  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
							  }
							  else {
								  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
								  
							  }
						  }
						  else {
							  if (myStats[2] >= enemyStats[1]) {
								  JOptionPane.showMessageDialog(null, "The enemy is unable to attack due to it's Attack being lower than/equal to your Defense!");
								  if (myStats[3] < enemyStats[3]) {
									  
									  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
								  }
								  else {
									  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
									  
								  }
							  }
							  else {
							  hpChange = myStats[0] - attk;
							  myStats[0] = hpChange;
							  JOptionPane.showMessageDialog(null, "The enemy's attack is successful! They deal " + attk + " damage!");
							  if (myStats[0] <= 0) {
								  JOptionPane.showMessageDialog(null, "You lost..Better luck next time.");  
								  System.exit(0);
								  
							  }
							  else {
								  if (myStats[3] < enemyStats[3]) {
									  
									  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
								  }
								  else {
									  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
									  
								  }
								  
							  }

						  }
					  }
					}
				 
				  else {
					  
					  JOptionPane.showMessageDialog(null, "The enemy's attack is unsuccessful!"); 
					  if (myStats[3] < enemyStats[3]) {
						  
						  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
					  }
					  else {
						  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
						  
					  }
				  }	
			}
			else if (room >= 29 || room == 13) {
				if (newRand.randEnemySuccess() >= 4) {
					 
						  if(newRand.randEnemyUsePotion() > 6) {
							  int enAttkIncrease = 4;
							  enemyStats[1] += enAttkIncrease;
							  JOptionPane.showMessageDialog(null, "The enemy used an attack potion! Their attack was increased by " + enAttkIncrease);
							  if (myStats[3] < enemyStats[3]) {
								  
								  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
							  }
							  else {
								  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
								  
							  }
						  }
						  else {
							  if (myStats[2] >= enemyStats[1]) {
								  JOptionPane.showMessageDialog(null, "The enemy is unable to attack due to it's Attack being lower than/equal to your Defense!");
								  if (myStats[3] < enemyStats[3]) {
									  
									  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
								  }
								  else {
									  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
									  
								  }
							  }
							  else {
							  hpChange = myStats[0] - attk;
							  myStats[0] = hpChange;
							  JOptionPane.showMessageDialog(null, "The enemy's attack is successful! They deal " + attk + " damage!");
							  if (myStats[0] <= 0) {
								  JOptionPane.showMessageDialog(null, "You lost..Better luck next time.");  
								  System.exit(0);
								  
							  }
							  else {
								  if (myStats[3] < enemyStats[3]) {
									  
									  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
								  }
								  else {
									  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
									  
								  }
							  }

						  }
					    }
					  }
					  
					  
				  else {
					  
					  JOptionPane.showMessageDialog(null, "The enemy's attack is unsuccessful!");
					  if (myStats[3] < enemyStats[3]) {
						  
						  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
					  }
					  else {
						  randEncounter(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
						  
					  }
				  }
			}
		  
		  
	  }
	 
	
}