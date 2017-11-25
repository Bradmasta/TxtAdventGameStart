
import javax.swing.JOptionPane;


public class TxtAdventPrompts {
	/*******************************************************************
	 * This class is pretty self explanatory: It contains probably 95% of all the prompts used throughout the game.
	 * Most classes are of return type void, but a few return a string depending on which prompt is needed.
	 * Feel free to scroll down to read the prompts, but the player should see most of these just by playing the game.
	 *******************************************************************/
	
	
	
	TxtAdventBeginData newDirection = new TxtAdventBeginData();
	String[] directions = newDirection.BeginDataDirections();
	public void PromptKey() {
		
		JOptionPane.showMessageDialog(null, "You receive a key! Keep exploring to find out what it goes to! \nYou exit the room.");
		
		
	}
	public String PromptRoom26(int chestPrompt) {
		String retString = null;
		switch(chestPrompt) {
		case 0:
			retString = "You can't open this chest for some reason..";
			return retString;
		case 1:
			retString = "Your health being less than half has allowed you to open this chest!\n"
					+ "You receive 3 Health, Attack, and Defense Potions!";
			return retString;
		default:
		return retString;
		
		
		}
			
		}
public String PromptNeedType() {
		
	String retString = "You need to type something.";
	
	return retString;
		
		
	}
public void PromptAlreadyOpen() {
		
	JOptionPane.showMessageDialog(null, "You've already opened this chest. \nYou exit the room.");
		
		
	}
public void PromptNoChest() {
	JOptionPane.showMessageDialog(null, "There isn't a chest here!");
	
	
	
}
public void PromptCantUseKey() {
	
	
	JOptionPane.showMessageDialog(null, "You can't use a key here!");
	
}
public void PromptSafely() {
	
	
	JOptionPane.showMessageDialog(null, "You got away safely");
	
}
public void PromptIncorrect() {
	
	JOptionPane.showMessageDialog(null, "If this message if shown, I coded something incorrectly.");	
	
	
}
public String PromptChestTxt(int chestOption) {
	String retString= null;
	switch(chestOption) {
	
	case 0:
	retString = "\nYou see a chest! Wonder what's inside..";
	return retString;

	
	case 1:
	retString = "\nYou see an already opened chest!";	
	return retString;
	
	case 2:
	retString = " or would you like to open the chest? (Type 'Chest' or 'c' to do so!)";	
	return retString;
	
	default:
	return retString;
	
	
	}
		
	
}

public String PromptQRightWrong(int rightWrong) {
	String retString= null;
	switch(rightWrong) {
	
	case 0:
	JOptionPane.showMessageDialog(null, "That is correct! You may now move on if you so chose to!");
	return retString;

	
	case 1:
	JOptionPane.showMessageDialog(null, "WRONG! Your health is now halved! Down to the dungeon you go!");	
	JOptionPane.showMessageDialog(null, "You are knocked out by the guardian");
	JOptionPane.showMessageDialog(null, "You wake up in some pain, but you're still alive. Onward!");
	return retString;
	
	
	default:
	return retString;
	
	
	}
		
	
}
public void PromptCantGoDirection(int directNumber) {
	
	switch(directNumber) {
	
	case 0:
	JOptionPane.showMessageDialog(null, "You can't go " + directions[0]);
	break;
	
	case 1:
	JOptionPane.showMessageDialog(null, "You can't go " + directions[1]);
	break;
	
	case 2:
	JOptionPane.showMessageDialog(null, "You can't go " + directions[2]);
	break;
	
	case 3:
	JOptionPane.showMessageDialog(null, "You can't go " + directions[3]);
	break;
	
	case 4:
	JOptionPane.showMessageDialog(null, "You can't go " + directions[4]);
	break;
	
	case 5:
	JOptionPane.showMessageDialog(null, "You can't go " + directions[5]);
	break;
	
	default:
	PromptIncorrect();
	break;
	
	
	
	}
	
	
}
public String PromptBasicScript(int directionCase) {
	String retString = null;
	switch(directionCase) {
	
	case 0:
	retString =  "\nYou can go the following directions: \n" + directions[0] + "\nWhere do you want to go?";
	return retString;
	
	case 1:
		retString = "\nYou can go the following directions: \n" + directions[1] + "\nWhere do you want to go?";
		return retString;
		
	case 2:
		retString = "\nYou can go the following directions: \n" + directions[2] + "\nWhere do you want to go?";
		return retString;
		
	case 3:
		retString =  "\nYou can go the following directions: \n" + directions[3] + "\nWhere do you want to go?";
		return retString;
		
	case 4:
		retString =  "\nYou can go the following directions: \n" + directions[4] + "\nWhere do you want to go?";
		return retString;
		
	case 5:
		retString =  "\nYou can go the following directions: \n" + directions[5] + "\nWhere do you want to go?";
		return retString;
		
	case 6:
		retString =   "\nYou can go the following directions: \n" + directions[0] + ", " + directions[2] + ", " + directions[3] + "\nWhere do you want to go?";
		return retString;
		
	case 7:
		retString =  "\nYou can go the following directions: \n" + directions[1] + ", " + directions[2] + ", " + directions[3] + "\nWhere do you want to go?";
		return retString;
		
	case 8:
		retString =  "\nYou can go the following directions: \n" + directions[2] + ", " + directions[3] + ", " + directions[5] + "\nWhere do you want to go?";
		return retString;
		
	case 9:
		retString =  "\nYou can go the following directions: \n" + directions[0] + ", " + directions[1] + ", " + directions[2] + ", " + directions[4] + "\nWhere do you want to go?";
		return retString;
		
	case 10:
		retString =  "\nYou can go the following directions: \n" + directions[0] + ", " + directions[1] + ", " + directions[2] + ", " + directions[3] +  "\nWhere do you want to go?";
		return retString;
	case 11:
		retString =  "\nYou can go the following directions: \n" + directions[0] + ", " + directions[1] + ", " + directions[2] + "\nWhere do you want to go?";
		return retString;
	case 12:
		retString =  "\nYou can go the following directions: \n" + directions[0] + ", " + directions[1] + ", " + directions[3] + "\nWhere do you want to go?";
		return retString;
	case 13:
		retString =  "\nYou can go the following directions: \n" + directions[0] + ", " + directions[1] + "\nWhere do you want to go?";
		return retString;
	case 14:
		retString =  "\nYou can go the following directions: \n" + directions[2] + ", " + directions[3] + "\nWhere do you want to go?";
		return retString;
	case 15:
		retString =  "\nYou can go the following directions: \n" + directions[2] + ", " + directions[3] + ", " + directions[4] + "\nWhere do you want to go?";
		return retString;
	case 16:
		retString =  "\nYou can go the following directions: \n" + directions[1] + ", " + directions[3] + "\nWhere do you want to go?";
		return retString;
	case 17:
		retString =   "\nYou can go the following directions: \n" + directions[0] + ", " + directions[2] + "\nWhere do you want to go?";
		return retString;
	case 18:
		retString =   "\nYou can go the following directions: \n" + directions[1] + ", " + directions[2] + "\nWhere do you want to go?";
		return retString;
	case 19:
		retString =  "\nYou can go the following directions: \n" + directions[0] + ", " + directions[5] + "\nWhere do you want to go?";
		return retString;
	case 99:
		retString = "\nYou see a guardian of sorts in front of the northern door. \nYou can go the following directions: \n" + directions[0] + ", " + directions[1] +  "\nWhere do you want to go?";
		return retString;
	case 100:
		retString = "\nYou see the Dragon Guardian standing to the side of the northern door. \nYou can go the following directions: \n" + directions[0] + ", " + directions[1] +  "\nWhere do you want to go?";
		return retString;
	default:
		retString = "\nYou shouldn't see this.";
	return retString;
		
	
	
	}
	
	
}
public void PromptDarkKnight() {
	
	
	JOptionPane.showMessageDialog(null, "A Dark Knight Appears!");
	
}
public void PromptHellHound() {
	
	
	JOptionPane.showMessageDialog(null, "A Hellhound Appears");
	
}
public void PromptDrake() {
	
	JOptionPane.showMessageDialog(null, "A Drake appears!");
	
	
}
public void PromptDrakeSafe() {
	
	JOptionPane.showMessageDialog(null, "You hear the sounds of young drakes lurking about in nearby rooms, but this room is safe.");
	
	
}
public void PromptHellHoundSafe() {
	
	JOptionPane.showMessageDialog(null, "You hear the growling of some Hellhounds, but the room is safe.");
	
	
}

public void PromptDragonKeepFirstSee() {
	
	JOptionPane.showMessageDialog(null, "Ahh, so I see you've made it this far. \nI noticed you enter the Castle, and thought that you would have been destroyed by the many monsters that plague these halls.\n"
			+ "You are no ordinary fighter, I see that now. But, in order to fight the Dragon, you must answer one question for me.\nThink you can do it? We shall see.\nIf you get this right, you will have the "
			+ "privilege of fighting the almighty beast, but if you should fail..\nyou will be sent all the way down to the back of the dungeon and must work your way back up here.\nThat's not all though: You will "
			+ "lose half of your health! \n Also, I don't give the correct answer, so if you happen to get this question again, you'll still have to know what the answer is, or guess!\n"
			+ "So, I hope you're ready; you finishing this quest could very well depend on your answer to this question!");
	
	
}
public void PromptDragonKeepSecondSee() {
	
	JOptionPane.showMessageDialog(null, "So I see you're back for more.\nYou know the drill; You will answer a question for me.\nYou have a 1/10 chance of getting the same question,\nbut that won't mean anything if you "
			+ "still don't know the answer to the question you were asked before!");
	
	
}
}
