/**
 * Test class for the Driving license class
 */
package carRental;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author christopherkerr;
 * @version 1.0
 */
public class DrivingLicenseTest {
	DrivingLicense tester1, tester2, tester3, tester4;
	PersonName pn1, pn2;
	Calendar cal1, cal2, cal3, cal4;
    Date dateOfBirth1, dateOfBirth2, dateOfIssue1, dateOfIssue2;
    LicenseNumber ln1, ln2;
    boolean isFullLicense1, isFullLicense2;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		isFullLicense1 = true; isFullLicense2 = false; 
		
		pn1 = new PersonName ("Chris", " Kerr"); pn2 = new PersonName ("Sara", "Bell");
		
		cal1 = Calendar.getInstance(); cal1.set(1984, 10, 11); dateOfBirth1 = cal1.getTime(); 
		cal2 = Calendar.getInstance(); cal2.set(2001, 9, 21); dateOfIssue1 = cal2.getTime(); 
		cal3 = Calendar.getInstance(); cal3.set(1990, 4, 27); dateOfBirth2 = cal3.getTime();
		cal4 = Calendar.getInstance(); cal4.set(2007, 12, 17); dateOfIssue2 = cal4.getTime();
		
		String date = "11/10/1984";
	    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dateOfIssue = df.parse(date);
		Calendar cal = new GregorianCalendar();
		cal.setTime(dateOfIssue);
		int year = cal.get(Calendar.YEAR);
		
		ln1 = LicenseNumber.getInstance("CK", year, 9); ln2 = LicenseNumber.getInstance("SB", year, 3);
		
		tester1 = DrivingLicense.getInstance(pn1, dateOfBirth1, ln1, dateOfIssue1, isFullLicense1);
		tester2 = DrivingLicense.getInstance(pn1, dateOfBirth1, ln1, dateOfIssue1, isFullLicense1);
		tester3 = DrivingLicense.getInstance(pn2, dateOfBirth2, ln2, dateOfIssue2, isFullLicense2);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {tester1=null; tester2=null;tester3=null;}

	/**
	 * Test method for {@link carRental.DrivingLicense#DrivingLicense(carRental.PersonName, java.util.Date, carRental.LicenseNumber, java.util.Date, boolean)}.
	 */
	@Test
	public final void testDrivingLicense() {
		assertNotNull(tester1);
		assertFalse(tester1==tester3);
	}

	/**
	 * Test method for {@link carRental.DrivingLicense#getDriversName()}.
	 */
	@Test
	public final void testGetDriversName() {
		assertNotNull(tester2.getDriversName());
		assertFalse(tester1.getDriversName() == tester3.getDriversName());
	}

	/**
	 * Test method for {@link carRental.DrivingLicense#getLicenseNumber()}.
	 */
	@Test
	public final void testGetLicenseNumber() {
		assertNotSame(ln1, tester1.getLicenseNumber());
		assertNotNull(tester1.getLicenseNumber());
		assertFalse(tester2.getLicenseNumber()==tester3.getLicenseNumber());
	}

	/**
	 * Test method for {@link carRental.DrivingLicense#getIsFullLicense()}.
	 */
	@Test
	public final void testGetIsFullLicense() {
		assertEquals(isFullLicense1, tester1.getIsFullLicense());
		assertNotNull(tester3.getIsFullLicense());
		assertFalse(tester2.getIsFullLicense()==tester3.getIsFullLicense());
	}

	/**
	 * Test method for {@link carRental.DrivingLicense#getDateOfBirth()}.
	 */
	@Test
	public final void testGetDateOfBirth() {
		assertFalse(tester1.getDateOfBirth()==tester3.getDateOfBirth());
		assertNotSame(tester1.getDateOfBirth(), tester2.getDateOfBirth());
		assertNotNull(tester2.getDateOfBirth());
	}

	/**
	 * Test method for {@link carRental.DrivingLicense#dateOfIssue()}.
	 */
	@Test
	public final void testgetDateOfIssue() {
		assertFalse(tester1.getDateOfIssue()==tester3.getDateOfIssue());
		assertNotSame(tester1.getDateOfIssue(), tester2.getDateOfIssue());
		assertNotNull(tester2.getDateOfIssue());
	}

	/**
	 * Test method for {@link carRental.DrivingLicense#toString()}.
	 */
	@Test
	public final void testToString(){
		assertNotNull(tester1.toString());
		assertNotSame(tester1.toString(), tester2.toString());
	}

}
