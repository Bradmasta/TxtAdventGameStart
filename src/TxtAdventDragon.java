import java.util.*;
import javax.swing.JOptionPane;

public class TxtAdventDragon {
	
	TxtAdventNullCheck nullCheck = new TxtAdventNullCheck();
	TxtAdventRandNum newRand = new TxtAdventRandNum();
	
	public void DragonFightStart(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		
		 int enemyStats[] = {100, 20, 30, 999};
		 DragonFight(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
		  
	  }
	  public void DragonFight(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] enemyStats, int[] invo, int[] flags) {
		  
		while (myStats[0] > 0 || enemyStats[0] > 0) {
			
		int battleChoice = 0;
		
		  if (myStats[0] <= 0 || enemyStats[0] <= 0) {
			  
			  if (myStats[0] <= 0) {
				  
				  JOptionPane.showMessageDialog(null, "You lost..The Dragon got the best of you, this time. Good luck next time!");
				  System.exit(0);
				  
			  }
			  if (enemyStats[0] <= 0) {
				  
				  JOptionPane.showMessageDialog(null, "Somehow, someway...you won! Incredible!\n I do hope you enjoyed this game, and best of luck if you try again!");
				  System.exit(0);
 
			  }  
		  }  
		  
		  else if(myStats[3] < enemyStats[3]) {
			  
			  enemyCombat(enemyStats, myStats);
			 
			  while(battleChoice == 0) {
				  
				  String battleInfo = nullCheck.nullCheck(JOptionPane.showInputDialog(null, "Your Stats:\n HP: " + myStats[0] + "\n Attack: " + myStats[1] + "\n Defense: " + myStats[2] + "\n Speed: " + myStats[3] + "\n\n\n"
						  + "The Dragons Stats:\n HP: " + enemyStats[0] + "\n Attack: " + enemyStats[1] + "\n Defense: " + enemyStats[2] + "\n Speed: " + enemyStats[3] + 
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
			  myCombat(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags, battleChoice); 
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
						
			   		    JOptionPane.showMessageDialog(null, "There is no escaping this fight!"); 	 
						
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
				  JOptionPane.showMessageDialog(null, "Your Attack isn't high enough to do damage to the Dragon!"); 
				  
			  }
		 else {	  
		  if (newRand.randAttkSuccess() > 3) {
			  
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
		  else if (combatChoice == 2) {
				 final int RETRY = 0;
				 String choice;
				 while (RETRY >= 0) {
					 choice = JOptionPane.showInputDialog("Your Inventory:\n Health Potion: " + invo[0] + "\n Attack Boost: " + invo[1] + "\n Speed Boost: " + invo[2] +
								"\n Defence Boost: " + invo[3] + "\n Downstairs Key: " + invo[4] + "\n Upstairs Key: " + invo[5] + "\n Final Key: " + invo[6] +
								"\nSelect item to use or return to battle? \n1) Use Health Potion\n2) Use Attack Potion\n3) Use Defence Potion\n4) Use Speed Potion"
								+ "\n5) Return to battle!");
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
								  if (invo[3] > 0) {
								  int defUsed = invo[3] - 1;
								  JOptionPane.showMessageDialog(null, "You use a potion! It increases your defence to " + defBoost);
								  myStats[2] = defBoost;
								  invo[3] = defUsed;
								  }
								  else {
									  JOptionPane.showMessageDialog(null, "You don't have any defense potions.");
								  }
								
							}
							else if (number == 4) {
								  int spdBoost = myStats[3] + 1;
								  if (invo[2] > 0) {
								  int spdUsed = invo[2] - 1;
								  JOptionPane.showMessageDialog(null, "You use a potion! It increases your speed to " + spdBoost);
								  myStats[3] = spdBoost;
								  invo[2] = spdUsed;
								  }
								  else {
									  JOptionPane.showMessageDialog(null, "You don't have any speed potions.");
								  }
								
							}
							else if (number == 5) {
								JOptionPane.showMessageDialog(null, "Back to the battle! Good luck!");
								DragonFight(room, roomName, whereToGo, directions, myStats, enemyStats, invo, flags);
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

	  
	  public void enemyCombat(int[] enemyStats, int[] myStats) {
		  int hpChange = 0;
		  int attk = enemyStats[1] - myStats[2];
		  
		  if (newRand.randEnemySuccess() > 8) {
			  if(enemyStats[1] < myStats[2]) {
				  hpChange = myStats[0];
				  JOptionPane.showMessageDialog(null, "The Dragon's attack is unsuccessful!");
			
			  }
			  else {
				  if(newRand.randEnemyUsePotion() > 6) {
					  int enAttkIncrease = 8;
					  enemyStats[1] += enAttkIncrease;
					  JOptionPane.showMessageDialog(null, "The Dragon used an attack potion! Their attack was increased by " + enAttkIncrease);
				  
				  }
				  else {
					  hpChange = myStats[0] - attk;
					  myStats[0] = hpChange;
					  JOptionPane.showMessageDialog(null, "The Dragon's attack is successful! They deal " + attk + " damage!");
				  }
			  }
			  
			  
		  }
		  else {
			  
			  JOptionPane.showMessageDialog(null, "The Dragon's attack is unsuccessful!");
		  }
		  
	  }
	  public void emptyField (String field, int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
			
			if(field.isEmpty()) {
					JOptionPane.showMessageDialog(null, "You need to type something.");
				
							
					}
					
			}
	
}