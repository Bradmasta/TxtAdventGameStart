
import javax.swing.*;
public class TxtAdventGameStart {
	
	/****************************
	 * Game begins here. 
	 ****************************/


	public static void main(String[] args) {
		
		startGame();
	}
	public static void startGame() {
		// Uses data from the Help, Begin Data, Save, Random Number, and Null Check classes.
		TxtAdventHelp start = new TxtAdventHelp();
		TxtAdventBeginData startData = new TxtAdventBeginData();
		TxtAdventSave load = new
				TxtAdventSave();
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

			String choiceInfo = null;

			choiceInfo = nullCheck.nullCheck(JOptionPane.showInputDialog(null, "Looks like a save file exists! Do you want to continue where the game was last saved, or start a new game?\n"
					+ "1) Continue\n2) Start over!"));
		

			// First switch changes a String to an Int, second switch executes the choice made.
			
			switch(choiceInfo) {
			
			case "1":
				try {
					load.Load(room, roomName, whereToGo, directions, myStats, invo, flags);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			
			case "2":
				file.delete();
				start.StartTxt();
				try {
					newRand.randRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			default:
				if(choiceInfo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "You need to type something");
					startGame();
					
				}
				else {
				JOptionPane.showMessageDialog(null, "Invalid input.");
				startGame();
				}
				break;
				
		

			}
			
		}
		else {
		// If no Save exists, a new game will begin
		start.StartTxt();
		try {
			newRand.randRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		
	}
	
}


