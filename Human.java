package hw3;

public class Human extends Avatar{
	
	private TerrainMap tm;
	String image;

	protected Human(TerrainMap tm, GridPoint location) {
		super(tm, location);
		this.tm = tm;
		this.image = "zhon.png";
	}

	@Override
	public void move() {
		for (GridPoint point : pathList) {
			
		}
		
	}
	
	public String image() {
		return this.image;
	}
	
}
