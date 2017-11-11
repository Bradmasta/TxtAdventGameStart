import java.util.InputMismatchException;
public class TxtAdventGameHardEnc {
	TxtAdventUserInput newScan = new TxtAdventUserInput();
	TxtAdventRandNum newRand = new TxtAdventRandNum();
	TxtAdventUpperFloor newRoom = new TxtAdventUpperFloor();

	  public void randEncounterHard(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
			
		  
		  int enemyStats[] = {40, 15, 10, newRand.randHardEnemySpd()};
		  
		  
		while (myStats[0] > 0 || enemyStats[0] > 0) {
		System.out.println("Your Stats:\n HP: " + myStats[0] + "\n Attack: " + myStats[1] + "\n Defense: " + myStats[2] + "\n Speed: " + myStats[3]);
		System.out.println(" ");
		System.out.println("Drake Stats:\n HP: " + enemyStats[0] + "\n Attack: " + enemyStats[1] + "\n Defense: " + enemyStats[2] + "\n Speed: " + enemyStats[3]);
		System.out.println(" ");
		  if (myStats[0] <= 0 || enemyStats[0] <= 0) {
			  if (myStats[0] <= 0) {
				  System.out.println("You lost..Good luck next time!");
				  System.exit(0);
			  }
			  if (enemyStats[0] <= 0) {
				  System.out.println("You Won!");
				  System.out.println(" ");

				  if (newRand.randBattleReward() <= 1) {
					  System.out.println("You received an Attack boost potion!");
					  System.out.println(" "); 
					  invo[1] += 1;

					  newRoom.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					  break;
					 
				  }
				  else if (newRand.randBattleReward() > 1 && newRand.randBattleReward() <= 3) {
					  System.out.println("You received a Defense boost potion!");
					  System.out.println(" "); 
					  invo[3] += 1;
	
					  newRoom.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					  break;
					 
				  }
				  else if (newRand.randBattleReward() > 3 && newRand.randBattleReward()<= 6) {
					  System.out.println("You received a Speed boost potion!");
					  System.out.println(" "); 
					  invo[2] += 1;

					  newRoom.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					  break;
					 
				  }
				  else if (newRand.randBattleReward() > 6 && newRand.randBattleReward() <= 18) {
					  System.out.println("You received a Health boost potion!");
					  System.out.println(" "); 
					  invo[0] += 1;

					  newRoom.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					  break;
					 
				  }
				  else {
				  System.out.println("You didn't receive anything this time.");
				  System.out.println(" ");
				  newRoom.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				  break;
				  }
				 
			  }
			  
		  }
			  
		  
		  else if(myStats[3] < enemyStats[3]) {
			  enemyCombat(enemyStats, myStats);
			  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
			  
		  }
		  else {
			  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
			  enemyCombat(enemyStats, myStats);
		  }

	 
		 
	    }
	  }
	  
	  public void myCombat(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] enemyStats, int[] invo, int[] flags) {
		  int hpChangeAttk = 0;
		  int hpUsed = invo[0];
		  int attk = myStats[1] - enemyStats[2];
		  int combatChoice = combatVerify(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
		  
		  if (combatChoice == 1) {
		  if (newRand.randAttkSuccess() > 1) {
			  hpChangeAttk = enemyStats[0] - attk;
			 if (hpChangeAttk > 0) {
			 enemyStats[0] = hpChangeAttk;
			 }
			 else {
			enemyStats[0] = 0;
			 }
			  System.out.println("The attack is successful! You deal " + attk + " damage!");
			  System.out.println(" ");
			  
			  
		  }
		  else {
			  hpChangeAttk = enemyStats[0];
			  System.out.println("You attack isn't successful.");
			  System.out.println(" ");
			  
		  }
		  
		  } 
		  else if (combatChoice == 2) {
			 final int RETRY = 0;
			 int choice;
			 System.out.println("Your Inventory:\n Health Potion: " + invo[0] + "\n Attack Boost: " + invo[1] + "\n Speed Boost: " + invo[2] + "\n Defence Boost: " + invo[3] + "\n Downstairs Key: " + invo[4] + "\n Upstairs Key: " + invo[5] + "\n Final Key: " + invo[6]);
			 System.out.println(" ");
			
			 while (RETRY >= 0) {
				 System.out.println("Select item to use or return to battle?");
				 System.out.println(" ");
					System.out.println("1) Use Health Potion\n2) Use Attack Potion\n3) Use Defence Potion\n4) Use Speed Potion\n5) Return to battle!");

					try {
						choice = newScan.ScannerInt();
						if (choice == 1) {
							  int hpHeal = myStats[0] + 10;
							  if (invo[0] > 0) {
							  hpUsed = invo[0] - 1;
							  System.out.println("You use a health potion! It increases your health by " + hpHeal);
							  System.out.println(" ");
							  myStats[0] = hpHeal;
							  invo[0] = hpUsed;
							  }
							  else {
								  System.out.println("You don't have any health potions.");
							  }
							
						}
						else if (choice == 2) {
							  int attkBoost = myStats[1] + 5;
							  if (invo[1] > 0) {
							  int attkUsed = invo[1] - 1;
							  System.out.println("You use an attack potion! It increases your attack by " + attkBoost);
							  System.out.println(" ");
							  myStats[1] = attkBoost;
							  invo[1] = attkUsed;
							  }
							  else {
								  System.out.println("You don't have any attack potions.");
							  }
							
						}
						else if (choice == 3) {
							  int defBoost = myStats[2] + 5;
							  if (invo[3] > 0) {
							  int defUsed = invo[3] - 1;
							  System.out.println("You use a potion! It increases your defence by " + defBoost);
							  System.out.println(" ");
							  myStats[2] = defBoost;
							  invo[3] = defUsed;
							  }
							  else {
								  System.out.println("You don't have any defence potions.");
							  }
							
						}
						else if (choice == 4) {
							  int spdBoost = myStats[3] + 1;
							  if (invo[2] > 0) {
							  int spdUsed = invo[2] - 1;
							  System.out.println("You use a potion! It increases your speed by " + spdBoost);
							  System.out.println(" ");
							  myStats[3] = spdBoost;
							  invo[2] = spdUsed;
							  }
							  else {
								  System.out.println("You don't have any speed potions.");
							  }
							
						}
						else if (choice == 5) {
							System.out.println("Back to the battle! Good luck!");
							System.out.println(" ");
							myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
						}
						
						else {
							System.out.println("Not a valid option");
							System.out.println(" ");
							
					
						}
						break;
					}
					catch (InputMismatchException error) {
							System.out.println("Can't use letters/symbols/other nonsense here!");
					}
					break;
				}
			 
			  
		  }
	  }

	  
	  public void enemyCombat(int[] enemyStats, int[] myStats) {
		  int hpChange = 0;
		  int attk = enemyStats[1] - myStats[2];
		  
		  if (newRand.randEnemySuccess() > 8) {
			  if(enemyStats[1] < myStats[2]) {
				  hpChange = myStats[0];
				  System.out.println("The enemy's attack is unsuccessful!");
				  System.out.println(" ");
			
			  }
			  else {
				  if(newRand.randEnemyUsePotion() > 10) {
					  int enAttkIncrease = 5;
					  enemyStats[1] += enAttkIncrease;
					  System.out.println("The enemy used an attack potion! Their attack was increased by " + enAttkIncrease);
					  System.out.println(" ");
				  
				  }
				  else {
					  hpChange = myStats[0] - attk;
					  myStats[0] = hpChange;
					  System.out.println("The enemy's attack is successful! They deal " + attk + " damage!");
					  System.out.println(" ");
				  }
			  }
			  
			  
		  }
		  else {
			  hpChange = myStats[0];
			  System.out.println("The enemy's attack is unsuccessful!");
			  System.out.println(" ");
			  
		  }
		  
		  
		  
	  }
	  public int combatVerify(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] enemyStats, int[] invo, int[] flags) {
			final int RETRY = 0;
			int choice;
			
			while (RETRY >= 0) {
					System.out.println("1) Attack\n2) Inventory\n3) Run");

					try {
						choice = newScan.ScannerInt();
						if (choice == 1) {
							return choice;
							
						}
						else if (choice == 2) {
							return choice;
						}
						else if (choice == 3) {
							if (myStats[3] > enemyStats[3]) {
								
								  System.out.println("You got away safely!");
								  System.out.println(" ");
								  newRoom.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
								  break;
								  }
								  else {
									  System.out.println("Can't escape!");
									  System.out.println(" ");
								  }
							
							break;
						}
						else {
							System.out.println("Not a valid option");
							System.out.println(" ");
							combatVerify(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
							break;
						}
						
					}
					catch (InputMismatchException error) {
							System.out.println("Can't use letters/symbols/other nonsense here!");
					}
				}
			return choice;



		}
		
	
}