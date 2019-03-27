import javax.swing.*;
public class TxtAdventGameStart {
	
	/****************************
	 * Game begins here. 
	 * If possible, please play the game before looking at the source code, as that will reveal certain features of the
	 * game and potentially ruin the fun of it!
	 ****************************/


	public static void main(String[] args) {
		
		TxtAdventHelp start = new TxtAdventHelp();
		TxtAdventBeginData startData = new TxtAdventBeginData();
		
		TxtAdventSave load = new TxtAdventSave();
		TxtAdventRandNum newRand = new TxtAdventRandNum();
		
		TxtAdventNullCheck nullCheck = new TxtAdventNullCheck();
		
		
		java.io.File file = new java.io.File("save.txt");
		
		
		// Pulls in data from the Begin Data class
		int room = startData.BeginDataRoom();
		String[] roomName = startData.BeginDataRoomName();
		int[][] whereToGo = startData.BeginDataWhereToGo();
		String[] directions = startData.BeginDataDirections();
		int[] myStats = startData.BeginDataMyStats();
		int[] invo = startData.BeginDataInvo();
		int[] flags = startData.BeginDataFlags();
		
		if(file.exists()) {
			// if the program detects a save, it will ask if you want to load the save, or if you want to start a new game.

			

			String choiceInfo = nullCheck.nullCheck(JOptionPane.showInputDialog(null, "Looks like a save file exists! Do you want to continue where the game was last saved, or start a new game?\n"
					+ "1) Continue\n2) Start over!"));
		

			// First switch changes a String to an Int, second switch executes the choice made.
			
			switch(choiceInfo) {
			
			case "1":
					// Will execute loading the save file, assuming the file exists.
					load.Load(room, roomName, whereToGo, directions, myStats, invo, flags);
			
				break;
			
			case "2":
				// Will delete the current save file and start a new game.
				file.delete();
				start.StartTxt();
				
					newRand.randRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				
				break;
				
				
				
			default:
				if(choiceInfo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "You need to type something");
					main(args);
					
				}
				else {
				JOptionPane.showMessageDialog(null, "Invalid input.");
				main(args);
				}
				break;
				
		

			}
			
		}
		else {
		// If no Save exists, a new game will begin.
		start.StartTxt();
		newRand.randRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
		


		
		}
		
	}
}


