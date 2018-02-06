
public class EqualsAndhashCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*  Step1-   	By Definition ==,equals  compares physical address(indirectly it compares HashCode) i,e 
				Equal objects should have Same HashCode.
				HashCode returns Integer representation of physical Memory address.            */
		
		Pen p1 = new Pen("Abc", "blue",1);
		Pen p2 = new Pen("Dbc", "Black",1);
		Pen p3 = new Pen("abc", "blue",2);
		Pen p4 = new Pen("Abc", "blue",1);

		
		System.out.println("Details of P1" + p1 + "..." + p1.hashCode());
		System.out.println("Details of P2" + p2 + "..." + p2.hashCode());
		System.out.println("Details of P3" + p3 + "..." + p3.hashCode());
		System.out.println("Details of P4" + p4 + "..." + p4.hashCode());
		
		/*	 Step 2 - BEfore overriding Equals Method :
	 						Details of P1Pen@15db9742...366712642
							Details of P2Pen@6d06d69c...1829164700
							Details of P3Pen@7852e922...2018699554
							[Comparisons p1 && p2  ::]  false
		  					[Comparisons p2 && p3 ::]  false
		  					[Comparisons p1 && p3 ::] false 									*/

		 /* Step 3 -  Contradicts to real Time Scenario i.e Two pens are same if they have same color and same Brand.
		 	      So, To avoid Contradiction We Override Equals Method.
		   	      Override equals Method in such a way that objects are equal if they have same State.                 */

		/*  Step 4 -  After Overriding Equals Method :
		 					Details of P1Pen@15db9742...366712642
							Details of P2Pen@6d06d69c...1829164700
							Details of P3Pen@7852e922...2018699554
							[Comparisons p1 && p2  ::]  false
		  					[Comparisons p2 && p3 ::]  false
		  					[Comparisons p1 && p3 ::] true												*/

		
		/*   Step 5 -	We got the desired Output as P1 and p3 are Equal . are we good now ? we aren't. 
				Step 1 statement Fails . 
		  		i.e as hashCode is different but objects are equal, which is illegal.
				To avoid such conflicts we override HashCode method.
				Hence we can conclude and proved that,if Two objects are equal,then they should have same HashCode.
				This is the First Statement of HashCode and Equals Contract.                */
		
		/* Step 6 -  	Now the Converse Statement.. If Two Objects have same HashCode then can we say that Objects are Equal?? 
		  		doesnt the statement seems Silly !! How can we conclude the equality of  two objects based on their 
		  		hashCode(which is just a Memory Location and no concept of Object pooling here)
		     		without comparing their state ??                                         */
		
		/* Step 7 -    Finally, If Two Objects have Same HashCode then objects may or may not be Equal                      */
	}

}

class Pen {

	private String brand;
	private String colour;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	Pen(String Brand, String Colour,int id) {
		this.brand = Brand;
		this.colour = Colour;
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((colour == null) ? 0 : colour.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pen other = (Pen) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (colour == null) {
			if (other.colour != null)
				return false;
		} else if (!colour.equals(other.colour))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
