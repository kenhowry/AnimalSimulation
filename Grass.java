package hw3;

import edu.du.dudraw.Draw;

public class Grass extends TerrainTile {
	
	//variable
	int vegetation;
	int wetness;
	int bump;
	
	public Grass(GridPoint location){
		super(location);
		this.vegetation = 100;
		this.wetness = 25;
		this.bump = 0;
	}
	
	//override
	public void setColor(Draw duDwin){
		int G = 250 - this.vegetation;
		duDwin.setPenColor(0, G, 0);
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
	
	//method for eating
	public void eat() {
		this.vegetation -= 20;
	}

}