/**
 * 
 */
package carRental;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author b2038092 christopherkerr; c.kerr@ncl.ack.uk
 * @version 1.0
 */
public class LicenseNumberTest {
	LicenseNumber tester;
	PersonName pn;
    
		
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		String date = "11/10/1984";
	    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dateOfIssue = df.parse(date);
		Calendar cal = new GregorianCalendar();
		cal.setTime(dateOfIssue);
		int year = cal.get(Calendar.YEAR);
		pn = new PersonName("Chris", "Kerr");
		tester = LicenseNumber.getInstance("CK", year, 9);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception { tester = null;}

	/**
	 * Test method for {@link carRental.LicenseNumber#getInstance(java.lang.String, java.util.Date, int)}.
	 * @throws ParseException 
	 */
	@Test
	public final void testGetInstance() throws Exception {
		String date = "11/10/1984";
	    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dateOfIssue = df.parse(date);
		Calendar cal = new GregorianCalendar();
		cal.setTime(dateOfIssue);
		int year = cal.get(Calendar.YEAR);
		assertNotNull(tester);
		assertEquals(LicenseNumber.getInstance("CK", year, 9), tester);
		assertFalse(LicenseNumber.getInstance("SB", year, 3).equals(tester));
	}

	/**
	 * Test method for {@link carRental.LicenseNumber#getNameIdentifier(carRental.PersonName)}.
	 */
	@Test
	public final void testGetNameIdentifier() {
		assertEquals("CK", tester.getNameIdentifier(pn));
		assertNotNull(tester.getNameIdentifier(pn));
		assertNotSame("SB", tester.getNameIdentifier(pn));
	}

	/**
	 * Test method for {@link carRental.LicenseNumber#getYearOfIssue()}.
	 * @throws Exception 
	 */
	@Test
	public final void testGetYearOfIssue() throws Exception {
		assertNotNull(tester.getYearOfIssue());
		assertFalse(1900 == tester.getYearOfIssue());
	}

	/**
	 * Test method for {@link carRental.LicenseNumber#getSerialNumber()}.
	 */
	@Test
	public final void testGetSerialNumber() {
		assertNotNull(tester.getSerialNumber());
		assertFalse(10 == tester.getSerialNumber());
	}

	/**
	 * Test method for {@link carRental.LicenseNumber#toString()}.
	 * @throws Exception 
	 */
	@Test
	public final void testToString() throws Exception {
		String date = "11/10/1984";
	    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dateOfIssue = df.parse(date);
		Calendar cal = new GregorianCalendar();
		cal.setTime(dateOfIssue);
		int year = cal.get(Calendar.YEAR);
		assertEquals(LicenseNumber.getInstance("CK", year, 9), tester);
		assertNotNull(tester);
		assertNotSame(LicenseNumber.getInstance("SB", year, 3), tester);
	}

}
