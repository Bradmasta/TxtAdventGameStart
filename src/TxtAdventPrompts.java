import javax.swing.JOptionPane;

public class TxtAdventPrompts {
	TxtAdventBeginData newDirection = new TxtAdventBeginData();
	String[] directions = newDirection.BeginDataDirections();
	public void PromptKey() {
		
		JOptionPane.showMessageDialog(null, "You receive a key! Keep exploring to find out what it goes to! \nYou exit the room.");
		
		
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
	
	JOptionPane.showMessageDialog(null, "You hear noises in nearby rooms, but the room is safe.");
	
	
}

public void PromptDragonKeepFirstSee() {
	
	JOptionPane.showMessageDialog(null, "Ahh, so I see you've made it this far. \nI noticed you enter the Castle, and thought that you would have been destroyed by the many monsters that plague these halls.\n"
			+ "You are no ordinary fighter, I see that now. But, in order to fight the Dragon, you must answer one question for me.\nThink you can do it? We shall see.\nIf you get this right, you will have the "
			+ "privilege of fighting the almighty beast, but if you should fail..\nyou will be sent all the way down to the back of the dungeon and must work your way back up here.\nThat's not all though: You will "
			+ "lose half of your health! (rounded down if your health is an odd number)\n Also, I don't give the correct answer, so if you happen "
			+ "to get this question again, you'll still have to know what the answer is, or guess!\nOne other thing: Typing ANYTHING other than the correct choice will result in a failed attempt, so be careful!\nSo, I hope you're ready; you finishing this quest could very well depend on your answer to this question!");
	
	
}
public void PromptDragonKeepSecondSee() {
	
	JOptionPane.showMessageDialog(null, "So I see you're back for more.\nYou know the drill; You will answer a question for me.\nYou have a 1/10 chance of getting the same question,\nbut that won't mean anything if you "
			+ "still don't know the answer to the question you were asked before!");
	
	
}
}
