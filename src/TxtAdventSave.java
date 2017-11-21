import java.util.Scanner;
import javax.swing.*;


public class TxtAdventSave {
	
	public void Save(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) throws Exception {
		TxtAdventUpperFloor newUpper = new TxtAdventUpperFloor();
		TxtAdventMainFloor newRoom = new TxtAdventMainFloor();
		TxtAdventDungeon newDungeon = new TxtAdventDungeon();
		
		
		
		java.io.File file = new java.io.File("save.txt");


		
		
		if(file.exists()) {
			java.io.PrintWriter output = new java.io.PrintWriter(file);
			JOptionPane.showMessageDialog(null, "Save detected. Saving the game now!");
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
			
			
		}
		else {
			JOptionPane.showMessageDialog(null, "No save file detected. Saving the game now!");
			java.io.PrintWriter output = new java.io.PrintWriter(file);
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
			
		}

		
		
	}
	
	public void Load(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) throws Exception{
		TxtAdventUpperFloor newUpper = new TxtAdventUpperFloor();
		TxtAdventMainFloor newRoom = new TxtAdventMainFloor();
		TxtAdventDungeon newDungeon = new TxtAdventDungeon();
		java.io.File file = new java.io.File("save.txt"); 

		if (file.exists()){ 
 
			Scanner input = new Scanner(file);

			
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
						
			}
			input.close();
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