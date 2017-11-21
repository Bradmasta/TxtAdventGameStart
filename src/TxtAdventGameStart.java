

import javax.swing.*;
public class TxtAdventGameStart {


	public static void main(String[] args) throws Exception {
		
		startGame();
	}
	public static void startGame() throws Exception {
		TxtAdventHelp start = new TxtAdventHelp();
		TxtAdventBeginData startData = new TxtAdventBeginData();
		TxtAdventSave load = new TxtAdventSave();
		TxtAdventRandNum newRand = new TxtAdventRandNum();
		TxtAdventNullCheck nullCheck = new TxtAdventNullCheck();
		
		java.io.File file = new java.io.File("save.txt");
		
		
		
		int room = startData.BeginDataRoom();
		String[] roomName = startData.BeginDataRoomName();
		int[][] whereToGo = startData.BeginDataWhereToGo();
		String[] directions = startData.BeginDataDirections();
		int[] myStats = startData.BeginDataMyStats();
		int[] invo = startData.BeginDataInvo();
		int[] flags = startData.BeginDataFlags();
		
		if(file.exists()) {
			String choiceInfo = null;
			int choice = 0;
			choiceInfo = nullCheck.nullCheck(JOptionPane.showInputDialog(null, "Looks like a save file exists! Do you want to continue where it was last saved, or start a new game?\n"
					+ "1) Continue\n2) Start over!"));
			nullCheck.emptyField(choiceInfo, room, roomName, whereToGo, directions, myStats, invo, flags);
			 switch(choiceInfo) {
			 case "1":
				 choice = Integer.parseInt(choiceInfo);
				 break;
			 case "2":
				 choice = Integer.parseInt(choiceInfo);
				 break;
			 default:
				 JOptionPane.showMessageDialog(null, "Not a valid option");
				 startGame();
				 break;
				 
			 }
			
			switch(choice) {
			
			case 1:
				load.Load(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
			
			case 2:
				file.delete();
				start.StartTxt();
				newRand.randRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "Invalid input.");
				startGame();
				break;

			}
			
		}
		else {
		start.StartTxt();
		newRand.randRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
		}
		
	}

}


