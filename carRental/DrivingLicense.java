/**
 * Driving License - immutable class for driving license
 */
package carRental;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author b2038092 christopherkerr; c.kerr@ncl.ac.uk
 * @version 1.0
 */
public final class DrivingLicense {
    private final PersonName driversName;
    private final Date dateOfBirth, dateOfIssue;
    private final LicenseNumber licenseNumber;
    private final boolean isFullLicense;
    private static final Map <String, DrivingLicense> DRIVINGLICENSES = new HashMap <String, DrivingLicense>();

	 /**
	 * Constructor for DrivingLicense.
	 * 
	 * @param PersonName use of the PersonName class to get drivers name.
	 * @param dateOfBirth date of birth of the driver.
	 * @param LicenseNumber use of the LicenseNumber class to get license number.
	 * @param dateOfIssue date of issue of the driving license.
	 * @param isFullLicense boolean to see if the license is full or not.
	 * @throws IllegalArgumentException if either firstName or lastName is null.
	 * @throws NullPointerException if the date of birth or date of issue is null.
	 */
    private DrivingLicense(PersonName driversName, Date dateOfBirth, 
            LicenseNumber licenseNumber, Date dateOfIssue, boolean isFullLicense){
    	
          if (driversName.toString().isEmpty())
              throw new IllegalArgumentException("The drivers name is null");
          this.driversName = driversName;
        
          this.dateOfBirth=new Date(dateOfBirth.getTime());
		if (this.dateOfBirth.after(new Date((new Date().getTime()))))
              throw new IllegalArgumentException("The date of birth is null");
          
          if (licenseNumber.toString().isEmpty())
              throw new IllegalArgumentException("The license number is null");
          this.licenseNumber=LicenseNumber.getInstance(licenseNumber.getNameIdentifier(driversName), licenseNumber.getYearOfIssue(), licenseNumber.getSerialNumber());
          
          this.dateOfIssue=new Date(dateOfIssue.getTime());
          if (this.dateOfIssue.after(new Date((new Date().getTime()))))
              throw new IllegalArgumentException("The date of issue is null");
 
          this.isFullLicense=isFullLicense;
    }
    
    /**
	* Static Factory to produce new Driving License.
    * 
    * @param PersonName unique drivers name from the PersonName.toString.
    * @param dateOfBirth date of birth of the driver for the driving license.
    * @param licenseNumber unique license number from the LicenseNumber.toString.
    * @param dateOfIssue date of issue of the driving license.
    * @param isFullLicense boolean to check whether the license is full or not.
	* @return DrivingLicense.
	*/
	 public static DrivingLicense getInstance(PersonName driversName, Date dateOfBirth, LicenseNumber licenseNumber, Date dateOfIssue, boolean isFullLicense){
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 String stringRepresentation = driversName + sdf.format(dateOfBirth) + licenseNumber + sdf.format(dateOfIssue) + isFullLicense;
		 DrivingLicense dl = DRIVINGLICENSES.get(stringRepresentation);
		 if (dl == null){
			 dl = new DrivingLicense(driversName, dateOfBirth, licenseNumber, dateOfIssue, isFullLicense);
			 DRIVINGLICENSES.put(stringRepresentation, dl);
		 }
		 return dl;
	 }
    
	/**
	*Get the drivers name.
	* 
	*@return driversName driver's full name. 
	*/
    public PersonName getDriversName(){
    	return driversName;}
    
	 /**
	 * Get the license number.
	 * 
	 * @return licenseNumber the number of the driving license.
	 */
    public LicenseNumber getLicenseNumber(){
    	return LicenseNumber.getInstance(licenseNumber.getNameIdentifier(driversName), licenseNumber.getYearOfIssue(), licenseNumber.getSerialNumber());
    	}
    
	 /**
	 * Checks whether the license is full or not. 
	 * 
	 * @return IsFullLicense whether the license is full or not. 
	 */
    public boolean getIsFullLicense(){
    	if (isFullLicense != true)
    	return false;
    	else
        return isFullLicense;}

	 /**
	 * Get the date of birth of the driver.
	 * 
	 * @return dateOfBirth date of birth of the driver.
	 */
    public Date getDateOfBirth(){return (Date) dateOfBirth.clone();}

	 /**
	 * Get the date of issue of the driving license.
	 * 
	 * @return dateOfIssue date of issue of the driving license. 
	 */
    public Date getDateOfIssue(){return (Date)dateOfIssue.clone();}

	 /**
	 * toString method of drivers name, date of birth, license number, date of issue and is a full license.
	 * 
	 * @see java.lang.Object#toString()
	 */
	 @Override
	 public String toString(){
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 return "Drivers Name: " + driversName + "\n" + 
				 "Date of Birth: " + sdf.format(dateOfBirth) + "\n" + 
		          "License Number: " + licenseNumber + "\n" + 
				   "Date of Issue: " + sdf.format(dateOfIssue) + "\n" + 
		            "Is a Full License: " + isFullLicense;
		 }
}


