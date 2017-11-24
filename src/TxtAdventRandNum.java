
import java.util.Random;
public class TxtAdventRandNum {

	Random R = new Random();
	public void randRoom(int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags)  {
	TxtAdventMainFloor newRoom = new TxtAdventMainFloor();
	Random R = new Random();
	int newStartRoom = R.nextInt(3) + 1;	
	switch(newStartRoom) {
	
	case(1):
	room = whereToGo[0][6];
	newRoom.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
	break;
	case(2):
	room = whereToGo[1][6];
	newRoom.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
	break;
	case(3):
	room = whereToGo[2][6];
	newRoom.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
	break;
	default:
	room = whereToGo[3][6];
	newRoom.Rooms(room, roomName, whereToGo, directions, myStats, invo, flags);
	break;
	}
  
	
	
	}
	
	public int randEnemyEnc() {
	
		int newInt = R.nextInt(9) + 1;
	    
		return newInt;
		
		
		}
	public int randDragonAttkInc() {
		
		int newInt = R.nextInt(9) + 1;
	    
		return newInt;
		
		
		}
	
	public int randEasyEnemySpd() {
		
		
		int newInt = R.nextInt(7) + 1;
		  
		return newInt;
	}
public int randMedEnemySpd() {
		
		
		int newInt = R.nextInt(12) + 1;
		  
		return newInt;
	}
public int randHardEnemySpd() {
	
	
	int newInt = R.nextInt(17) + 1;
	  
	return newInt;
}
	public int randBattleReward() {
		
		
		int newInt = R.nextInt(19) + 1;
		  
		return newInt;
	}
	public int randAttkSuccess() {
	
	
	int newInt = R.nextInt(9) + 1;
	  
	return newInt;
	}
	public int randEnemyUsePotion() {
		
		
		int newInt = R.nextInt(9) + 1;
		  
		return newInt;
		}
	public int randEnemySuccess() {
	
	
	int newInt = R.nextInt(9) + 1;
	  
	return newInt;
	}
	public int randDragonKeepQuestion() {
		
		
		int newInt = R.nextInt(9) + 1;
		  
		return newInt;
		}
}
