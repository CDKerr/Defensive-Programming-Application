/**
 * PersonName - immutable class for person name.
 */
package carRental;

/**
 * @author b238092 christopherkerr; c.kerr@ncl.ac.uk
 * @version 1.0
 */
public final class PersonName {
	 private final String firstName, lastName;
	 
	 
	 /**
	 * Constructor for PersonName.
	 * 
	 * @param firstName person first name of the person.
	 * @param lastName person last name of the person.
	 * @throws IllegalArgumentException if either firstName or lastName is null.
	 */
	 public PersonName(String firstName, String lastName){
	     if(firstName.isEmpty())
	        throw new IllegalArgumentException("First name is illegal");
	     if(lastName.isEmpty())
	        throw new IllegalArgumentException("Last name is illegal");
	        
	     this.firstName = firstName;
	     this.lastName = lastName;
	 }

	 /**
	 * get the first name.
	 * 
	 * @return firstName person first name
	 */
	 public String getFirstName(){return firstName;}
	    
	 /**
	 * get the last name.
	 * 
	 * @return lastName person last name
	 */
	 public String getLastName(){return lastName;}
	 
	 /**
	 * toString method of firstName and lastName.
	 * 
	 * @see java.lang.Object#toString()
	 */
	 @Override
	 public String toString(){return firstName + " " + lastName;}    
}
