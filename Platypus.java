package hw3;

import java.util.List;

public class Platypus extends AquaticMammals{

	TerrainMap tm;
	String image; 
	int tiredness;
	final int tiredMax;
	
	protected Platypus(TerrainMap tm, GridPoint location) {
		super(tm, location);
		this.tm = tm;
		this.image = "plat_swim.png";
		this.tiredness = 0;
		this.tiredMax = 3;
	}

	@Override
	public void move() {
	    List<GridPoint> neighbors = location.getNeighbors(3);
	    
	    GridPoint bestNeighbor = neighbors.get(0); 
	    
	    int bestWet = 0;
	    int bestVeg = 0;
	    
	    for (GridPoint neighbor : neighbors) {
	    	int currentWet = tm.getWet(neighbor);
	    	int currentVeg = tm.getVeg(neighbor);
	    	
	    	if (currentWet > bestWet || currentVeg > bestVeg ) {
	    		bestWet = currentWet;
	    		bestVeg = currentVeg;
	    		bestNeighbor = neighbor;
	    		}
	    	}
	    
	    location = bestNeighbor;
	    
	    if (tm.get(bestNeighbor).getWet() > 50) {
	    	inWater();
	    }
	    else {
	    	onLand();
	    }
	    
	    tm.get(bestNeighbor).eat();
	}

	@Override
	protected String image() {
		return this.image;
	}


	@Override
	public void onLand() {
		this.image = "plat_walk.png";
		
	}

	@Override
	public void inWater() {
		this.image = "plat_swim.png";
	}
	
	public int getTiredness(){
		return this.tiredness;
	}
	
	public int getTiredMax() {
		return this.tiredMax;
	}
	
	public void addTired() {
		this.tiredness += 10;
	}
	
	public void removeTired() {
		this.tiredness -= 1;
	}

}
