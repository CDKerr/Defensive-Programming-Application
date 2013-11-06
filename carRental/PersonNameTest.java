/**
 * 
 */
package carRental;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author christopherkerr
 *
 */
public class PersonNameTest {
	PersonName tester;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {tester = new PersonName("Chris", "Kerr");}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {tester = null;}

	/**
	 * Test method for {@link carRental.PersonName#getInstance(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testGetInstance() {
		assertEquals("Chris Kerr", tester.toString());
		assertNotNull("The getInstance is not null", tester);
		PersonName pn = new PersonName("Sara", "Bell");
		assertFalse(pn  == tester);
	}

	/**
	 * Test method for {@link carRental.PersonName#getFirstName()}.
	 */
	@Test
	public final void testGetFirstName() {
		assertEquals("Chris", tester.getFirstName());
		assertFalse("Sara".equals(tester.getFirstName())); 
		assertTrue("Chris".equals(tester.getFirstName()));
		assertNotNull(tester.getFirstName());
	}

	/**
	 * Test method for {@link carRental.PersonName#getLastName()}.
	 */
	@Test
	public final void testGetLastName() {
		assertEquals("Kerr", tester.getLastName());
		assertFalse("Bell".equals(tester.getLastName())); 
		assertTrue("Kerr".equals(tester.getLastName()));
		assertNotNull(tester.getLastName());
	}

	/**
	 * Test method for {@link carRental.PersonName#toString()}.
	 */
	@Test
	public final void testToString() {
		assertEquals("Chris Kerr", tester.toString());
		assertNotNull(tester.toString());
		assertTrue("Chris Kerr".equals(tester.toString()));
		assertFalse("Sara Bell".equals(tester.toString()));
	}

}
