/*
 * Class: CMSC203 
 * Instructor:Grinberg
 * Description: App used to plot different housing and buildings in a given area. Able to return rent, location etc.
 * Due: 7/17/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Michael Bushman
*/
public class Plot {

	// Variables
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int depth = 0;
	
	/*
	 * Constructor, no arguments
	 */
	
	public Plot() {
		this.width = 1;
		this.depth = 1;
	}
	
	/*
	 * Copy constructor with arguments
	 */
	
	public Plot (Plot p) {
		 p = new Plot();
	}
	
	/*
	 * Constructor with arguments
	 * @param X cord
	 * @param Y cord
	 * @param Width
	 * @param Depth
	 */
	
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	/*
	 * Get X coordinate
	 */
	
	public int getX() { 
		return this.x; 
	}

	/*
	 * Get Y coordinate
	 */
	
	public int getY() { 
		return this.y; 
	}

	/*
	 * Get Width
	 */
	
	public int getWidth() { 
		return this.width;
	}

	/*
	 * Get Depth
	 */
	
	public int getDepth() { 
		return this.depth; 
	}

	/*
	 * Set X
	 * @param Int X
	 */
	
	public void setX(int x) { 
		this.x = x; 
	}

	/*
	 * Set Y
	 * @param Int Y
	 */
	
	public void setY(int y) {
		this.y = y; 
		
	}

	/*
	 * Set Width
	 */
	
	public void setWidth(int width) { 
		this.width = width; 
	}

	/*
	 * Set Depth
	 */
	
	public void setDepth(int depth) { 
		this.depth = depth; 
	}
	
	/*
	 * Check plot overlap
	 * @param Plot plot
	 */
	
	public boolean overlaps(Plot plot) {
		// Variables
		int result = 0;
		int plot1 = this.getX(); 
		int plot2 = plot.getX();
		int plot3 = this.getX() + this.getWidth(); 
		int plot4 = this.getY(); 
		int plot5 = plot.getY();
		int plot6 = this.getY() + this.getDepth();

		// Checks
		if (plot1 >= plot2 || plot2 <= plot3) { 
			result = 1; 
		}
		
		if (plot4 >= plot5 || plot5 <= plot6) { 
			result = 1; 
		}

		// Return
		return result == 0 ? false : true;
	}

	/*
	 * Check plot container
	 */
	
	public boolean encompasses(Plot plot) {
		// Variables
		int result = 0;
		int plot1 = this.getX(); 
		int plot2 = plot.getX();
		int plot3 = this.getX() + this.getWidth(); 
		int plot4 = this.getY(); 
		int plot5 = plot.getY();
		int plot6 = this.getY() + this.getDepth(); 

		// Checks
		if (plot1 + this.getWidth() > plot2) { 
			result = 1; 
		}
		
		if (plot4 + this.getDepth() > plot5) {
			result = 1; 
		}
		
		if (plot1 >= plot2 || plot2 <= plot3) { 
			result = 1; 
		}
		
		if (plot4 >= plot5 || plot5 <= plot6) { 
			result = 1; 
		}

		System.out.println("Encompasses: this.X" + plot1 + " P.X " + plot2);

		// Return
		return result == 0 ? false : true;
	}

	/*
	 * String plot
	 */
	
	public String toString() {
		// Variables
		String s = "";

		
		s += "(" + this.getX() + ", " + this.getY() + ")";
		s += "\n" + "Width: " + this.getWidth();
		s += "\n" + "Depth:" + this.getDepth();

		// Return
		return s;
	}
}
