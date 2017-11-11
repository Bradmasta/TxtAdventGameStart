

public class TxtAdventGameStart {


	public static void main(String[] args) {
		TxtAdventBeginData startData = new TxtAdventBeginData();
		TxtAdventRandNum newRand = new TxtAdventRandNum();
		
		int room = startData.BeginDataRoom();
		String[] roomName = startData.BeginDataRoomName();
		int[][] whereToGo = startData.BeginDataWhereToGo();
		String[] directions = startData.BeginDataDirections();
		int[] myStats = startData.BeginDataMyStats();
		int[] invo = startData.BeginDataInvo();
		int[] flags = startData.BeginDataFlags();


		
		
		

		newRand.randRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
		
		
	}

}


