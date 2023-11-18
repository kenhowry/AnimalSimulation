package hw3;

import edu.du.dudraw.Draw;

// This is an abstract class
public abstract class TerrainTile implements Drawable {
	
	// Every tile has a location
	private GridPoint location;
	
	protected TerrainTile (GridPoint location) {
		this.location = location;
	}

	// Draws the tile on the given Window
	public void draw(Draw duDwin) {
		
		// TODO: Get the derived class to set whatever color it wants by calling 
		// the abstract method.
		setColor(duDwin);
		
		// TODO: draw the tile in a standard way
		int width = SimWindow.windowWidth / TerrainMap.gridWidth;
		int height = SimWindow.windowHeight / TerrainMap.gridHeight;
		
		duDwin.filledRectangle(this.location.get_x() * width + width/2, this.location.get_y() * height - height/2, width/2, height/2);
	}
	
	// Part of the draw template for concrete tiles to set the color
	public abstract void setColor(Draw duDwin);

	protected abstract int getVeg();
	protected abstract int getWet();
	protected abstract int getBumpy();

	protected abstract void eat();
	
}