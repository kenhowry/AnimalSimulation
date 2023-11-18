package hw3;

import java.util.ArrayList;

import edu.du.dudraw.Draw;
import edu.du.dudraw.DrawListener;

public class SimWindow implements DrawListener {

	// Some static constants that everyone can use
	//   the represent the window size
	public final static int windowWidth = 1050;
	public final static int windowHeight = 700;

	private TerrainMap tm;
	private Draw duDwin;
	private ArrayList<Avatar> avaList = new ArrayList<>();

	public SimWindow(TerrainMap tm) {

		// Setup the DuDraw window
		duDwin = new Draw("COMP2381 Animal Simulation"); // The OO version of DUDraw
		duDwin.setCanvasSize(SimWindow.windowWidth, SimWindow.windowHeight);
		duDwin.enableDoubleBuffering(); // Too slow otherwise -- need to use .show() later

		// Set the scale of the window
		// Right now it is set to match the pixels
		duDwin.setXscale(0, SimWindow.windowWidth);
		duDwin.setYscale(0, SimWindow.windowHeight);

		duDwin.addListener(this);
		
		this.tm = tm;
	}
	
	public void addAvatar(Avatar a){
		avaList.add(a);
	}

	public void update() {
		//clearing the window and drawing the TerrainMap
		duDwin.clear();
		tm.draw(duDwin);
		
		for (Avatar ava : avaList) {
			ava.draw(duDwin);
			
			if (ava.getTiredness() > ava.getTiredMax()){
				ava.removeTired();
				continue;
			}
			
			ava.move();
			ava.addTired();
			
		}
		
		duDwin.show();  // used in double buffering
	}

	public void runSimulation() {
		// This is the main game loop
		update(); // Initial positing

		while(true) {

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			update();
		}	
	}

	@Override
	public void keyPressed(int arg0) {
		
	}

	@Override
	public void keyReleased(int arg0) {
		
	}

	@Override
	public void keyTyped(char arg0) {
		
	}

	@Override
	public void mouseClicked(double arg0, double arg1) {
		
	}

	@Override
	public void mouseDragged(double arg0, double arg1) {
		
	}

    @Override
    public void mousePressed(double x, double y) {
        // Process the mouse click
        for (Avatar avatar : avaList) {
            int gridX = (int) (x / (SimWindow.windowWidth / TerrainMap.gridWidth));
            int gridY = (int) (y / (SimWindow.windowHeight / TerrainMap.gridHeight));

            // Assuming you want to inform each avatar about the mouse click
            avatar.handleMouseClick(gridX, gridY);
        }
    }
    

	@Override
	public void mouseReleased(double arg0, double arg1) {
		
	}
}