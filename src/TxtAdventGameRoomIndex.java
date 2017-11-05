
public class TxtAdventGameRoomIndex {
	
	public void TxtAdventGameRoomIndex() {
		
		
	}
	
	public void room (int room, String roomName[], int[][] whereToGo, String[] directions, int[] myStats, int[] invo, int[] flags) {
		
		TxtAdventGameMainFloor newFloor = new TxtAdventGameMainFloor();
		TxtAdventGameBasement newBaseFlr = new TxtAdventGameBasement();
		TxtAdventGameUpstairsMain newUpFlr = new TxtAdventGameUpstairsMain();
		if (room == 0) {
			room = whereToGo[0][6];
			newFloor.MainHall(room, roomName, whereToGo, directions, myStats, invo, flags);
			
		}
		else if (room == 1) {
			room = whereToGo[1][6];
			newFloor.MainFloorNCorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
			
		}
		else if (room == 2) {
			room = whereToGo[2][6];
			newFloor.MainFloorECorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
			
		}
		else if (room == 3) {
			room = whereToGo[3][6];
			newFloor.MainFloorWCorridor(room, roomName, whereToGo, directions, myStats, invo, flags);
			
		}
		else if (room == 4) {
			room = whereToGo[4][6];
			newBaseFlr.BasementMain(room, roomName, whereToGo, directions, myStats, invo, flags);
			
		}
		else if (room == 5) {
			room = whereToGo[5][6];
			newFloor.MainERoom(room, roomName, whereToGo, directions, myStats, invo, flags);
		}
		else if (room == 6) {
			room =  whereToGo[6][6];
			newFloor.MainNERoom(room, roomName, whereToGo, directions, myStats, invo, flags);
			
		}
		else if (room == 7) {
			room = whereToGo[7][6];
			newFloor.MainNWHall(room, roomName, whereToGo, directions, myStats, invo, flags);
			
		}
		else if (room == 8) {
			room = whereToGo[8][6];
			newFloor.MainNWNRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
			
		}
		else if (room == 9) {
			room = whereToGo[9][6];
			newFloor.MainNWWRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
			
		}
		else if (room == 10) {
			room = whereToGo[10][6];
			newFloor.MainNWSRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
			
		}
		else if (room == 11) {
			room = whereToGo[11][6];
			newFloor.MainWNRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
			
		}
		else if (room == 12) {
			room = whereToGo[12][6];
			newFloor.MainWSRoom(room, roomName, whereToGo, directions, myStats, invo, flags);
			
		}
		else if (room == 13) {
			room = whereToGo[13][6];
			newUpFlr.UpstairsMain(room, roomName, whereToGo, directions, myStats, invo, flags);
			
		}
	}

}
