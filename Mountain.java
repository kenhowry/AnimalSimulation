package hw3;
import java.util.Random;

import edu.du.dudraw.Draw;

public class Mountain extends TerrainTile {
	
	//variables
	Random random = new Random();
	int vegetation;
	int wetness;
	int bump;
	
	public Mountain(GridPoint location){
		super(location);
		this.vegetation = random.nextInt(51);
		this.wetness = 0;
		this.bump = 100;
	}
	
	//override
	public void setColor(Draw duDwin){
		int G = this.vegetation + 50;
		duDwin.setPenColor(100, G, 100);
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
		this.vegetation -= 5;
	}
}
