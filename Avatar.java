package hw3;

import java.util.List;

import edu.du.dudraw.Draw;

public abstract class Avatar {

	protected GridPoint location;
	private TerrainMap tm;
	private PathFinder path;
	protected List<GridPoint> pathList = null;
	
	protected Avatar (TerrainMap tm, GridPoint location) {
		this.location = location;
		this.tm = tm;
		path = new PathFinder(tm);
	}
	
	
	public void draw(Draw duDwin) {
		int width = SimWindow.windowWidth / TerrainMap.gridWidth;
		int height = SimWindow.windowHeight / TerrainMap.gridHeight;
		
		String image = image();
		
		duDwin.picture(location.get_x() * width + width/2, location.get_y() * height - height/2, image, width, height);
		
	}
	
    public void handleMouseClick(int x, int y) {
    	GridPoint mouseClick = new GridPoint(x, y);
    	
    	pathList = path.findPath(location, mouseClick);
    	
    }
    
	public abstract void move();
	protected abstract String image();

	protected abstract int getTiredness();
	protected abstract int getTiredMax();

	protected abstract void removeTired();
	protected abstract void addTired();
	
}
