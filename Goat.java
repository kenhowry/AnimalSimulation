package hw3;

import java.util.List;

public class Goat extends Avatar {
	
	private TerrainMap tm;
	String image;
	int tiredness;
	final int tiredMax;

	protected Goat(TerrainMap tm, GridPoint location) {
		super(tm, location);
		this.tm = tm;
		this.image = "goat.png";
		this.tiredness = 0;
		tiredMax = 5;
	}

	@Override
	public void move() {
	    List<GridPoint> neighbors = location.getNeighbors(3);
	    
	    
	    GridPoint bestNeighbor = neighbors.get(0); 
	    int bestVeg = 0;
	  
	    for (GridPoint neighbor : neighbors) {
	    	int currentVeg = tm.getVeg(neighbor);
	    	
	    	if (currentVeg > bestVeg) {
	    		bestVeg = currentVeg;
	    		bestNeighbor = neighbor;
	    		}
	    	}
	    
	    location = bestNeighbor;
	    tm.get(bestNeighbor).eat();
	}

	@Override
	protected String image() {
		return this.image;
	}
	
	public int getTiredness(){
		return this.tiredness;
	}
	
	public int getTiredMax() {
		return this.tiredMax;
	}
	
	public void addTired() {
		this.tiredness += 1;
	}
	
	public void removeTired() {
		this.tiredness -= 1;
	}

}
