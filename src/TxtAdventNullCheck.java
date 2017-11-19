import javax.swing.JOptionPane;


public class TxtAdventNullCheck {	
	TxtAdventMainFloor newRoom = new TxtAdventMainFloor();
	TxtAdventDungeon newDungeon = new TxtAdventDungeon();
	TxtAdventUpperFloor newUpper = new TxtAdventUpperFloor();
	TxtAdventNullCheck nullCheck = new TxtAdventNullCheck();
	TxtAdventEncounters newEnc = new TxtAdventEncounters();
	TxtAdventPrompts newPrompt = new TxtAdventPrompts();
	TxtAdventInvoCheck newInvo = new TxtAdventInvoCheck();
	public String nullCheck(String check) {
		String nullCheck = null;
	
		try {

			 if (!check.equals(null)) {
			
			nullCheck = check;
			}
		}
		catch (NullPointerException error) {
			
			JOptionPane.showMessageDialog(null, "Goodbye :)");
			System.exit(0);
		}
		return nullCheck;
  }
	public void emptyField (String field, int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		
		if(field.isEmpty()) {
			if (room >=0 && room < 13 && room != 4) {
				newPrompt.PromptNeedType();
				newRoom.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
				}
				else if (room > 13 && room < 29 || room == 4) {
				newPrompt.PromptNeedType();
				newDungeon.DunRooms(room, roomName, whereToGo, directions, myStats, invo, flags);	
				}
				else if (room >= 29 || room == 13) {
				newPrompt.PromptNeedType();
				newUpper.UpperRooms(room, roomName, whereToGo, directions, myStats, invo, flags);
					
				}
				
			}
					
				}
		
	
}
