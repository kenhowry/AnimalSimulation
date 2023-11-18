package hw3;

public abstract class AquaticMammals extends Avatar {

	protected AquaticMammals(TerrainMap tm, GridPoint location) {
		super(tm, location);
	}

	
	public abstract void move();
	public abstract void onLand();
	public abstract void inWater();

}
