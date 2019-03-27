import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;


public class TxtAdventSave {
	/****************************************************************************
	 * This class handles saving and loading game data.
	 ****************************************************************************/
	
	
	TxtAdventUpperFloor newUpper = new TxtAdventUpperFloor();
	TxtAdventMainFloor newRoom = new TxtAdventMainFloor();
	TxtAdventDungeon newDungeon = new TxtAdventDungeon();
	TxtAdventNullCheck nullCheck = new TxtAdventNullCheck();
	public void Save(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		
		
		
		
		java.io.File file = new java.io.File("save.txt");
		//This is used to access information from a file called "save.txt"

		
		
		if(file.exists()) {
			String choiceInfo = nullCheck.nullCheck(JOptionPane.showInputDialog(null, "Save detected. What you like to overwrite the current save?\n1) Yes \n2) No"));
			if (choiceInfo.isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "You need to type something.");
				Save(room, directions, whereToGo, directions, flags, flags, flags);
			}
			//Will first ask player if they want to overwrite a save or not. Then, first switch converts from String to Int, second switch process request.
			
			else {
			switch(choiceInfo) {
			
			case "1":
				java.io.PrintWriter output;
				try {
					output = new java.io.PrintWriter(file);
					output.println(room);
					output.println(myStats[0]);
					output.println(myStats[1]);
					output.println(myStats[2]);
					output.println(myStats[3]);
					output.println(invo[0]);
					output.println(invo[1]);
					output.println(invo[2]);
					output.println(invo[3]);
					output.println(invo[4]);
					output.println(invo[5]);
					output.println(invo[6]);
					output.println(flags[0]);
					output.println(flags[1]);
					output.println(flags[2]);
					output.println(flags[3]);
					output.println(flags[4]);
					output.println(flags[5]);
					output.println(flags[6]);
					output.println(flags[7]);
					output.println(flags[8]);
					output.println(flags[9]);
					output.println(flags[10]);
					output.println(flags[11]);
					output.println(flags[12]);
					output.println(flags[13]);
					output.println(flags[14]);
					output.println(flags[15]);
					output.println(flags[16]);
					output.println(flags[17]);
					output.println(flags[18]);
					
					
					output.close();
					JOptionPane.showMessageDialog(null, "Save complete! And we continue!");
					if (room >=0 && room < 13 && room != 4) {
						newRoom.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
						}
						else if (room > 13 && room < 29 || room == 4) {
						newDungeon.DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);	
						}
						else if (room >= 29 || room == 13) {
						newUpper.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
							
						}
					break;
				} catch (FileNotFoundException e) {

					e.printStackTrace();
				}
				
				
			
			case "2":
				JOptionPane.showMessageDialog(null, "Save cancelled! and we continue!");
				if (room >=0 && room < 13 && room != 4) {
					newRoom.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					}
					else if (room > 13 && room < 29 || room == 4) {
					newDungeon.DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);	
					}
					else if (room >= 29 || room == 13) {
					newUpper.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
						
					}
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "Invalid input.");
				Save(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;

			}
			}
		}
		else {
			//if no save exists, a new save file is generated and populated with the values below.
			JOptionPane.showMessageDialog(null, "No save file detected. Saving the game now!");
			java.io.PrintWriter output;
			try {
				output = new java.io.PrintWriter(file);
				output.println(room);
				output.println(myStats[0]);
				output.println(myStats[1]);
				output.println(myStats[2]);
				output.println(myStats[3]);
				output.println(invo[0]);
				output.println(invo[1]);
				output.println(invo[2]);
				output.println(invo[3]);
				output.println(invo[4]);
				output.println(invo[5]);
				output.println(invo[6]);
				output.println(flags[0]);
				output.println(flags[1]);
				output.println(flags[2]);
				output.println(flags[3]);
				output.println(flags[4]);
				output.println(flags[5]);
				output.println(flags[6]);
				output.println(flags[7]);
				output.println(flags[8]);
				output.println(flags[9]);
				output.println(flags[10]);
				output.println(flags[11]);
				output.println(flags[12]);
				output.println(flags[13]);
				output.println(flags[14]);
				output.println(flags[15]);
				output.println(flags[16]);
				output.println(flags[17]);
				output.println(flags[18]);
				output.close();
				JOptionPane.showMessageDialog(null, "Save complete! And we continue!");
				if (room >=0 && room < 13 && room != 4) {
				newRoom.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
				else if (room > 13 && room < 29 || room == 4) {
				newDungeon.DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);	
				}
				else if (room >= 29 || room == 13) {
				newUpper.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			
		}

		
		
	}
	
	public void Load(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		TxtAdventUpperFloor newUpper = new TxtAdventUpperFloor();
		TxtAdventMainFloor newRoom = new TxtAdventMainFloor();
		TxtAdventDungeon newDungeon = new TxtAdventDungeon();
		java.io.File file = new java.io.File("save.txt"); 
		
		if (file.exists()){ 
			/*
			 * If the Save file exists and the player decides to continue where the last save took place,
			 * the file is read and the players stats, inventory, and all the flags triggered
			 * are loaded up and passed into the room method based on the room ID.
			 *  
			 */
			Scanner input;
			try {
				input = new Scanner(file);
				while (input.hasNext()){
					room = input.nextInt();
					myStats[0] = input.nextInt();
					myStats[1] = input.nextInt();
					myStats[2] = input.nextInt();
					myStats[3] = input.nextInt();
					invo[0] = input.nextInt();
					invo[1] = input.nextInt();
					invo[2]= input.nextInt();
					invo[3] = input.nextInt();
					invo[4] = input.nextInt();
					invo[5]= input.nextInt();
					invo[6] = input.nextInt();
					flags[0] = input.nextInt();
					flags[1] = input.nextInt();
					flags[2]= input.nextInt();
					flags[3] = input.nextInt();
					flags[4] = input.nextInt();
					flags[5] = input.nextInt();
					flags[6] = input.nextInt();
					flags[7] = input.nextInt();
					flags[8] = input.nextInt();
					flags[9] = input.nextInt();
					flags[10] = input.nextInt();
					flags[11] = input.nextInt();
					flags[12] = input.nextInt();
					flags[13] = input.nextInt();
					flags[14] = input.nextInt();
					flags[15] = input.nextInt();
					flags[16] = input.nextInt();
					flags[17] = input.nextInt();
					flags[18] = input.nextInt();
							
				}
				input.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			
			
			flags[18] = 1;
			JOptionPane.showMessageDialog(null, "You shall continue where you left off!");
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
     
		else {
			
			JOptionPane.showMessageDialog(null, "There is no save file to load!");
		}
	

}
	
}