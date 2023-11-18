package hw3;

import edu.du.dudraw.Draw;

public class Road extends TerrainTile {

	//variables
	int vegetation;
	int wetness;
	int bump;
	
	public Road(GridPoint location){
		super(location);
		this.vegetation = 0;
		this.wetness = 0;
		this.bump = 0;
	}
	
	//override
	public void setColor(Draw duDwin){
		duDwin.setPenColor(255, 255, 0);
	}
	
	//getter methods
	public int getVeg() {
		return this.vegetation;
	}
	
	public int getWet() {
		return this.wetness;
	}
	
	public int getBumpy() {
		return this.bump;
	}

	@Override
	protected void eat() {
		
	}
}
