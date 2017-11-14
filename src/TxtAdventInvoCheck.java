import java.util.*;

import javax.swing.JOptionPane;
public class TxtAdventInvoCheck {
	TxtAdventMainFloor newRoom = new TxtAdventMainFloor();
	TxtAdventDungeon newDungeon = new TxtAdventDungeon();
	TxtAdventUpperFloor newUpper = new TxtAdventUpperFloor();
	TxtAdventNullCheck nullCheck = new TxtAdventNullCheck();

	
		public void invoCheck(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
			 final int RETRY = 0;
			 int invoChoice = 0;
			 while (RETRY >= 0) {
				String invoInfo = null;
				invoInfo = nullCheck.nullCheck(JOptionPane.showInputDialog(null, "Your Inventory:\n Health Potion: " + invo[0] + "\n Attack Boost: " + invo[1] + "\n Speed Boost: " + invo[2] + "\n Defence Boost: " 
				+ invo[3] + "\n Downstairs Key: " 
				+ invo[4] + "\n Upstairs Key: " + invo[5] + "\n Final Key: " + invo[6] + "\n\nReturn to the game? \n1) Yes\n2) Not yet"));
				emptyField(invoInfo, room, roomName, whereToGo, directions, myStats, invo, flags);
				 
				 switch(invoInfo) {
				 case "1":
					 invoChoice = Integer.parseInt(invoInfo);
					 break;
				 case "2":
					 invoChoice = Integer.parseInt(invoInfo);
					 break;
				 default:
					 JOptionPane.showMessageDialog(null, "Not a valid option");
					 invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
					 
				 }
					try {
						if (invoChoice == 1) {
							
							JOptionPane.showMessageDialog(null, "And we continue!");
							if (room >=0 && room < 13 && room != 4) {
							newRoom.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							}
							else if (room > 13 && room < 29 || room == 4) {
							newDungeon.DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);	
							}
							else if (room >= 29 || room == 13) {
							newUpper.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
								
							}
							
						}
						else if (invoChoice == 2) {
							
							JOptionPane.showMessageDialog(null, "You should consider returning! Enemys lurk about!");
							invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
							
						}
						
						else {
							
							JOptionPane.showMessageDialog(null, "Not a valid option");
							invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
					
						}
						
					}
					catch (InputMismatchException error) {
							JOptionPane.showMessageDialog(null, "Can't use letters/symbols/other nonsense here!");
					}
					break;
				}
			 
		}
		
		public void emptyField (String field, int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
			
			if(field.isEmpty()) {
				JOptionPane.showMessageDialog(null, "You need to type something.");
			invoCheck(room, roomName, whereToGo, directions, myStats, invo, flags);
						
					}
				
			}
		
		public void endGame() {
			 JOptionPane.showMessageDialog(null, "More to come; Game still in construction!");
			System.exit(0);
		}
		
}
		
  



