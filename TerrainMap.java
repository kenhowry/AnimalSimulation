package hw3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import edu.du.dudraw.Draw;

// The TerrainMap represents a 2D grid of Tiles

public class TerrainMap implements Drawable {

	private Map<GridPoint, TerrainTile> theTiles;

	// public static constants set in the constructor.
	public static int gridWidth;
	public static int gridHeight;

	// Constructor to read from file
	public TerrainMap(String filename) throws InvalidTerrainTypeException, MalformedTerrainTypeException {	
		theTiles = new HashMap<>();
		BufferedReader read = null;
 
		try {
			read = new BufferedReader(new FileReader(filename));
		}
		//FileNotFoundException
		catch(FileNotFoundException e){
			System.out.println("File not found.");
			System.exit(-1);
		}

		String mapSizeLine;
		try {
			mapSizeLine = read.readLine();

			String[] gridValues = mapSizeLine.split(" ");
			
			//reading the first line as a map height and width
			if(gridValues.length == 2) {
				try {
					gridWidth = Integer.parseInt(gridValues[0]);
					gridHeight = Integer.parseInt(gridValues[1]);
				}
				catch(NumberFormatException e) {
					throw new MalformedTerrainTypeException("Invalid map size format.");
				}

				String line;
				int row = 0;
				
				//reading the lines of the file
				while((line = read.readLine()) != null) {
					String[] tokens = line.split(" ");

					//iterating and appending the appropriate tile and location
					for (int col = 0; col < tokens.length; col++) {
						GridPoint gridPoint = new GridPoint(col, gridHeight - row);
						String terrainType = tokens[col];
						
						//calling TerrainTileFactory to put in the correct tile for the String
						TerrainTile tile = TerrainTileFactory.newTerrainTile(terrainType, gridPoint);
						theTiles.put(gridPoint, tile);
					}
					row++;	
				}
			}
			read.close();
		}
		//IOException
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//drawing the tile
	public void draw(Draw duDwin) {
		for (TerrainTile tile : theTiles.values()) {
			tile.draw(duDwin);
		}
	}
	
//	//property information
//	public int getVeg(GridPoint loc) {
//		return theTiles.get(loc).getVeg();
//	}
	
	public int getVeg(GridPoint loc) {
	    TerrainTile tile = theTiles.get(loc);
	    if (tile != null) {
	        return tile.getVeg();
	    }
	    
		return 0;
	}
	
	public int getWet(GridPoint loc) {
	    TerrainTile tile = theTiles.get(loc);
	    if (tile != null) {
	        return tile.getWet();
	    }
	    
		return 0;
	}
	
	public int getBump(GridPoint loc) {
	    TerrainTile tile = theTiles.get(loc);
	    if (tile != null) {
	        return tile.getBumpy();
	    }
	    
		return 0;
	}

	public TerrainTile get(GridPoint loc) {
		return theTiles.get(loc);
		
	}
	

}
