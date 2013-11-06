/**
 * LicenseNumber - immutable class for license number of drivers license
 */
package carRental;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author b2038092 christopherkerr; c.kerr@ncl.ac.uk
 * @version 1.0
 */
public final class LicenseNumber {
    private String nameIdentifier;
    private final int yearOfIssue;    
    private final int serialNumber;
	private final String stringRepresentation;
    private static final Map<String, LicenseNumber> LICENSENUMBERS = new HashMap<String, LicenseNumber>();
    
    /**
     * Constructor for the License number.
     * 
     * @param nameIdentifier unique name identifier for the license number. 
     * @param yearOfIssue year of issue of the license number.
     * @param serialNumber unique serial number of the license number. 
     * @throws ParseException 
     * @throws IllegalArguementException if nameIdentifier,yearOfIssue or serialNumber are null or out of bounds.
     */
    private LicenseNumber(String nameIdentifier, int yearOfIssue, int serialNumber, String stringRepresentation){
		this.nameIdentifier=nameIdentifier; 
		if(nameIdentifier.isEmpty())
            throw new IllegalArgumentException("The name Identifier is null");
		
		Date date = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        this.yearOfIssue = cal.get(Calendar.YEAR);
        Calendar todaysDate = Calendar.getInstance();
        if (this.yearOfIssue > todaysDate.get(Calendar.YEAR))
            throw new IllegalArgumentException("That is not a valid year of issue");
       
        Random randomNumber = new Random();
        this.serialNumber = randomNumber.nextInt(9) + 1;
        if (serialNumber < 0 || serialNumber > 10)
            throw new IllegalArgumentException("The number is not appropriate"); 
        
        this.stringRepresentation = stringRepresentation;
        }
    
    /**
     * Static Factory method to create a new instance of a License Number or return if already stored in Map.
     * 
     * @param nameIdentifier name identifier of the license number
     * @param yearOfIssue year of issue of the license number
     * @param serialNumber serial number of the license number
     * @return a new instance of a license number
     */
    public static LicenseNumber getInstance(String nameIdentifier, int yearOfIssue, int serialNumber){
    	String stringRepresentation = nameIdentifier + " " + yearOfIssue + " " + serialNumber;
    	LicenseNumber ln = LICENSENUMBERS.get(stringRepresentation);
    	if (ln == null){
    		ln = new LicenseNumber(nameIdentifier, yearOfIssue, serialNumber, stringRepresentation);
    		LICENSENUMBERS.put(stringRepresentation, ln);
    	}
    	return ln;
    }

    /**
     * get unique nameIdentifier method for the license number from the initials of first and last name.
     * 
     * @param PersonName person name to be used.
     * @return nameIdentifier the name identifier for the license number.
     */
    public String getNameIdentifier(PersonName pn){
    	nameIdentifier = pn.getFirstName().substring(0, 1) + pn.getLastName().substring(0, 1);
    	return nameIdentifier;}
    
    /**
     * get yearOfIssue method to get the year the license number was issued.
     * 
     * @return yearOfIssue year of issue.
     */
    public int getYearOfIssue(){return yearOfIssue;}
    
    /**
     * get serialNumber method to return the unique serial number of the license.
     * 
     * @return serialNumber unique serial number. 
     */
    public int getSerialNumber(){return serialNumber;}
 
    /**
     * toString method of nameIdentifier and yearOfIssue and serialNumber.
     * 
     * @see java.lang.Object#toString()
     */
    public String toString(){return stringRepresentation;}	
}