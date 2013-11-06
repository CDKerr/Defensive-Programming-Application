/**
 * 
 */
package carRental;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author b2038092 christopherkerr; c.kerr@ncl.ac.uk
 * @version 1.0
 */
public class RegistrationNumberTest {
	RegistrationNumber tester;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {tester = RegistrationNumber.getInstance('a', 1234);}

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
		assertEquals(RegistrationNumber.getInstance('a', 1234), tester);
		assertNotNull("The getInstance is not null", tester);
		assertFalse(RegistrationNumber.getInstance('b', 1233) == tester);
	}

	/**
	 * Test method for {@link carRental.PersonName#getFirstName()}.
	 */
	@Test
	public final void testGetLetterIdentifier() {
		assertNotSame(tester.getLetterIdentifier(), 12345);
		assertNotNull(tester.getLetterIdentifier());
	}

	/**
	 * Test method for {@link carRental.PersonName#getLastName()}.
	 */
	@Test
	public final void testGetNumberIdentifier() {
		assertNotSame(tester.getNumberIdentifier(), -0001);
		assertFalse(4321 == (tester.getNumberIdentifier())); 
		assertNotNull(tester.getNumberIdentifier());
	}

	/**
	 * Test method for {@link carRental.PersonName#toString()}.
	 */
	@Test
	public final void testToString() {
		assertEquals("a1234", tester.toString());
		assertNotNull(tester.toString());
		assertTrue("a1234".equals(tester.toString()));
		assertFalse("b1231".equals(tester.toString()));
	}

}
