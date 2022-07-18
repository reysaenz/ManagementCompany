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
public class Property {
	
	// Class Variables
		private String name = "";
		private String city = "";
		private String owner = "";
		private double rentAmount = 0;
		private Plot plot;

		/*
		 * Constructor, no arguments
		 */
		public Property() {
			this.plot = new Plot();
		}

		/*
		 * Constructor with Name, City, Rent, Owner
		 * @param String name
		 * @param String city
		 * @param Double rent
		 * @param String owner
		 */
		public Property(String name, String city, double rent, String owner) {
			this.name = name;
			this.city = city;
			this.rentAmount = rent;
			this.owner = owner;
			this.plot = new Plot();
		}

		/*
		 * Constructor with Name, City, Rent, Owner, X, Y, Width, Depth
		 * @param String name
		 * @param String city
		 * @param Double rent
		 * @param String owner
		 * @param Int X
		 * @param Int Y
		 * @param Int Width
		 * @param Int Depth
		 */
		public Property(String name, String city, double rent, String owner, int X, int Y, int width, int depth) {
			this.name = name;
			this.city = city;
			this.rentAmount = rent;
			this.owner = owner;
			this.plot = new Plot(X, Y, width, depth);
		}

		/*
		 * Constructor to duplicate a property
		 */
		public Property(Property p) {
			this.name = p.getPropertyName();
			this.city = p.getCity();
			this.rentAmount = p.getRentAmount();
			this.owner = p.getOwner();
			this.plot = p.getPlot();
		}

		/*
		 * Get property city
		 */
		
		public String getCity() { 
			return this.city;
		}

		/*
		 * Get property owner
		 */
		
		public String getOwner() { 
			return this.owner; 
		}

		/*
		 * Get property plot
		 */
		
		public Plot getPlot() { 
			return this.plot; 
		}

		/*
		 * Get property name
		 */
		
		public String getPropertyName() { 
			return this.name; 
		}

		/*
		 * Get property rent
		 */
		
		public double getRentAmount() { 
			return this.rentAmount; 
		}

		/*
		 * Set property city
		 */
		
		public void setCity(String city) { 
			this.city = city; 
		}

		/*
		 * Set property owner
		 */
		
		public void setOwner(String owner) { 
			this.owner = owner;
		}

		/*
		 * Set property name
		 */
		
		public void setPropertyName(String name) { 
			this.name = name; 
		}

		/*
		 * Set property rent amount
		 */
		
		public void setRentAmount(double rent) { 
			this.rentAmount = rent; 
		}

		/*
		 * String Property
		 */
		
		public String toString() {
			// Variables
			String s = "";

			// Append
			s += "Property Name: " + this.getPropertyName();
			s += "\n" + "Located in " + this.getCity();
			s += "\n" + "Belonging to: " + this.getOwner();
			s += "\n" + "Rent Amount: " + this.getRentAmount();
			s += " ";

			// Return
			return s;
		}
}
