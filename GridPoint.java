package hw3;

import java.util.ArrayList;
import java.util.List;

/*
 * Class to represent an x and y grid location.
 */
public class GridPoint implements Comparable<GridPoint>{
	//variables for grid point
	private int x;
	private int y;
	
	//constructor
	public GridPoint(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	//getter method for x
	public int get_x(){
		return this.x;
	}

	//getter method for y
	public int get_y(){
		return this.y;
	}
	
	//override
	public String toString(){
		return "(" + x + "," + y + ")";
	}
	
	//override
	public boolean equals(Object obj){
		//if they are the same object
		if (this == obj) {
			return true;
		}
		
		//checking if it is an instance of Card
		if (!(obj instanceof GridPoint)) {
			return false;
		}
		
		GridPoint that = (GridPoint)obj;
		
		return this.compareTo(that) == 0;
	}
	
	//override
	public int hashCode(){
		return (x + "," + y).hashCode();
	}

	//override
	public int compareTo(GridPoint that){
	    if (this.x > that.x) {
	    	return 1;
	    }
	    if (this.x < that.x){
	    	return -1;
	    }
	    
	    if (this.y > that.y) {
	    	return 1;
	    }
	    if (this.y < that.y){
	    	return -1;
	    }
	    
	    //both x and y are equal
	    return 0;
	}
	
	//returns a list of the neighboring GridPoints
	public List<GridPoint> getNeighbors(int levels) {
		//creating a new list
	    List<GridPoint> neighbors = new ArrayList<>();

	    // Loop through x and y coordinates around the current point
	    for (int dx = -levels; dx <= levels; dx++) {
	        for (int dy = -levels; dy <= levels; dy++) {
	            // Skip the point itself
	            if (dx == 0 && dy == 0) {
	                continue;
	            }

	            // Calculate the coordinates of the potential neighbor
	            int neighborX = this.x + dx;
	            int neighborY = this.y + dy;

	            // Check if the potential neighbor is within the grid bounds
	            if (neighborX >= 0 && neighborX < TerrainMap.gridWidth && neighborY >= 0 && neighborY < TerrainMap.gridHeight) {
	                // Create a new GridPoint for the valid neighbor and add it to the list
	                GridPoint neighbor = new GridPoint(neighborX, neighborY);
	                neighbors.add(neighbor);
	            }
	        }
	    }

	    return neighbors;
	}
}
