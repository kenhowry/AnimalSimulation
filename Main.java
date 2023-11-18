package hw3;

public class Main {

	public static void main(String[] args) throws BadAvatarException {
		// Load in the map
		try {
			TerrainMap tm = new TerrainMap("map1.txt");

			// Make the display panel
			SimWindow window = new SimWindow(tm);

			Avatar goat = AvatarFactory.newAvatar("goat", tm, new GridPoint(11, 5));
			Avatar otter = AvatarFactory.newAvatar("otter", tm, new GridPoint(7, 14));
			Avatar duck = AvatarFactory.newAvatar("duck", tm, new GridPoint(7, 10));
			Avatar platypus = AvatarFactory.newAvatar("platypus", tm, new GridPoint(25, 13));
//			Avatar human = AvatarFactory.newAvatar("human", tm, new GridPoint(3, 1));
//			
			window.addAvatar(goat);
			window.addAvatar(otter);
			window.addAvatar(duck);
			window.addAvatar(platypus);
//			window.addAvatar(human);
			
			// Start the simulation
			window.runSimulation();
			
		}
		//exceptions
		catch (MalformedTerrainTypeException e){
			System.out.println("MalformedTerrainTypeException");
		}
		
		catch(InvalidTerrainTypeException e) {
			System.out.println("InvalidTerrainTypeException");
		}

	}
}
