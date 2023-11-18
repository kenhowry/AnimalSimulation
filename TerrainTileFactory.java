package hw3;

public class TerrainTileFactory {

	public static TerrainTile newTerrainTile(String tileStr, GridPoint loc) throws InvalidTerrainTypeException {
		switch (tileStr) {
		case "w":
			return new Water(loc);
		case "g":
			return new Grass(loc);
		case "r":
			return new Road(loc);
		case "m":
			return new Mountain(loc);
		default:
			throw new InvalidTerrainTypeException("Invalid terrain type.");
		}
		
	}

}
