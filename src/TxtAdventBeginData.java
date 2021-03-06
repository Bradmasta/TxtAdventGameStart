    /************************
	 * This class includes all the data necessary to start the game.
	 ************************/
public class TxtAdventBeginData {
	
	
	public int BeginDataRoom() {
   /* Starts at 999 due to how save data works. During my testing of the save/load system, 
    * starting at a number that can exist resulted in that room always being the room you start out in upon loading.
    * While i'm fairly confident I fixed the issue, I've left it at this. So far, no issues has come up from it.
	*/
	int room = 999;
		return room;
	}
	public String[] BeginDataRoomName() {
		String roomName[] = {"Main Hall", "North Corridor", "East Corridor", "West Corridor", "Dungeon Entrance", "Side Closet",
				"Storage Room", "North Side Hall", "Broom Closet", "Treasure Room", "Empty Room",
				"Empty Room", "Empty Room", "Upper Stairwell", "Dungeon West Corridor", "Dungeon Barren Hallway", 
				"Dungeon Empty Chamber", "Dungeon East Corridor", "Dungeon Threeway Path", "Dungeon Corner Hallway", "Dungeon Deadend",
				"Dungeon Crossed Pathway", "Dungeon Dusty Corner Hallway", "Dungeon Dusty Straight Pathway", "Dungeon Dusty Split Hallway", "Dungeon Backroom",
				"Dungeon Cracked-Wall Room", "Dungeon Northern Hallway", "Dungeon Abandoned Room", "Upper Main Hall", "Upper Western Towers Split Hall",
				"Upper North-Western Tower", "Upper South-Western Tower", "Upper Eastern Towers Split Hall", "Upper North-Eastern Tower", "Upper South-Eastern Tower",
				"Final Castle Room", "Dragon Room"};
		return roomName;
			
		}
	public int[][] BeginDataWhereToGo() {
		// 38 rooms with a possible room based on North, South, East, West, Up, and Down. Room 37 is only a placeholder for now.
		int whereToGo[][] = 
			{{1, -1, 2, 3, -1, -1, 0}, {-1, 0, 6, 7, -1, -1, 1}, {-1, -1, 5, 0, -1, 4, 2}, {11, 12, 0, -1, 13, -1, 3}, {-1, -1, 14, 17, 2, -1, 4},
			{-1, -1, -1, 2, -1, -1, 5}, {-1, -1, -1, 1, -1, -1, 6}, {8, 10, 1, 9, -1, -1, 7}, {-1, 7, -1, -1, -1, -1, 8}, {-1, -1, 7, -1, -1, -1, 9},
			{7, -1, -1, -1, -1, -1, 10}, {-1, 3, -1, -1, -1, -1, 11}, {3, -1, -1, -1, -1, -1, 12}, {29, -1, -1, -1, -1, 3, 13}, {-1, 15, -1, 4, -1, -1, 14},
			{14, 16, -1, -1, -1, -1, 15}, {15, -1, -1, -1, -1, -1, 16}, {18, -1, 4, -1, -1, -1, 17}, {-1, 17, 21, 19, -1, -1, 18},
		    {-1, 20, 18, -1, -1, -1, 19}, {19, -1, -1, -1, -1, -1, 20}, {27, 22, -1, 18, -1, -1, 21}, {21, -1, 23, -1, -1, -1, 22},
		    {-1, -1, 24, 22, -1, -1, 23}, {25, 26, -1, 23, -1, -1, 24}, {-1, 24, -1, -1, -1, -1, 25}, {24, -1, -1, -1, -1, -1, 26},
		    {28, 21, -1, -1, -1, -1, 27}, {-1, 27, -1, -1, -1, -1, 28}, {36, 13, 33, 30, -1, -1, 29}, {31, 32, 29, -1, -1, -1, 30}, 
		    {-1, 30, -1, -1, -1, -1, 31}, {30, -1, -1, -1, -1, -1, 32}, {34, 35, -1, 29, -1, -1, 33}, {-1, 33, -1, -1, -1, -1, 34}, 
		    {33, -1, -1, -1, -1, -1, 35}, {37, 29, -1, -1, -1, -1, 36}, {-1, -1, -1, -1, -1, -1, 37}};
			
			return whereToGo;
		}
	public String[] BeginDataDirections() {
		String[] directions = {"North", "South", "East", "West", "Up", "Down"};
		return directions;
			
		}
	public int[] BeginDataMyStats() {
		// Health, Attack, Defense, Speed.
		int myStats[] = {260, 40, 40, 7};
		return myStats;
			
		}
	public int[] BeginDataInvo() {
		// Health Potion, Attack Potion, Defense Potion, Speed Potion, Downstairs Key, Upstairs Key, Final Key.
		int invo[] = {8, 4, 2, 0, 0, 0, 0};
		return invo;
			
		}
	public int[] BeginDataFlags() {
		// All the flags necessary to proceed throughout the game correctly.
		int flags[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		return flags;
			
		}
	
}
