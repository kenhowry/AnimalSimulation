package hw3;

import java.util.List;

public class Duck extends AquaticMammals {

	private TerrainMap tm;
	String image;
	int tiredness;
	final int tiredMax;
	
	protected Duck(TerrainMap tm, GridPoint location) {
		super(tm, location);
		this.tm = tm;
		this.image = "duck_stand.png";
		this.tiredness = 0;
		this.tiredMax = 2;
	}

	@Override
	public void move() {
	    List<GridPoint> neighbors = location.getNeighbors(3);
	    
	    GridPoint bestNeighbor = neighbors.get(0); 
	    
	    int bestWet = 0;
	    int bestVeg = 50;
	    
	    for (GridPoint neighbor : neighbors) {
	    	int currentWet = tm.getWet(neighbor);
	    	int currentVeg = tm.getVeg(neighbor);
	    	
	    	if (currentWet > 25 || currentVeg > bestVeg ) {
	    		bestWet = currentWet;
	    		bestVeg = currentVeg;
	    		bestNeighbor = neighbor;
	    		}
	    	}
	    
	    location = bestNeighbor;
	    bestVeg = 50;
	    
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
		this.image = "duck_stand.png";
		
	}

	@Override
	public void inWater() {
		this.image = "duck_swim.png";
		
	}
	
	public int getTiredness(){
		return this.tiredness;
	}
	
	public int getTiredMax() {
		return this.tiredMax;
	}
	
	public void addTired() {
		this.tiredness += 6;
	}
	
	public void removeTired() {
		this.tiredness -= 1;
	}

}
