/**
 * Test class for the AbstractCar class
 */
package carRental;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author christopherkerr; 
 * @version 1.0
 */
public class AbstractCarTest {
    private Car tester, tester2, tester3;
	private RegistrationNumber registrationNumber = RegistrationNumber.getInstance('a', 1234);
	private int fuelCapacity = 49;
	private int fuelInCar = 10;
	private boolean carRented = true;
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tester = AbstractCar.getInstance("small car", registrationNumber, fuelCapacity, fuelInCar, carRented);
		tester2 = AbstractCar.getInstance("large car", registrationNumber, fuelCapacity, fuelInCar, carRented);
		tester3 = tester;
		}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {tester = null;}

	/**
	 * Test method for {@link carRental.AbstractCar#AbstractCar(carRental.RegistrationNumber, int, int, boolean)}.
	 */
	@Test
	public final void testAbstractCar() {
		assertNotNull(tester);
		assertFalse (tester == tester2);
		
		assertEquals(tester, tester3);
	}

	/**
	 * Test method for {@link carRental.AbstractCar#getInstance(java.lang.String, carRental.RegistrationNumber, int, int, boolean)}.
	 */
	@Test
	public final void testGetInstance() {
		assertNotNull(AbstractCar.getInstance("small car", registrationNumber, fuelCapacity, fuelInCar, carRented));
		assertNotSame (tester2, tester);
		assertFalse(tester == tester2);
	}

	/**
	 * Test method for {@link carRental.AbstractCar#toString()}.
	 */
	@Test
	public final void testToString() {
		assertNotNull(tester.toString());
		assertNotSame(tester2.toString(), tester.toString());
		assertEquals(tester.toString(), tester3.toString());
	}

	/**
	 * Test method for {@link carRental.AbstractCar#getRegistrationNumber()}.
	 */
	@Test
	public final void testGetRegistrationNumber() {
		assertNotSame(tester.getRegistrationNumber(), RegistrationNumber.getInstance('a', 1234));
		assertNotNull(tester.getRegistrationNumber());
		assertTrue(tester.getRegistrationNumber() == tester2.getRegistrationNumber());
	}

	/**
	 * Test method for {@link carRental.AbstractCar#getFuelCapacity()}.
	 */
	@Test
	public final void testGetFuelCapacity() {
		assertNotSame(tester.getFuelCapacity(), 69);
		assertNotNull(tester.getFuelCapacity());
		assertEquals(49, tester.getFuelCapacity());
	}

	/**
	 * Test method for {@link carRental.AbstractCar#getFuelInCar()}.
	 */
	@Test
	public final void testGetFuelInCar() {
		assertEquals(10, tester.getFuelInCar());
		assertNotNull(tester.getFuelInCar());
		assertNotSame(50060606, tester.getFuelInCar());
	}

	/**
	 * Test method for {@link carRental.AbstractCar#isCarFuelTankFull()}.
	 */
	@Test
	public final void testIsCarFuelTankFull() {
		assertTrue(tester.isCarFuelTankFull() == false);
		assertNotNull(tester.isCarFuelTankFull());
		assertFalse(tester.isCarFuelTankFull() == true);
	}

	/**
	 * Test method for {@link carRental.AbstractCar#isCarRented()}.
	 */
	@Test
	public final void testIsCarRented() {
		assertTrue(tester.isCarRented() == true);
		assertNotNull(tester.isCarRented());
		assertSame(tester.isCarRented(), tester3.isCarRented());
	}

}
