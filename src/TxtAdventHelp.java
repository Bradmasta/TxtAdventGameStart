
import javax.swing.*;
public class TxtAdventHelp {
	
	public void StartTxt() {
		
		JOptionPane.showMessageDialog(null, "Hello Adventurer! I see you've travelled many miles to reach this place!\n"
				+ "Here, your will to win and ability to nagivate/fight will be tested!\n"
				+ "Before you proceed however, there are some key things you need to know:\n"
				+ "For starts, there are only a few words/letters that are recogniziable by this game!\n These are North, South"
				+ ", East, West, Up, Down, Chest, Help, Inventory, Key, and Questsave\n"
				+ " (You can also use n, s, e, w, u, d, c, h, i, k, and q)\n"
				+ "Anything else you try won't work/be recognized except for the following exceptions:\n"
				+ "In combat, you will be asked to type 1, 2, 3, ect., as well as a few other prompts.\n"
				+ "If you ever feel the need to quit the game when it asks you for an input, hitting the Cancel button or the X button at the top of any window will do the trick!\n"
				+ "Before quitting out however, make sure you save the game using the Questsave or q input!\n"
				+ "One final note: If possible, explore everywhere! You never know what you'll find! There are some chests in the game that could save your life!\n"
				+ "I suppose that's it! I wish you luck on your journey!");
	
	}
public void Help(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
	TxtAdventMainFloor newRoom = new TxtAdventMainFloor();
	TxtAdventDungeon newDungeon = new TxtAdventDungeon();
	TxtAdventUpperFloor newUpper = new TxtAdventUpperFloor();
		
		JOptionPane.showMessageDialog(null, "I see you're in need of some help! While there's only so much I want to reveal about the game, i'll help as best as I can!\n"
				+ "The directions are North, South, East, West, Up, and Down.\n"
				+ "Other keywords are Chest, Help, Inventory, Key, and Questsave.\n"
				+ "You may also use n, s, e, w, d, u, c, h, i, k, and q for these inputs.\n"
				+ "You may be asked to type 1, 2, 3, ect.\n"
				+ "There is a point in the game where you'll be required to use A, B, C, or D; Just pay attention to when that might happen!\n"
				+ "There is a 30% chance of encounters on two of the floors, and it happens everytime you access a room that has encounter code.\n"
				+ "Whenever you finish a fight, you are \"sent\" back to the room you had the encounter, so that means there's a 30% chance you could get another encounter.\n"
				+ "Just be patient! The encounters will eventually end and you can proceed.\n"
				+ "Also keep in mind that saving is not possible during combat, so make sure to save outside of it(Also doesn't work while accessing your inventory)!\n"
				+ "The final fight at the end of the game is extremely difficult, so I would recommend stacking up your stats as much as possible before it, as well as saving often!\n"
				+ "Once you unlock an area, it remains unlocked permanently so long as the game is running or if you save your progess for later.\n"
				+ "Once you're ready to proceed, just hit enter, or Click the OK button!");
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

}
