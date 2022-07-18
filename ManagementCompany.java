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
public class ManagementCompany {
	// Configuration
	private int MAX_PROPERTY = 5;
	private int MGMT_WIDTH = 10;
	private int MGMT_DEPTH = 10;
	
	// Variables
	private String name;
	private String taxID;
	private double mgmFeePer;
	private Property properties[] = new Property[MAX_PROPERTY];
	private int currentPropertyIndex = -1;
	private Plot plot;
	
	
	/*
	 * Empty constructor, returns nothing and defaults values
	 */
	
	public ManagementCompany () {
		String name = "";
		String taxID = "";
		double mgmFeePer = 0.00;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		 
	}
	
	/*
	 * Constructor
	 * @param String Name
	 * @param String Tax ID #
	 * @param Double Management Fee Percentage
	 */
	
	public ManagementCompany(String name, String taxID, double mgmfee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmfee;
		this.plot = new Plot (0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	/*
	 * Constructor
	 * @param String Name
	 * @param String Tax ID #
	 * @param Double Management Fee Percentage
	 * @param Property X
	 * @param Property Y
	 * @param Property Width
	 * @param Property Depth
	 */
	
	public ManagementCompany(String name, String taxID, double mgmfee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmfee;
		this.plot = new Plot(x, y, width, depth);
	}
	
	/*
	 * Returns max amount of properties allowed
	 * @return Int MAX_PROPERTY
	 */
	public int getMAX_PROPERTY() {
		return this.MAX_PROPERTY;
	}
	
	/*
	 * Returns  highest rent property
	 */
	
	public String maxRentProp() {
		// Variables
		double max = 0;
		String s = "";

		// Loop
		for (int i = 0; i < this.properties.length; i++) {
			// Variables
			Property p = this.properties[i];

			if (p == null) { 
				continue; 
			}
			
			if (p.getRentAmount() > max) {
				max = p.getRentAmount();
				s = p.toString();
			}
		}


		// Return
		return (max > 0 ? s : "");
	}
	
	/*
	 * Returns total rent due
	 * @return Double rent total
	 */
	public double totalRent() {
		// Variables
		double total = 0;

		// Loop
		for (int i = 0; i < this.properties.length; i++) {
			
			if (this.properties[i] == null) { 
				continue; 
			}

			// Variables
			Property p = this.properties[i];
			total += p.getRentAmount();
		}

		// Return
		return (this.properties.length > 0 ? total : 0.00);
	}
	
	/*
	 * Returns management property plot
	 * @return Plot plot
	 */
	
	public Plot getPlot() { 
		return this.plot; 
	}

	/*
	 * Returns management company name
	 * @return String name
	 */
	
	public String getName() { 
		return this.name; }

	/*
	 * Returns string version of properties object
	 */
	
	public String toString() {
		// Variables
		String s = "";

		// Append
		s += "List of properties for " + this.getName() + ", TaxID: " + this.taxID;

		// Loop
		for (int i = 0; i < this.properties.length; i++) {
			
			if (this.properties[i] == null) { 
				continue; 
			}
			

			// Variables
			s += "\n" + this.properties[i].toString();
		}
		
		s += "\ntotal management Fee: " + (this.totalRent() * (this.mgmFeePer * 0.01));
		
		return s;
	}
	/*
	 * Add property (Property)
	 */
	
	public int addProperty(Property property) {
		// Variables
		int index = currentPropertyIndex;
		int newIndex = currentPropertyIndex + 1;
		
		if (newIndex >= this.MAX_PROPERTY) {
			return -1;
		}
		
		this.properties[newIndex] = new Property(property);
		
		currentPropertyIndex = newIndex;
		
		return newIndex;
	}
	
	/*
	 * Add property (Name, City, Rent, Owner)
	 */
	
	public int addProperty(String name, String city, double rent, String owner) {
		// Variables
		int index = currentPropertyIndex;
		int newIndex = currentPropertyIndex + 1;

		if (newIndex >= this.MAX_PROPERTY) { return -1; }
		

		// Variables
		this.properties[newIndex] = new Property(name, city, rent, owner);

		currentPropertyIndex = newIndex;
		return newIndex;
		
	}
	
	/*
	 * Add property (Name, City, Rent, Owner, X, Y, Width, Depth)
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		// Variables
		int index = currentPropertyIndex;
		int newIndex = currentPropertyIndex + 1;
		Plot tempPlot = new Plot(x, y, width, depth);

		
		if (newIndex >= this.MAX_PROPERTY) { 
			return -1; }
		
		if (this.plot.encompasses(tempPlot) == false) { 
			return -3; }
		
		if (index >= 0) {
			for (int i = 0; i < this.properties.length; i++) {
				// Checks
				if (this.properties[i] == null) { 
					continue; }
				
				if (this.properties[i].getPlot().overlaps(tempPlot) == true) { 
					return -4; 
					}
			}
	}

		// Variables
		this.properties[newIndex] = new Property(name, city, rent, owner, x, y, width, depth);

		
		currentPropertyIndex = newIndex;
		return newIndex;
	}
	
	
}
