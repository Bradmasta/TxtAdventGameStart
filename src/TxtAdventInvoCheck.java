import java.util.*;
public class TxtAdventInvoCheck {


	
		public void invoCheck(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
			TxtAdventMainFloor newRoom = new TxtAdventMainFloor();
			TxtAdventUserInput newScan = new TxtAdventUserInput();
			TxtAdventDungeon newDungeon = new TxtAdventDungeon();
			TxtAdventUpperFloor newUpper = new TxtAdventUpperFloor();
			 final int RETRY = 0;
			 int choice;
			 System.out.println("Your Inventory:\n Health Potion: " + invo[0] + "\n Attack Boost: " + invo[1] + "\n Speed Boost: " + invo[2] + "\n Defence Boost: " + invo[3] + "\n Downstairs Key: " + invo[4] + "\n Upstairs Key: " + invo[5] + "\n Final Key: " + invo[6]);
			 System.out.println(" ");
			
			 while (RETRY >= 0) {
				 System.out.println("Return to the game?");
				 System.out.println(" ");
					System.out.println("1) Yes\n2) Not yet");
		
					try {
						choice = newScan.ScannerInt();
						if (choice == 1) {
							System.out.println("And we continue!");
							System.out.println(" ");
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
						else if (choice == 2) {
							System.out.println("You should consider returning! Enemys lurk about!");
							System.out.println(" ");
						}
						
						else {
							System.out.println("Not a valid option");
							System.out.println(" ");
							
					
						}
						
					}
					catch (InputMismatchException error) {
							System.out.println("Can't use letters/symbols/other nonsense here!");
					}
					break;
				}
			 
		}

		public void endGame() {
			
			System.out.println("More to come; Game still in construction!");
			System.exit(0);
		}
		
  }



