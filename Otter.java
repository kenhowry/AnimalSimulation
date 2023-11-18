package hw3;

import java.util.List;

public class Otter extends Avatar {
	
	private TerrainMap tm;
	String image;
	int tiredness;
	final int tiredMax;

	protected Otter(TerrainMap tm, GridPoint location) {
		super(tm, location);
		this.tm = tm;
		this.image = "otter.png";
		this.tiredness = 0;
		this.tiredMax = 4;
	}

	@Override
	public void move() {
	    List<GridPoint> neighbors = location.getNeighbors(1);
	    
	    GridPoint bestNeighbor = neighbors.get(0); 
	    int bestWet = 0;
	    
	    for (GridPoint neighbor : neighbors) {
	    	int currentWet = tm.getWet(neighbor);
	    	
	    	if (currentWet > bestWet) {
	    		bestWet = currentWet;
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
		this.tiredness += 3;
	}
	
	public void removeTired() {
		this.tiredness -= 1;
	}
}
